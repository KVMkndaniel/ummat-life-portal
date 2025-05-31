package ummat.users.auth.portlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalService;
import com.liferay.list.type.service.ListTypeEntryLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.ummat.slayer.model.District;
import com.ummat.slayer.model.Locality;
import com.ummat.slayer.service.DistrictLocalService;
import com.ummat.slayer.service.LocalityLocalService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ummat.users.auth.constants.UmmatMatriAccountPortletKeys;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=false", "javax.portlet.display-name=UmmatMatriCreateAccount",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/Matri/create_account.jsp",
		"javax.portlet.name=" + UmmatMatriAccountPortletKeys.MATRI_CREATE_ACCOUNT,
		"javax.portlet.resource-bundle=content.Language", "com.liferay.portlet.requires-namespaced-parameters=false",
		"javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class UmmatMatriAccountPortlet extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException {
		
		log.info("Executing doview method....");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		ListTypeDefinition edutionDef = _listTypeDefinitionLocalService.fetchListTypeDefinitionByExternalReferenceCode(
				UmmatMatriAccountPortletKeys.EDUCATION_PICKLIST_ERC, themeDisplay.getCompanyId());
		
		List<ListTypeEntry> educationEntries = _listTypeEntryLocalService.getListTypeEntries(
				edutionDef.getListTypeDefinitionId());
		
		ListTypeDefinition jamathDef = _listTypeDefinitionLocalService.fetchListTypeDefinitionByExternalReferenceCode(
				UmmatMatriAccountPortletKeys.JAMATH_PICKLIST_ERC, themeDisplay.getCompanyId());
		
		List<ListTypeEntry> jamathEntries = _listTypeEntryLocalService.getListTypeEntries(
				jamathDef.getListTypeDefinitionId());
		
		ListTypeDefinition maritalStatusDef = _listTypeDefinitionLocalService.fetchListTypeDefinitionByExternalReferenceCode(
				UmmatMatriAccountPortletKeys.MARITAL_STATUS_PL_ERC, themeDisplay.getCompanyId());
		
		List<ListTypeEntry> martialStatusEntries = _listTypeEntryLocalService.getListTypeEntries(
				maritalStatusDef.getListTypeDefinitionId());
		
		ListTypeDefinition colorDef = _listTypeDefinitionLocalService.fetchListTypeDefinitionByExternalReferenceCode(
				UmmatMatriAccountPortletKeys.COLOR_PL_ERC, themeDisplay.getCompanyId());
		
		List<ListTypeEntry> colorEntries = _listTypeEntryLocalService.getListTypeEntries(
				colorDef.getListTypeDefinitionId());
		
		ListTypeDefinition occupationDef = _listTypeDefinitionLocalService.fetchListTypeDefinitionByExternalReferenceCode(
				UmmatMatriAccountPortletKeys.OCCUPATION_PL_ERC, themeDisplay.getCompanyId());
		
		List<ListTypeEntry> occupationEntries = _listTypeEntryLocalService.getListTypeEntries(
				occupationDef.getListTypeDefinitionId());
		
		ListTypeDefinition motherTongueDef = _listTypeDefinitionLocalService.fetchListTypeDefinitionByExternalReferenceCode(
				UmmatMatriAccountPortletKeys.MOTHER_TONGUE_PL_ERC, themeDisplay.getCompanyId());
		
		List<ListTypeEntry> motherTongueEntries = _listTypeEntryLocalService.getListTypeEntries(
				motherTongueDef.getListTypeDefinitionId());
		
		ListTypeDefinition heightDef = _listTypeDefinitionLocalService.fetchListTypeDefinitionByExternalReferenceCode(
				UmmatMatriAccountPortletKeys.HEIGHT_PL_ERC, themeDisplay.getCompanyId());
		
		List<ListTypeEntry> heightEntries = _listTypeEntryLocalService.getListTypeEntries(
				heightDef.getListTypeDefinitionId());
		
		request.setAttribute("educations", educationEntries);
		request.setAttribute("jamaths", jamathEntries);
		request.setAttribute("maritalStatus", martialStatusEntries);
		request.setAttribute("colors", colorEntries);
		request.setAttribute("occupations", occupationEntries);
		request.setAttribute("motherTongueLangs", motherTongueEntries);
		request.setAttribute("heights", heightEntries);
		
		super.doView(request, response);
		
	}
	
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		
		log.info("Executing serve resource for : "+resourceRequest.getResourceID());
		
		if(resourceRequest.getResourceID().equalsIgnoreCase(UmmatMatriAccountPortletKeys.DISTRICT_RESOURCE_KEY)) {
			
			long regionId = ParamUtil.getLong(resourceRequest, "regionId");
			
			StringBuilder districtStr = new StringBuilder();
			districtStr.append(UmmatMatriAccountPortletKeys.OPTION_START_TAG);
			districtStr.append(StringPool.BLANK);
			districtStr.append(UmmatMatriAccountPortletKeys.OPTION_MIDDLE_TAG);
			districtStr.append(UmmatMatriAccountPortletKeys.DISTRICT_EMPTY_OPT_LABEL);
			districtStr.append(UmmatMatriAccountPortletKeys.OPTION_END_TAG);
			
			List<District> districts = _districtLocalService.getByRegionId(regionId);
			
			for(District district: districts) {
				
				districtStr.append(UmmatMatriAccountPortletKeys.OPTION_START_TAG);
				districtStr.append(district.getDistrictId());
				districtStr.append(UmmatMatriAccountPortletKeys.OPTION_MIDDLE_TAG);
				districtStr.append(district.getName());
				districtStr.append(UmmatMatriAccountPortletKeys.OPTION_END_TAG);
			}
			
			PrintWriter out = resourceResponse.getWriter();
			out.println(districtStr);
			out.flush();
		}else if(resourceRequest.getResourceID().equalsIgnoreCase(UmmatMatriAccountPortletKeys.LOCALITY_RESOURCE_KEY)) {
			
			long districtId = ParamUtil.getLong(resourceRequest, "districtId");
			
			StringBuilder localityStr = new StringBuilder();
			localityStr.append(UmmatMatriAccountPortletKeys.OPTION_START_TAG);
			localityStr.append(StringPool.BLANK);
			localityStr.append(UmmatMatriAccountPortletKeys.OPTION_MIDDLE_TAG);
			localityStr.append(UmmatMatriAccountPortletKeys.AREA_EMPTY_OPT_LABEL);
			localityStr.append(UmmatMatriAccountPortletKeys.OPTION_END_TAG);
			
			List<Locality> localities = _localityLocalService.getLocalityByDistrictId(districtId);
			
			for(Locality locality: localities) {
				
				localityStr.append(UmmatMatriAccountPortletKeys.OPTION_START_TAG);
				localityStr.append(locality.getLocalityId());
				localityStr.append(UmmatMatriAccountPortletKeys.OPTION_MIDDLE_TAG);
				localityStr.append(locality.getName());
				localityStr.append(UmmatMatriAccountPortletKeys.OPTION_END_TAG);
			}
			
			PrintWriter out = resourceResponse.getWriter();
			out.println(localityStr);
			out.flush();
		}
		
		super.serveResource(resourceRequest, resourceResponse);
	}
	
	@Reference
	private ListTypeDefinitionLocalService _listTypeDefinitionLocalService;

	@Reference
	private ListTypeEntryLocalService _listTypeEntryLocalService;
	
	@Reference
	private LocalityLocalService _localityLocalService;
	
	@Reference
	private DistrictLocalService _districtLocalService;
	
	private static final Log log = LogFactoryUtil.getLog(UmmatMatriAccountPortlet.class.getName());


}
