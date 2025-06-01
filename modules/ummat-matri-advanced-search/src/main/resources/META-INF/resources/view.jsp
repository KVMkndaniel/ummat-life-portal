<%@ include file="./init.jsp" %>
<%@page import="java.time.Period"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.ArrayList"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>


<portlet:resourceURL var="addEditVisitorUrl">
	<portlet:param name="cmd" value="addEditVisitor"/>
</portlet:resourceURL>

<%
	PortletURL informationRenderURL = renderResponse.createRenderURL();
    informationRenderURL.setParameter("jspPage","/userdetails.jsp" );
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
<!--Inner Heading Start-->
<div class="inner-heading">
  <div class="container">
    <h3>Search Result</h3>
  </div>
</div>
<!--Inner Heading End--> 

<!--Inner Content Start-->
<div class="inner-content" id="filter-bar">
  <div class="container-fluid"> 
    
    <!--Listing Start-->
    <div class="listing-wrap">
      <div class="row">
        <div class="col-lg-3">
          <div class="listingLeft">
            <div class="title">
              <h1>Quick <span>Search</span></h1>
            </div>
            <input type="hidden" id="genderhidden" value="" />
    <input type="hidden" id="jamathhidden" value="" />
    <input type="hidden" id="statehidden" value="" />
    <input type="hidden" id=disthidden value="" />
    <input type="hidden" id="areahidden" value="" /> 
    <input type="hidden" id="useridhidden" value="" /> 
     <input type="hidden" id="languagehidden" value="" /> 
      <input type="hidden" id="agehidden" value="" /> 
        <input type="hidden" id="professionhidden" value="" /> 
            <form>
              <div class="input-group">
                <label class="input-group-append">Bride/Groom</label>
                <select name="br_gr" class="form-control" id="genderSelect">
                  <option value="all">All</option>
                  <option value="male">Groom(Male)</option>
                  <option value="female" selected="selected">Bride(Female)</option>
                </select>
              </div>
              <!-- <div class="input-group">
                <label class="input-group-append">Age From</label>
                <select id="age" class="form-control">
                  <option value="0">From</option>
                  <option value="18" selected="">18</option>
                 
                </select>
              </div> -->
              <div class="input-group">
                <label class="input-group-append">Selected age</label>
                <select id="age"  class="form-control">
                  <option disabled selected>Selected age</option>
					<option value="18to21">18 to 21</option>
					 <option value="21to25">21 to 25</option>
					 <option value="25to28">25 to 28</option>
					 <option value="29to32">29to32</option>
					 <option value="32toAbove">32 to above</option>
                 
                </select>
              </div>
              <div class="input-group">
                <label class="input-group-append">Marital Status</label>
                <select name="maritalstatus" class="form-control" id="maritalstatus" onchange="getMaritalMore(this.value);">
                  <option value="">-- No Preference --</option>
                  <option value="Never Married">Never Married</option>
                  <option value="Married but looking">Married but looking</option>
                  <option value="Divorced">Divorced</option>
                  <option value="Widowed">Widowed</option>
                  <option value="Separated">Separated</option>
                </select>
              </div>
              <div class="input-group checkbox">
                <input type="checkbox" name="checkname" id="3dgraphic">
                <label for="3dgraphic"></label>
                Only with pictures </div>
              <div class="input-group">
                <label class="input-group-append">Select State</label>
                <select name="state" class="form-control" id="selectedState">
                 <option value="">Select State</option>
        <%
        for (Region stateListItem : regionsForCountry) {    
        %>
            <option value="<%= stateListItem.getRegionId() %>"><%= stateListItem.getName() %></option>
        <%
        }
        %>
                 
                </select>
                  <script>
    $("#selectedState").on("change", selectedState);

    function selectedState() {
        var regionId = $("#selectedState").val();
        Liferay.Service(
            '/district/get-by-region-id', // Updated to use regionId
            {
                regionId: regionId
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
              <div class="input-group">
                <label class="input-group-append">Select District</label>
                <select name="district" class="form-control" id="selectedDistrict">
                    <option value="">Select District</option>
                </select>
              </div>
              <div class="input-group">
                <label class="input-group-append">Select Area</label>
                <select name="area" class="form-control"  id="availableLocality">
                    <option value="">Select District</option>
                </select>
              </div>
              <script>
    $("#selectedDistrict").on("change", selectedDistrict);
    function selectedDistrict() {
        var districtId = $("#selectedDistrict").val();
        Liferay.Service(
            '/locality/get-locality-by-district-id',
            {
                districtId: districtId
            },
            function(data) {
                var areaNameList = data;
                $('#availableLocality').empty();
                $('#availableLocality').append('<option value="">Select Area</option>'); // Optional default
                for (var i in areaNameList) {
                    $('#availableLocality').append(
                        "<option value='" + areaNameList[i].name + "'>" + areaNameList[i].name + "</option>"
                    );
                }
            }
        );
    }
</script>
             <!--  <div class="input-group">
                <label class="input-group-append">Caste</label>
                <input type="text" class="form-control" name="caste" placeholder="Caste">
              </div> -->
              <div class="input-group">
                <label class="input-group-append">Education</label>
                <select name="education" class="form-control" id="education">
                  <option value="">-- No Preference --</option>
                  
                </select>
              </div>
           <!--    <div class="input-group">
                <label class="input-group-append">Other Nationality</label>
                <select name="nationality" class="form-control" id="nationality">
                  <option value="">-- No Preference --</option>
                 
                </select>
              </div> -->
              <div class="input-group">
                <label class="input-group-append">All Jamath</label>
                <select class="form-control" id="typeSelect">
                   <option value="All">All Jamath</option>
      <option value="thowheedJamath"> Thowheed Jamath</option>
      <option value="sunnathwalJamath"> Sunnathwal Jamath</option>
      <option value="tNTJ"> TNTJ</option>
      <option value="others">Others</option>
                
                </select>
              </div>
             <!--  <div class="input-group">
                <input type="submit" value="Search" class="sub">
              </div> -->
            </form>
          </div>
        </div>
        <div class="col-lg-9">
          <div class="alert listalert"> <span class="email-jobs-inline email-jobs-center signed-out gtmEmailMeJobsInline btn-job-alert"> <a class="btn btn-secondary" data-toggle="modal" data-target="#show_alert" href="javascript:;"><i class="far fa-bell"></i> Get Alerts</a> </span> Get the latest Bride or Grooms Alerts sent directly to your inbox. </div>
          <div class="modal fade" id="show_alert" role="dialog">
            <div class="modal-dialog"> 
              
              <!-- Modal content-->
              <div class="modal-content">
                <form id="submit_alert">
                  <div class="modal-header">
                    <h4 class="modal-title">Create Alert</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                  </div>
                  <div class="modal-body">
                    <h3>Get the latest <strong>Bride</strong> matching profiles straight to your inbox</h3>
                    <div class="form-group">
                      <input type="text" class="form-control" name="email" id="email" placeholder="Enter your Email" value="">
                    </div>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Submit</button>
                  </div>
                </form>
              </div>
            </div>
          </div>
          <div class="displayresult">
            <div class="row">
              <div class="col-lg-3">
                <div class="listby"> <a href="listing.html" title="Result by List View"><i class="fas fa-th-list" aria-hidden="true"></i></a> <a href="grid.html" title="Result by Gallery View"><i class="fas fa-th-large" aria-hidden="true"></i></a> </div>
              </div>
              <div class="col-lg-9">Displaying Results : 1 - 6 from 6 Profiles</div>
            </div>
          </div>
          <div class="listing" id="resultsContainer">
            <ul class="profile-listing" id="userList">
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
                if (Validator.isNotNull(userItems) && !excludedProfileIds.contains(userId)) {
                	
        %>
              <li class="feature">
                <div class="ribbon_3 popular"><span>Verified</span></div>
                <div class="row">
                  <div class="col-lg-2 col-md-3">
                    <div class="listingImg"><img src="<%= userItems.getPortraitURL(themeDisplay) %>" alt=""></div>
                  </div>
                  <div class="col-lg-8 col-md-6">
                    <h3><a href="#"><%= userItems.getFullName() %></a></h3>
                    <ul class="listingInfo">
                    <%
				    // Get the user's DOB from the object
				    Date birthDate = userItems.getBirthday();
				    
				    // Get the current date
				    Date currentDate = new Date();
				    
				    // Calculate the age
				    int age = currentDate.getYear() - birthDate.getYear();
				    
				    // Adjust the age if the birthday hasn't occurred yet this year
				    if (currentDate.getMonth() < birthDate.getMonth() || 
				        (currentDate.getMonth() == birthDate.getMonth() && currentDate.getDate() < birthDate.getDate())) {
				        age--;
				    }
				%>
                      <li title="Age"><i class="far fa-calendar-alt"></i><%= age %></li>
                      <li title="Location"><i class="fas fa-map-marker-alt"></i> <%=matrimonyUser.getCountryName()%>, <%=matrimonyUser.getStateName()%></li>
                     <li title="Gender">
					    <i class="fas <%= userItems.getMale() ? "fa-male" : "fa-female" %>"></i>
					    <%= userItems.getMale() ? "Male" : "Female" %>
					</li>


                      <li title="Education"><i class="fas fa-book-open"></i><%= matrimonyUser.getEducation() %></li>
                      <li title="Matrial Status"><i class="fas fa-book-open"></i><%=matrimonyUser.getMaritalStatus()%></li>
                      <li title="Jamath"><i class="fas fa-mosque"></i> <%= matrimonyUser.getJamath() %></li>
                    </ul>
                    <p><%=matrimonyUser.getBio()%></p>
                  </div>
                  <div class="col-lg-2 col-md-3">
                    <div class="listbtn"> <a href="javascript:void(0)" id="" data-id="19" class="btn save_job"><i class="far fa-heart" aria-hidden="true"></i>Interest</a> 
                    <% 
                     
                        informationRenderURL.setParameter("userId",String.valueOf(userItems.getUserId())); 
                    		
                    %>
                    <a href="<%= informationRenderURL %>" class="btn apply"><i class="fas fa-eye" aria-hidden="true"></i> Details</a>
                     </div>
                  </div>
                </div>
              </li>
                <% 
                } 
            }
        %>
            </ul>
          </div>
          <div class="blog-pagination text-center"> <a href="#0"><i class="fas fa-angle-left"></i></a> <a href="#0">1</a> <span class="active">2</span> <a href="#0">3</a> <a href="#0"><i class="fas fa-angle-right"></i></a> </div>
        </div>
      </div>
    </div>
    <!--Listing End--> 
    
  </div>
</div>
<!--Inner Content End--> 


<style>
h2.portlet-title-text.portlet-title-editable
 {
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
                         userListHtml += '<li class="user-card">' +
                    '<div class="card-container">' +
                        '<div class="card-image">' +
                            '<img src="' + user.portraitURL + '" alt="User Image" />' +
                        '</div>' +
                        '<div class="user-info">' +
                            '<h5 class="user-name">' +
                                '<a href="#">' + user.fullName + '</a>' +
                                '<span class="user-id">(' + user.userId + ')</span>' +
                                '<span class="gold-badge">Gold Package</span>' +
                            '</h5>' +
                            '<p><strong>Age:</strong> ' + user.age + ', ' + user.height + ' Cms</p>' +
                            '<p><strong>Jamath:</strong> ' + user.Jamath + '</p>' +
                            '<p><strong>Location:</strong> ' + user.location + '</p>' +
                            '<p><strong>Profession:</strong> ' + user.jobTitle + '</p>' +
                            '<p class="message-text">' +
                                '<strong>Profile Created:</strong><br>' +
                                '<em>' + user.createDate + '</em>' +
                            '</p>' +
                            '<div class="user-buttons">' +
                                '<button class="btn btn-action btn-yes">Interested</button>' +
                                '<button class="btn btn-action btn-no">Not Interested</button>' +
                                '<button class="btn btn-action btn-email">' +
                                    '<a href="' + user.informationRenderURL + '">Details</a>' +
                                '</button>' +
                            '</div>' +
                            '<p class="date-info">' +
                                '<i class="fa fa-clock"></i> Last Login: 1 day ago' +
                            '</p>' +
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



