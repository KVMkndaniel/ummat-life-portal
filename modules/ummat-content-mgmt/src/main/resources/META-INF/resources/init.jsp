<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay"%>

<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.asset.kernel.model.AssetCategory"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.List"%>

<%@page import="com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />