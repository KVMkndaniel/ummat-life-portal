<%@page import="com.ummat.content.mgmt.util.ContentUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetEntry"%>
<%@page import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.journal.model.JournalArticle"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.asset.kernel.service.persistence.AssetEntryQuery"%>
<%@ include file="init.jsp" %>

<%
long parentCategoryId = ParamUtil.getLong(renderRequest, "parentCategoryId");

List<AssetCategory> childCategoriesList = AssetCategoryLocalServiceUtil.getChildCategories(parentCategoryId);
long firstCategoryId = 0;
long classNameId = PortalUtil.getClassNameId(JournalArticle.class.getName());
%>

<div class="row">
	<div class="col-md-4 subcategories">
		<%
		for(AssetCategory mainCategory: childCategoriesList){
			if(firstCategoryId == 0){
				firstCategoryId = mainCategory.getCategoryId();
			}
			List<AssetCategory> firstList = AssetCategoryLocalServiceUtil.getChildCategories(mainCategory.getCategoryId());
		%>
		
			<div onclick="displayContentByCategory('<%=mainCategory.getCategoryId()%>',this)">
				<clay:icon symbol="angle-down"/> <span><%= mainCategory.getTitle(themeDisplay.getLocale()) %></span>
			</div>
			
			<%
				for(AssetCategory firstSub: firstList){ 
					List<AssetCategory> secondList = AssetCategoryLocalServiceUtil.
							getChildCategories(firstSub.getCategoryId());
			%>
				<div class="secondLevel" onclick="displayContentByCategory('<%=firstSub.getCategoryId()%>',this)">
					<clay:icon symbol="categories"/> <span><%= firstSub.getTitle(themeDisplay.getLocale()) %></span>
				</div>
				<%
					for(AssetCategory secondSub: secondList){
						List<AssetCategory> thirdList = AssetCategoryLocalServiceUtil.
								getChildCategories(secondSub.getCategoryId());
				%>
				
				  <div class="thirdLevel" onclick="displayContentByCategory('<%=secondSub.getCategoryId()%>',this)">
					<clay:icon symbol="categories"/> <span><%= secondSub.getTitle(themeDisplay.getLocale()) %></span>
				  </div>
					<%
						for(AssetCategory thirdSub: thirdList){
					%>
						<span class="final" onclick="displayContentByCategory('<%=thirdSub.getCategoryId()%>',this)">
							<%= thirdSub.getTitle(themeDisplay.getLocale()) %>
						</span>
						
						<br/>
					
					<%} %>
				
				<%} %>
			
			<%} %>
		<%
		}
		%>
	</div>
	<div class="col-md-8">
		<div id="displayContent">
			<%
				AssetEntryQuery aeq = new AssetEntryQuery();
				aeq.setAllCategoryIds(new long[]{firstCategoryId});
				aeq.setClassNameIds(new long[]{classNameId});
				List<AssetEntry> entries = AssetEntryLocalServiceUtil.getEntries(aeq);
				for(AssetEntry entry: entries){
			%>
			
				<%= ContentUtil.getArticleContent(entry.getClassPK(), themeDisplay) %>
			
			<%} %>
		</div>
	</div>
</div>


<script>
function displayContentByCategory(categoryId, element){
	$('#displayContent').html('');
	
		$.ajax({
			url: "<portlet:resourceURL id='DISPLAY_CONTENT'/>",
			type: 'POST',
			data:{
				'<portlet:namespace/>categoryId':categoryId,
				'<portlet:namespace/>classNameId':'<%= classNameId %>',
				'<portlet:namespace/>cmd': 'category'
			},
			success: function(response){
				if(response == ''){
					response = "<div style='text-align:center'>Content Not Found</div>";
				}
				$('#displayContent').html(response);
				
			}
		});
	
	$('#categoryTbl'+categoryId).show();
	
}
</script>