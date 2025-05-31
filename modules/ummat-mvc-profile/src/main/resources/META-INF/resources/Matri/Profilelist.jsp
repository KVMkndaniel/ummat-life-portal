<%@page import="java.util.Calendar"%>
<%@page import="java.time.Period"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="../init.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>


<portlet:resourceURL var="addEditVisitorUrl">
	<portlet:param name="cmd" value="addEditVisitor"/>
</portlet:resourceURL>

<%
	PortletURL informationRenderURL = renderResponse.createRenderURL();
    informationRenderURL.setParameter("jspPage","/Matri/ProfileDetails.jsp" );
    List<District> districtList = new ArrayList<>();
    List<Region> regionsForCountry = new ArrayList<>();
    
    if(Validator.isNotNull(request.getAttribute("districtLists"))){
    	districtList = (List) request.getAttribute("districtLists");
    	
    }
    if(Validator.isNotNull(request.getAttribute("regionLists"))){
    	regionsForCountry =  (List)request.getAttribute("regionLists");
    }
    List<Long> excludedProfileIds = List.of();
	List<User> currentProfiles = (List) request.getAttribute("currentProfilesSearch");
	if (Validator.isNull(currentProfiles)) {
		currentProfiles = (List) request.getAttribute("currentProfiles");
	}
	  //  List<MatriUser> matriUserList = MatriUserLocalServiceUtil.getMatriUsers(-1, -1);
      List<MatriUser> matriUserList = (List) request.getAttribute("matriUserList");
    System.out.println("Size of matriUserList: " + matriUserList.size());
    
	
%>


<!--Slider Start-->
<div class="slider-wrap" id="filter-bar">
  <div class="container">
    <div class="topsearchform">
      <div class="searhint">
        <h3>Search Your Soul Mates</h3>
        <div class="searchbox">
          <div class="row">
            <div class="col-lg-2 col-md-4">
              <div class="srchfld">
                <label for="">I'm looking for</label>
                <select id="genderSelect" class="form-control">
                  <option>I'm looking for a</option>
						<option value="all">All</option>
						<option value="male">Male</option>
						<option value="female">Female</option>
                </select>
                
                <input type="hidden" id="genderhidden" value="" /> 
                <input type="hidden" id="jamathhidden" value="" /> 
                <input type="hidden" id="statehidden" value="" /> 
                <input type="hidden" id="disthidden" value="" /> 
                <input type="hidden" id="areahidden" value="" /> 
                <input type="hidden" id="useridhidden" value="" /> 
                <input type="hidden" id="languagehidden" value="" /> 
                <input type="hidden" id="agehidden" value="" /> 
                <input type="hidden" id="professionhidden" value="" />
              </div>
            </div>
            <div class="col-lg-2 col-md-4">
              <div class="srchfld">
                <label for="">Select state</label>
                <select name="state" id="selectedState" class="form-control">
                 <option disabled selected>Select state</option>
						
						<%
        for (Region stateListItem : regionsForCountry) {    
        %>
						<option value="<%= stateListItem.getRegionCode() %>"><%= stateListItem.getName() %></option>
						<%
        }
        %>
                </select>
               <script>
    $("#selectedState").on("change", selectedState);

    function selectedState() {
        var regionCode = $("#selectedState").val();
        Liferay.Service(
            '/district/get-by-region-code', // Updated to use regionId
            {
            	regionCode: regionCode
            },
            function(data) {
                var districtList = data;
                $('#selectedDistrict').empty();
                $('#selectedDistrict').append('<option value="">Select District</option>'); // Optional: Add default option
                for (var i in districtList) {
                    $('#selectedDistrict').append(
                        "<option value='" + districtList[i].districtId + "'>" + districtList[i].name + "</option>"
                    );
                }
            }
        );
    }
</script>
              </div>
            </div>
            <div class="col-lg-2 col-md-4">
              <div class="srchfld">
                <label for="">Select Profession</label>
                <select name="district" id="selectedDistrict" class="form-control">
               <option value="">Select District</option>
						<script>
								$("#selectedDistrict").on("change",
										selectedDistrict);
								function selectedDistrict() {
									var districtId = $("#selectedDistrict")
											.val();
									Liferay
											.Service(
													'/locality/get-locality-by-district-id',
													{
														districtId : districtId
													},
													function(data) {
														var areaNameList = data;
														$('#availableLocality')
																.empty();
														for ( var i in areaNameList) {
															$(
																	'#availableLocality')
																	.append(
																			"<option value='"+ areaNameList[i].name +"'>"
																					+ areaNameList[i].name
																					+ "</option>");
														}
													});
								}
							</script>
					</select>
               
              </div>
            </div>
            
           <div class="col-lg-2 col-md-4">
              <div class="srchfld">
                <label for="">Select Profession</label>
                <select name="area" id="availableLocality" class="form-control" onchange="selectArea(this)">
                <option disabled selected>Selected Profession</option>
						<option value="">Select Area</option>
                </select>
               
              </div>
            </div>
            
            <div class="col-lg-2 col-md-4">
              <div class="srchfld">
                <label for="">Select  Jamath</label>
                <select  id="typeSelect" class="form-control">
                  <option value="All">All Jamath</option>
						<option value="thowheedJamath">Thowheed Jamath</option>
						<option value="sunnathwalJamath">Sunnathwal Jamath</option>
						<option value="tNTJ">TNTJ</option>
						<option value="others">Others</option>
                </select>
              </div>
            </div>
            
            <div class="col-lg-2 col-md-4">
              <div class="srchfld">
                <label for="">&nbsp;</label>
                <button type="submit" class="btn"><i class="fas fa-search"></i> Search</button> 
              </div>
            </div>
          </div>
        </div>
        <div class="advsearch"><a href="advance-search.html"><i class="fas fa-search"></i> Advance Search</a></div>
      </div>
    </div>
  </div>
</div>
<!--Slider End--> 


<!--Latest Brides Start-->
<div class="bride-wrap">
  <div class="container" id="resultsContainer">
    <div class="title">
      <h1>Latest<span> Brides</span></h1>
      <div class="bar"></div>
    </div>
    <ul class="row"  id="userList">
    <%        
             int pageSize = 10; 
            int totalPages = (int) Math.ceil((double) matriUserList.size() / pageSize);
            int currentPage = ParamUtil.getInteger(request, "page", 1);
            
         
            int startIndex = (currentPage - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, matriUserList.size());

          
            List<MatriUser> currentPageUsers = matriUserList.subList(startIndex, endIndex);
            for (MatriUser matrimonyUser : currentPageUsers) {
                long userId = matrimonyUser.getUserId();
                User userItems = UserLocalServiceUtil.fetchUser(userId);
                
                
                
                // Check if the user ID is not excluded
                if (Validator.isNotNull(userItems) && !excludedProfileIds.contains(userId)&& userItems.getStatus() == 0) {
                	
        %>
        
        <%@ page import="java.text.SimpleDateFormat, java.util.Date" %>
      <li class="col-lg-4 col-md-6">
        <div class="brideList">
          <div class="brideImg"><img src="<%= userItems.getPortraitURL(themeDisplay) %>" alt=""></div>
          <div class="profileInfo">
            <div class="name"><%= userItems.getFullName() %></div>
            <ul>
              <li><%= matrimonyUser.getJamath() %></li>
              <%
                        Date birthday = userItems.getBirthday(); 
                        Calendar birthCal = Calendar.getInstance(); 
                        birthCal.setTime(birthday); 
                        Calendar today = Calendar.getInstance(); 
                        int age = today.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR); 
                        if (today.get(Calendar.DAY_OF_YEAR) < birthCal.get(Calendar.DAY_OF_YEAR)) { 
                            age--; 
                        } 
                    %>
              <li><%=age %></li>
              <li><%= userItems.getJobTitle()%></li>
              <li><%=matrimonyUser.getStateName() %>, <%=matrimonyUser.getDistrictName()%></li>
            </ul>
            <% 
                     
                        informationRenderURL.setParameter("userId",String.valueOf(userItems.getUserId())); 
                    		
                    %>
            <div class="viewbtn"><a href="<%= informationRenderURL %>">View Profile</a></div>
          </div>
        </div>
      </li>
       <% 
                } 
            }
        %>
    </ul>
  </div>
</div>
<!--Latest Brides End--> 


<style>
h2.portlet-title-text {
	display: none !important;
}

.portlet-decorate .portlet-content {
    padding: 0rem !important;
    }
/* 
search logic css */

h2.portlet-title-text.portlet-title-editable {
    display: none !important;
} 


</style>
<aui:script>
AUI().use('aui-base', 'aui-io-request', function(A) {
  <!--    Ensure the document is ready before binding the change event -->

    A.all('#genderSelect').on('change', function() { 
    var selectedGenders = []; 
    var allChecked = false; 
   	
    A.all('#genderSelect option:checked').each(function(node) { 
        var value = node.get('value'); 
        if (value === 'all') { 
            allChecked = true; 
        } else { 
            selectedGenders.push(value); 
        } 
    }); 
    if (allChecked) { 
        selectedGenders = ['all']; 
    }
    alert(selectedGenders);   
    var genderhidden = document.getElementById("genderhidden"); 
    genderhidden.value = selectedGenders.join(',');  
    filterUsersByGender(); 
});


	A.all('#typeSelect').on('change', function() {
	var selectElement = document.getElementById("typeSelect");

        // Get the selected value
        var selectedValue = selectElement.value;
		var jamathhidden = document.getElementById("jamathhidden");
        // Set the value of the hidden field
        jamathhidden.value = selectedValue;
        filterUsersByGender();
    });
    
    	A.all('#languageSelect').on('change', function() {
	var selectElement = document.getElementById("languageSelect");

        // Get the selected value
        var selectedValue = selectElement.value;
		var languagehidden = document.getElementById("languagehidden");
        // Set the value of the hidden field
        languagehidden.value = selectedValue;
        filterUsersByGender();
    });
    
    A.all('#age').on('change', function() {
	var selectElement = document.getElementById("age");

        // Get the selected value
        var selectedValue = selectElement.value;
		var agehidden = document.getElementById("agehidden");
        // Set the value of the hidden field
        agehidden.value = selectedValue;
        filterUsersByGender();
    });
    
    A.all('#profession').on('change', function() {
	var selectElement = document.getElementById("profession");

        // Get the selected value
        var selectedValue = selectElement.value;
		var professionhidden = document.getElementById("professionhidden");
        // Set the value of the hidden field
        professionhidden.value = selectedValue;
        filterUsersByGender();
    });
    
    <!-- userid -->
    A.all('#searchProfile').on('change', function() {
	var selectElement = document.getElementById("searchProfile");

        // Get the selected value
        var selectedValue = selectElement.value;
		var useridhidden = document.getElementById("useridhidden");
        // Set the value of the hidden field
        useridhidden.value = selectedValue;
        filterUsersByGender();
    });
    
    	A.all('#selectedState').on('change', function() {
	var selectElement = document.getElementById("selectedState");

        // Get the selected value
        var selectedValue = selectElement.value;
		var statehidden = document.getElementById("statehidden");
        // Set the value of the hidden field
        statehidden.value = selectedValue;
        filterUsersByGender();
    });
    
    	A.all('#selectedDistrict').on('change', function() {
	var selectElement = document.getElementById("selectedDistrict");

        // Get the selected value
        var selectedValue = selectElement.value;
		var disthidden = document.getElementById("disthidden");
        // Set the value of the hidden field
        disthidden.value = selectedValue;
        filterUsersByGender();
    });
    
    	A.all('#availableLocality').on('change', function() {
	var selectElement = document.getElementById("availableLocality");

        // Get the selected value
        var selectedValue = selectElement.value;
		var areahidden = document.getElementById("areahidden");
        // Set the value of the hidden field
        areahidden.value = selectedValue;
        filterUsersByGender();
    });
    
    A.all('#languageSelect').on('change', function() {
	var selectElement = document.getElementById("languageSelect");

        // Get the selected value
        var selectedValue = selectElement.value;
		var languagehidden = document.getElementById("languagehidden");
        // Set the value of the hidden field
        languagehidden.value = selectedValue;
        filterUsersByGender();
    });

    function filterUsersByGender() {
      <!--   // Resource URL with the correct ID -->
        var resourceURL = '<portlet:resourceURL id="Gnder" />';
		 var gender = document.getElementById("genderhidden").value;
		 var jamadh = document.getElementById("jamathhidden").value;
		 var state = document.getElementById("statehidden").value;
		 var dist = document.getElementById("disthidden").value;
		 var area = document.getElementById("areahidden").value;
		 var profileid = document.getElementById("useridhidden").value;
		 var languages = document.getElementById("languagehidden").value;
		 var agefilters = document.getElementById("agehidden").value;
		 var profession = document.getElementById("professionhidden").value;
	
		<!-- // var gen = genders.join(','); -->
		// var gen =Array.from(gender);
//Array.from(str);
		 var params = gender+'|'+jamadh+'|'+state+'|'+dist+'|'+area+'|'+profileid+'|'+languages+'|'+agefilters+'|'+profession;
			alert(params);
        A.io.request(resourceURL, {
            dataType: 'json',
            method: 'GET',
            data: { genders:params, },
            on: {
                success: function() {
                    var response = this.get('responseData');
                    var filteredUsers = response.currentProfiles;
                    var userListHtml = '';

                    // Iterate over filtered users and construct HTML
                    A.Array.each(filteredUsers, function(user) {
                         userListHtml += '<li class="col-lg-4 col-md-6">' + 
    '<div class="brideList">' + 
        '<div class="brideImg">' + 
            '<img src="' + user.portraitURL + '" alt="User Image">' + 
        '</div>' + 
        '<div class="profileInfo">' + 
            '<div class="name">' + user.fullName + '</div>' + 
            '<ul>' + 
                '<li>' + user.Jamath + '</li>' + 
                '<li>' + user.age + '</li>' +  // You must calculate age and include it in the user object
                '<li>' + user.jobTitle + '</li>' + 
                '<li>' + user.stateName + ', ' + user.districtName + '</li>' + 
            '</ul>' + 
            '<div class="viewbtn">' + 
                '<a href="' + user.informationRenderURL + '">View Profile</a>' + 
            '</div>' + 
        '</div>' + 
    '</div>' + 
'</li>';


                    });

                    // Update the user list in the DOM
                    A.one('#userList').setHTML(userListHtml);
                },
                failure: function() {
                    console.error('Error fetching filtered users');
                }
            }
        });
    }
});
</aui:script>




<script>

/*----Mobile-View-FilterBar-------*/

function FilterBar() {
	var filterBar = document.getElementById('filter-bar');
	filterBar.classList.toggle('active');    

}

</script>










