package com.ummat.content.mgmt.portlet;

import com.ummat.content.mgmt.constants.UmmatContentMgmtPortletKeys;
import com.ummat.content.mgmt.util.ContentUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.asset.kernel.service.AssetVocabularyLocalService;
import com.liferay.asset.kernel.service.persistence.AssetEntryQuery;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Gayathri
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=UMMAT",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=UmmatContentMgmt",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + UmmatContentMgmtPortletKeys.UMMATCONTENTMGMT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class UmmatContentMgmtPortlet extends MVCPortlet {
	
	private static final Log LOGGER = LogFactoryUtil.getLog(UmmatContentMgmtPortlet.class);
	
	@Override
	public void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException {
		
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		List<AssetCategory> parentCategories = new ArrayList<AssetCategory>();
		
		List<AssetVocabulary> assetVocabularies = _assetVocabularyService.getAssetVocabularies(QueryUtil.ALL_POS, 
				QueryUtil.ALL_POS);
		long vocabularyId = 0;
		for(AssetVocabulary assetVocabulary: assetVocabularies) {
			if(assetVocabulary.getTitle(themeDisplay.getLocale()).equalsIgnoreCase(UmmatContentMgmtPortletKeys.EDUCATION_VOC)) {
				vocabularyId = assetVocabulary.getVocabularyId();
				break;
			}
		}
		
		if(vocabularyId > 0) {
			parentCategories = _assetCategoryLocalService.getVocabularyRootCategories(vocabularyId, 
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, (OrderByComparator)null);
		}
		
		request.setAttribute("parentCategories", parentCategories);
		super.doView(request, response);
		
	}
	
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		if(resourceRequest.getResourceID().equalsIgnoreCase(UmmatContentMgmtPortletKeys.DISPLAY_CONTENT_RES_ID)) {
			
			long categoryId = ParamUtil.getLong(resourceRequest, "categoryId");
			long classNameId = ParamUtil.getLong(resourceRequest, "classNameId");
			
			StringBuilder responseData = new StringBuilder();
			responseData.append("<div id='categoryTbl"+categoryId+"'>");
			
			AssetEntryQuery aeq = new AssetEntryQuery();
			aeq.setAllCategoryIds(new long[]{categoryId});
			aeq.setClassNameIds(new long[]{classNameId});
			List<AssetEntry> entries = _assetEntryService.getEntries(aeq);
			
			for(AssetEntry article: entries){
				responseData.append(ContentUtil.getArticleContent(article.getClassPK(), themeDisplay));
			}
			
			try {
				PrintWriter writer = resourceResponse.getWriter();
				writer.write(responseData+"</div>");
		  		writer.flush();
		  		writer.close();
			} catch (IOException e) {
				LOGGER.error("Exception Occured "+e.getLocalizedMessage());
			}
		}
	
		try {
			super.serveResource(resourceRequest, resourceResponse);
		} catch (IOException | PortletException e) {
			LOGGER.error("Exception Occured "+e.getLocalizedMessage());
		}
	}
	
	
	@Reference
	private AssetVocabularyLocalService _assetVocabularyService;
	
	@Reference
	private AssetCategoryLocalService _assetCategoryLocalService;
	
	@Reference
	private AssetEntryLocalService _assetEntryService;
}