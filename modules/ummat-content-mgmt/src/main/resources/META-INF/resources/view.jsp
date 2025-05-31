<%@ include file="init.jsp" %>

<%
List<AssetCategory> parentCategories = (List<AssetCategory>) request.getAttribute("parentCategories");

PortletURL subCategoriesURL = renderResponse.createRenderURL();
subCategoriesURL.setParameter("mvcPath", "/display_subcategory.jsp");
%>

<div class="row">
	<%
		for(AssetCategory assetCategory: parentCategories){
			subCategoriesURL.setParameter("parentCategoryId", String.valueOf(assetCategory.getCategoryId()));
	%>
		<div class="col-md-4">
			<a href="<%= subCategoriesURL.toString() %>">
				<%= assetCategory.getTitle(themeDisplay.getLocale()) %>
			</a>
		</div>
	<%
		}
	%>
</div>