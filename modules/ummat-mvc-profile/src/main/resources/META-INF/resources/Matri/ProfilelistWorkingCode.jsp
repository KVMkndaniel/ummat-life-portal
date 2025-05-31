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

<div class="first-div" id="filter-bar">
  <!-- Hero Section -->
    <div class="hero">
        <div class="search-box text-white">
           <!-- <h2>Trusted Matrimony & Matchmaking Service</h2>-->
					<h2>Advanced  & Search </h2>

                <div class="form-row">
                    <div class="col-6 col-md-3 mb-2">                      
						  <select class="form-control"  id="genderSelect">
                            <option>I'm looking for a</option>
                           <option value="all">All</option>
						  <option value="male">Male</option>
						  <option value="female">Female</option>
                        </select>
     <input type="hidden" id="genderhidden" value="" />
    <input type="hidden" id="jamathhidden" value="" />
    <input type="hidden" id="statehidden" value="" />
    <input type="hidden" id=disthidden value="" />
    <input type="hidden" id="areahidden" value="" /> 
    <input type="hidden" id="useridhidden" value="" /> 
     <input type="hidden" id="languagehidden" value="" /> 
      <input type="hidden" id="agehidden" value="" /> 
        <input type="hidden" id="professionhidden" value="" /> 
      
                    </div>
                    <div class="col-6 col-md-3 mb-2">       
                         <select class="form-control" id="age" label="Select Age">
					        <option disabled selected>Selected age</option>
					        <option value="18to21">18 to 21</option>
					        <option value="21to25">21 to 25</option>
					        <option value="25to28">25 to 28</option>
					        <option value="29to32">29to32</option>
					        <option value="32toAbove">32 to above</option>
					    </select>
                    </div>
                    <div class="col-6 col-md-3 mb-2">
    
                        <select class="form-control" id="profession" label="Select Profession">
					        <option disabled selected>Selected Profession</option>
					        <option value="Police">Police</option>
					        <option value="Doctor">Doctor</option>
					        <option value="softwareEngginers">Software Engginers</option>
					        <option value="formar">Formar</option>
					        <option value="OwnBussness">Own Bussniess</option>
					    </select>
                    </div>
                     <div class="col-6 col-md-3 mb-2">
                        <select class="form-control" id="languageSelect" label="Select Language">
					        <option disabled selected>Selected Languages</option>
					        <option value="english">English</option>
					        <option value="tamil">Tamil</option>
					        <option value="malayalam">Malayalam</option>
					        <option value="hindi">Hindi</option>
					        <option value="kanadam">Kannadam</option>
					    </select>
                    </div>
                    
                    <div class="col-6 col-md-3 mb-2">
    <select name="state" class="form-control" label="Select state" id="selectedState">
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
<div class="col-6 col-md-3 mb-2">
    <select name="district" class="form-control" label="District" id="selectedDistrict" required="true">
        <option value="">Select District</option>
    </select>
</div>

<div class="col-6 col-md-3 mb-2">
    <select name="area" class="form-control" label="Area" id="availableLocality" onchange="selectArea(this)">
        <option value="">Select Area</option>
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

                    
                       <div class="col-6 col-md-3 mb-2">
                      <select class="form-control" id="typeSelect">
      <option value="All">All Jamath</option>
      <option value="thowheedJamath"> Thowheed Jamath</option>
      <option value="sunnathwalJamath"> Sunnathwal Jamath</option>
      <option value="tNTJ"> TNTJ</option>
      <option value="others">Others</option>
    </select>
                    </div>
                    
                  
        </div>
    </div>



</div>


<div class="second-div">
<div id="resultsContainer" class="mt-3"></div>

    <ul class="card-list pager profile-container" id="userList">
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
        <%@ page import="java.text.SimpleDateFormat, java.util.Date" %>

  <li class="user-card">
        <input type="checkbox" class="select-checkbox">
        <div class="card-container">
            <div class="card-image">
                <img src="<%= userItems.getPortraitURL(themeDisplay) %>" alt="User Image">
            </div>
            <div class="user-info">
                <h5 class="user-name">
                    <a href="#"><%= userItems.getFullName() %></a>
                    <span class="user-id">( <%= userItems.getUserId() %> )</span>
                    <span class="gold-badge">Gold Package</span>
                </h5>
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
                <p><strong>Age:</strong> <%= age %></p>
                <p><strong>Jamath:</strong> <%= matrimonyUser.getJamath() %></p>
                <p><strong>Location:</strong> </p>
                <p><strong>Profession:</strong> <%= matrimonyUser.getEducation()%></p>
                <p class="message-text">
                    Created:<br>
                    <% 
                            Date createDate = userItems.getCreateDate();
                            
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            String formattedDate = dateFormat.format(createDate); 
                        %>
                    <em><%=formattedDate %></em>
                </p>

                <div class="user-buttons">
                    <button class="btn btn-action btn-yes">Interested</button>
                    <button class="btn btn-action btn-no">Not Interested</button>
                    <% 
                     
                        informationRenderURL.setParameter("userId",String.valueOf(userItems.getUserId())); 
                    		
                    %>
                    <button class="btn btn-action btn-email" onclick="window.location.href='<%= informationRenderURL %>'">Details</button>
                </div>

                <p class="date-info">
                    <i class="fa fa-clock"></i> Last Login: 1 day ago
                </p>
            </div>
        </div>
    </li>

        <% 
                } 
            }
        %>
        
        
    </ul>
  <!-- Pagination -->
    <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center">
            <%-- Previous page button --%>
            <%
                PortletURL previousPageURL = renderResponse.createRenderURL();
                previousPageURL.setParameter("page", String.valueOf(Math.max(currentPage - 1, 1)));
            %>
            <li class="page-item <%= currentPage == 1 ? "disabled" : "" %>">
                <a class="page-link" href="<%= previousPageURL.toString() %>">Previous</a>
            </li>

            <%-- Page numbers --%>
            <% for (int i = 1; i <= totalPages; i++) { %>
                <%
                    PortletURL pageURL = renderResponse.createRenderURL();
                    pageURL.setParameter("page", String.valueOf(i));
                %>
                <li class="page-item <%= currentPage == i ? "active" : "" %>">
                    <a class="page-link" href="<%= pageURL.toString() %>"><%= i %></a>
                </li>
            <% } %>

            <%-- Next page button --%>
            <%
                PortletURL nextPageURL = renderResponse.createRenderURL();
                nextPageURL.setParameter("page", String.valueOf(Math.min(currentPage + 1, totalPages)));
            %>
            <li class="page-item <%= currentPage == totalPages ? "disabled" : "" %>">
                <a class="page-link" href="<%= nextPageURL.toString() %>">Next</a>
            </li>
        </ul>
    </nav>
   
</div>




<style>
 /* General Styling */
body {
    background-color: #f8f9fa;
    font-family: Arial, sans-serif;
}

/* User List */
.user-list {
    display: flex;
    flex-direction: column;
    gap: 15px;
    padding: 20px;
}

/* User Card */
.user-card {
    display: flex;
    /* align-items: center; */
    background: #fff;
    padding: 15px;
    border-radius: 10px;
    border: 1px solid #ddd;
    box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.1);
    transition: transform 0.3s ease;
    position: relative;
    /* width: 25%; */ /* Ensures uniform width */
    margin: 10px auto; /* Centers the card */
    text-align: justify;
}

.user-card:hover {
    transform: scale(1.02);
}

/* Profile Image */
.card-image {
    flex: 0 0 100px; /* Fixed width for images */
    display: flex;
    align-items: center;
    justify-content: center;
}

.card-image img {
    width: 80px;
    height: 80px;
    border-radius: 50%;
    object-fit: cover;
    border: 2px solid #ccc;
}

/* User Info */
.user-info {
    flex: 1;
    display: flex;
    flex-direction: column;
    padding-left: 15px;
}

/* User Name */
.user-name {
    font-size: 16px;
    font-weight: bold;
    display: flex;
    align-items: center;
    gap: 10px;
}

.user-name a {
    color: #007bff;
    text-decoration: none;
}

.user-name a:hover {
    text-decoration: underline;
}

/* User ID */
.user-id {
    color: red;
    font-weight: bold;
}

/* Membership Badge */
.gold-badge {
    background: green;
    padding: 3px 7px;
    border-radius: 5px;
    font-size: 12px;
    color: white;
    font-weight: bold;
}

/* Message */
.message-text {
    font-style: italic;
    color: #666;
    font-size: 14px;
}

/* Buttons Row */
.user-buttons {
    display: flex;
    justify-content: space-between;
    gap: 10px;
    margin-top: 10px;
    width: max-content;
}

/* Buttons Styling */
.btn-action {
    
    border: none;
    border-radius: 5px;
    font-size: 14px;
    text-align: center;
    cursor: pointer;
    font-weight: bold;
}

.btn-yes {
    background-color: #f0ad4e;
    color: white;
}

.btn-no {
    background-color: #d9534f;
    color: white;
}

.btn-email {
    background-color: #007bff;
    color: white;
}

/* Button Hover */
.btn-action:hover {
    opacity: 0.85;
}

/* Last Login & Join Date */
.date-info {
    font-size: 12px;
    color: gray;
    margin-top: 10px;
    display: flex;
    justify-content: space-between;
    flex-direction: row-reverse;
}

.date-info i {
    margin-right: 5px;
}

/* Delete Button */
.delete-btn {
    position: absolute;
    right: 10px;
    top: 10px;
    background: transparent;
    border: none;
    cursor: pointer;
    color: red;
    font-size: 16px;
}

/* Responsive Design */
@media (max-width: 768px) {
    .user-card {
        flex-direction: column;
        align-items: flex-start;
    }

    .card-image {
        width: 100%;
        text-align: center;
        margin-bottom: 10px;
    }

    .card-image img {
        width: 100px;
        height: 100px;
    }

    .user-buttons {
        flex-direction: column;
        width: 100%;
    }

    .date-info {
        flex-direction: column;
        gap: 5px;
    }
}
ul#userList {
    display: flex;
    flex-wrap: wrap;
}


/* 
search logic css */

h2.portlet-title-text.portlet-title-editable {
    display: none !important;
} 
 body {
            font-family: Arial, sans-serif;
        }
        .hero {
            /* background: url('https://static.vecteezy.com/system/resources/previews/017/679/307/large_2x/milad-un-nabi-green-background-free-photo.jpg') no-repeat center;
            */ background-size: cover;
            height: 60vh;
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;
            text-align: center;
            padding: 20px;
        }
        .search-box {
            background: rgba(0 0 0 / 29%);
            padding: 30px;
            border-radius: 10px;
            width: 90%;
            max-width: 800px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.3);
        }
        .search-box h2 {
            margin-bottom: 20px;
            font-size: 1.5rem;
        }
        .form-control {
            border-radius: 5px;
        }
        .btn-primary {
            background-color: #ff3366;
            border: none;
            padding: 10px;
            font-size: 1rem;
        }
        .btn-primary:hover {
            background-color: #cc0044;
        }
        .vip-section {
            background: #2e1f4f;
            color: white;
            text-align: center;
            padding: 50px 20px;
        }
        .vip-section h2 {
            font-size: 1.8rem;
            margin-bottom: 10px;
        }
        .btn-warning {
            padding: 10px 20px;
            font-size: 1rem;
            border-radius: 5px;
        }

.sidebar {align-content
    padding-bottom: 30% !important;
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










