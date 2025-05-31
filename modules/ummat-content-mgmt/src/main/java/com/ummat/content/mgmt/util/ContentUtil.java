package com.ummat.content.mgmt.util;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleDisplay;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

public class ContentUtil {
	
	public static String getArticleContent(long resourcePrimKey, ThemeDisplay themeDisplay) {
		
		try {
			JournalArticle journalArticle = JournalArticleLocalServiceUtil.fetchLatestArticle(resourcePrimKey);
			JournalArticleDisplay articleDisplay =  JournalArticleLocalServiceUtil.getArticleDisplay(
					themeDisplay.getScopeGroupId(),
					journalArticle.getArticleId(),WebKeys.WINDOW_STATE,themeDisplay.getLanguageId(),themeDisplay);
			return articleDisplay.getContent();
		} catch (PortalException e) {
			LOGGER.error("Exception Occured "+e.getLocalizedMessage());
		}
		 
		return StringPool.BLANK;
	}
	
	private static final Log LOGGER = LogFactoryUtil.getLog(ContentUtil.class);

}
