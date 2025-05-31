<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletResponse"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page
	import="com.liferay.portal.kernel.service.RegionLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Region"%>
<%@page import="ummat_startup_details.service.MatriUserLocalServiceUtil"%>
<%@page import="ummat_startup_details.model.MatriUser"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page
	import="com.liferay.portal.kernel.service.UserGroupLocalServiceUtil"%>
<%@page import="com.liferay.headless.admin.user.dto.v1_0.UserGroup"%>
<%@page import="com.liferay.portal.kernel.model.Groups_UserGroupsTable"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.ummat.slayer.model.District"%>
<%@page import="com.liferay.headless.admin.user.dto.v1_0.UserGroup"%>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletResponse" %>

<%@page import="java.io.Serializable"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.util.List"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />