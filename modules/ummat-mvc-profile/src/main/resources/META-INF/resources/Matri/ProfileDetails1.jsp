<%@page import="com.ummat.slayer.service.DistrictLocalServiceUtil"%>
<%@page import="java.util.Calendar"%>
<%@page
	import="com.liferay.portal.kernel.service.RegionLocalServiceUtil"%>
<%@page import="ummat_startup_details.model.MatriUserModel"%>
<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="ummat_startup_details.service.MatriUserLocalServiceUtil"%>
<%@page import="ummat_startup_details.model.MatriUser"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.ummat.slayer.model.District"%>
<%@page import="java.util.List"%>
<%@page
	import="com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil"%>
<%@page import="com.liferay.expando.kernel.model.ExpandoBridge"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="java.io.Serializable"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.time.Period"%>
<%@page import="java.time.LocalDate"%>
<%@ page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@ page import="com.liferay.portal.kernel.model.User"%>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>


<portlet:renderURL var="viewJspUrl">
	<portlet:param name="jspPage" value="/Matri/Profilelist.jsp" />
</portlet:renderURL>
<%
	// Retrieve the user ID from the request parameter
	String userIdParam = request.getParameter("userId");

	// Check if the user ID is not null and is a valid Long value
	if (userIdParam != null && userIdParam.matches("\\d+")) {
		long userId = Long.parseLong(userIdParam);

		try {
			// Retrieve user details using UserLocalServiceUtil
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long userids = themeDisplay.getUserId();
			User userDetails = UserLocalServiceUtil.getUser(userId);
			long compId = themeDisplay.getCompanyId();
			// Retrieve and format user details
			long UserId = userDetails.getUserId();
			userids = UserId;
			String fullName = userDetails.getFullName();
			String jobTitle = userDetails.getJobTitle();
			System.out.println(UserId + ":::userids::::" + userids);
			// MatriUser currentPageUsers  =MatriUserLocalServiceUtil.getMatriUserDetailObj(UserId, compId);
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(MatriUserModel.class,
					getClass().getClassLoader());
			dynamicQuery.add(RestrictionsFactoryUtil.eq("userId", UserId));
			//dynamicQuery.addOrder(OrderFactoryUtil.asc("userId"));

			// Execute the query and return the results
			List<MatriUser> maty = MatriUserLocalServiceUtil.dynamicQuery(dynamicQuery);
			System.out.println("maty::::" + maty);
			MatriUser matriUser = maty.get(0);
%>


<%
	// Ensure userItems is not null
			if (userDetails != null) {
%>
<a class="btn btn-dark" href="${viewJspUrl}">Back</a>
<div class="container">


    <div class="profile-header">
        <div class="profile-img">
            <img src="<%=userDetails.getPortraitURL(themeDisplay)%>" width="200" alt="Profile Image">
        </div>
        <div class="profile-nav-info">
            <h3 class="user-name"><%=fullName%>
                |
                <%=UserId%>
            </h3>
            <div class="address">
                <p id="state" class="state">
                    Native :
                    <%=matriUser.getArea()%>,
                </p>
                <p id="state" class="state">
                    <%
						// Get the district ID stored in matriUser
									long districtId = matriUser.getDistrict();

									// Retrieve the district object based on districtId
									District district = DistrictLocalServiceUtil.getDistrict(districtId);

									// Initialize districtName
									String districtName = "";

									// Check if district is found
									if (district != null) {
										districtName = district.getName();
									} else {
										out.print("INVALID VALUES !!!"); // Print error message if district not found
									}
					%>

                    <%=districtName%>
                </p>
                &nbsp; &nbsp; <span id="country" class="country"> State : <%=matriUser.getState()%>.
                </span>
            </div>

        </div>

    </div>

    <div class="main-bd">
        <div class="left-side">
            <div class="profile-side">
                <p class="mobile-no">
                    <i class="fa fa-phone"></i><%=userDetails.getScreenName()%>
                </p>
                <p class="user-mail">
                    <i class="fa fa-envelope"></i>
                    <%=userDetails.getEmailAddress()%>
                </p>
                <div class="user-bio">
                    <h3>Bio</h3>
                    <p class="bio"><%=matriUser.getBio()%></p>
                    <p><%=userDetails.isMale()%></p>
                </div>
                <div class="profile-btn">
                    <button class="chatbtn" id="chatBtn">
                        <i class="fa fa-comment"></i> Chat
                    </button>




                    <button id="likeButton" class="like-button">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" class="heart-icon">
                            <path d="M12 21.35l-1.45-1.32C5.4 15.36 2 12.28 2 8.5 2 5.42 4.42 3 7.5 3c1.74 0 3.41.81 4.5 2.09C13.09 3.81 14.76 3 16.5 3 19.58 3 22 5.42 22 8.5c0 3.78-3.4 6.86-8.55 11.54L12 21.35z" />
                        </svg>
                        <span id="likeText" class="like-text">Like</span>
                    </button>

                </div>

            </div>
        </div>

        <div class="right-side">
            <div class="contains">
                <div class="tabs">
                    <ul>
                        <li onclick="toggleTab('tab1')" class="user-post active">Posts</li>
                        <li onclick="toggleTab('tab2')" class="user-review">Her
                            Partner Preferences</li>
                        <li onclick="toggleTab('tab3')" class="user-setting">My
                            Details</li>
                    </ul>
                    <div id="tab1" class="tab-content active">
                        <div class="profile-posts tab">

                            <div class="grids">

                                <div class="grids-img1">
                                    <img src="https://i.ibb.co/ZVFsg37/default.png" alt="Quizzical Kitty" width="160" height="160">
                                </div>
                                <div class="grids-img2">
                                    <img src="https://i.ibb.co/ZVFsg37/default.png" alt="Sibling Kitties" width="160" height="160">
                                </div>
                                <div class="grids-img3">
                                    <img src="https://i.ibb.co/ZVFsg37/default.png" alt="Penguin Kitty" width="160" height="160">
                                </div>

                                <div class="grids-img4">
                                    <img src="https://i.ibb.co/ZVFsg37/default.png" alt="Garfield Kitty" width="160" height="160">
                                </div>

                            </div>


                        </div>
                    </div>
                    <div id="tab2" class="tab-content">
                        <div class="profile-reviews tab">
                            <div class="cards">

                                <div class="card active" id="profile">
                                    <a class="card-toggle"><i class="fa fa-arrow-circle-left"></i></a>
                                    <div class="card-content">
                                        <div class="row">
                                            <div class="left col">
                                                <h2>
                                                    Profile of <strong>Jane Doe</strong>
                                                </h2>

                                                <p>Hi, I'm Jane Doe, a software engineer based in New
                                                    York. I love exploring new technologies and working on
                                                    exciting projects. I enjoy hiking, reading, and cooking in
                                                    my free time.</p>

                                            </div>
                                            <div class="right col"></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="card" id="personal-info">
                                    <a class="card-toggle"><i class="fa fa-info-circle"></i></a>
                                    <div class="card-content">
                                        <div class="row">
                                            <div class="left col">
                                                <h2>
                                                    Personal <strong>Information</strong>
                                                </h2>
                                                <ul>
                                                    <li><strong>Height:</strong> 5'6"</li>
                                                    <li><strong>Weight:</strong> 60 kg</li>
                                                    <li><strong>Religion:</strong> Christianity</li>
                                                    <li><strong>Caste:</strong> N/A</li>
                                                    <li><strong>Skin Color:</strong> Fair</li>
                                                </ul>
                                            </div>
                                            <div class="right col"></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="card" id="preferences">
                                    <a class="card-toggle"><i class="fa fa-heart"></i></a>
                                    <div class="card-content">
                                        <div class="row">
                                            <div class="left col">
                                                <h2>
                                                    My <strong>Preferences</strong>
                                                </h2>

                                                <p>I am looking for a partner who is kind, supportive,
                                                    and has a good sense of humor. Ideally, someone who shares
                                                    my love for travel and adventure.</p>

                                            </div>
                                            <div class="right col"></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="card" id="education">
                                    <a class="card-toggle"><i class="fa fa-graduation-cap"></i></a>
                                    <div class="card-content">
                                        <div class="row">
                                            <div class="left col">
                                                <h2>
                                                    My <strong>Education</strong>
                                                </h2>
                                                <p>I have a Bachelor's degree in Computer Science from
                                                    NYU. I am passionate about continuous learning and often
                                                    take online courses to keep my skills updated.</p>
                                            </div>
                                            <div class="right col"></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="card" id="hobbies">
                                    <a class="card-toggle"><i class="fa fa-star"></i></a>
                                    <div class="card-content">
                                        <div class="row">
                                            <div class="left col">
                                                <h2>
                                                    My <strong>Hobbies</strong>
                                                </h2>

                                                <p>I enjoy a variety of activities including hiking,
                                                    cooking, reading, and traveling. I love to explore new
                                                    places and try out different cuisines.</p>
                                            </div>
                                            <div class="right col"></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="card" id="contact">
                                    <a class="card-toggle"><i class="fa fa-envelope"></i></a>
                                    <div class="card-content">
                                        <div class="row">
                                            <div class="left col">
                                                <h2>
                                                    <strong>Contact Me</strong>
                                                </h2>
                                                <p>If you are interested in getting to know me better,
                                                    feel free to reach out. I look forward to connecting!</p>
                                            </div>
                                            <div class="right col"></div>
                                        </div>
                                    </div>
                                </div>

                            </div>


                        </div>
                    </div>
                    <div id="tab3" class="tab-content">
                        <div class="profile-settings tab">
                            <div class="account-setting">
                                <div class="profile-container">
                                    <div class="profile-details">
                                        <p>
                                            <span class="profile-label">Full Name:</span>
                                            <%=userDetails.getFullName()%>
                                        </p>
                                        <p>
                                            <%
												Date birthday = userDetails.getBirthday();
															Calendar birthCal = Calendar.getInstance();
															birthCal.setTime(birthday);

															Calendar today = Calendar.getInstance();
															int age = today.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR);
															if (today.get(Calendar.DAY_OF_YEAR) < birthCal.get(Calendar.DAY_OF_YEAR)) {
																age--;
															}
											%>
                                            <span class="profile-label">Age :</span>
                                            <%=age%>
                                        </p>
                                        <p>
                                            <span class="profile-label">Father's Name :</span>

                                        </p>
                                        <p>
                                            <span class="profile-label">Mother's Name :</span>
                                        </p>
                                        <p>
                                            <span class="profile-label">Region :</span> Muslim
                                        </p>
                                        <p>
                                            <span class="profile-label">Jamath :</span>
                                            <%=matriUser.getJamath()%>
                                        </p>
                                        <p>
                                            <span class="profile-label">Height :</span>
                                            <%=matriUser.getHeight()%>
                                        </p>
                                        <p>
                                            <span class="profile-label">Weight :</span>
                                            <%=matriUser.getWeight()%>
                                        </p>
                                        <p>
                                            <span class="profile-label">Education :</span>
                                            <%=matriUser.getEducation()%>
                                        </p>
                                        <p>
                                            <span class="profile-label">Job :</span>
                                            <%=userDetails.getJobTitle()%>
                                        </p>
                                        <p>
                                            <span class="profile-label">Mother Language :</span>
                                            <%=matriUser.getMothertongueLanguage()%>
                                        </p>
                                        <p>
                                            <span class="profile-label">More Information:</span>

                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%
	} else {
%>
<p>User Not Found</p>
<%
	}

			//String maritalStatus = (String) userDetails.getExpandoBridge().getAttribute("maritalStatus");
%>
<%
	} catch (PortalException e) {
			// Handle exception when user details are not found
%>


<%
	}
	} else {
		// Handle case when the provided user ID is not valid
%>


<%
	}
%>
<script>
//JavaScript to toggle like/unlike
const likeButton = document.getElementById('likeButton');

likeButton.addEventListener('click', function() {
    this.classList.toggle('liked');
    const likeText = this.querySelector('.like-text');
    if (this.classList.contains('liked')) {
        likeText.textContent = 'Liked';
    } else {
        likeText.textContent = 'Like';
    }
});


$(".card-toggle").on("click", function() {

    // Card toggle state 	
    $(".card-toggle").removeClass("active");
    $(this).addClass("active");

    var isAnimating = false;

    if (!isAnimating) {
        isAnimating = true;

        $(".card").find(".card-content").css("z-index", 0);
        $(".card").removeClass("active");

        var that = $(this);

        $(this).siblings().css("z-index", 1);

        setTimeout(function() {
            that.parent().toggleClass("active").find(".card-content").on("transitionend", function() {
                isAnimating = false;
            });;

        }, 10);
    } else {
        return;
    }
});

$("input,textarea").blur(function() {
    if ($(this).val()) {
        $(this).parent().addClass("filled");
    } else {
        $(this).parent().removeClass("filled");
    }
});

$(".contact").on("click", function() {
    $(".contact-form").toggleClass("active");
});
$(".contact-form input[type=submit], .contact-form .close").on("click", function(e) {
    e.preventDefault();
    $(".contact-form").toggleClass("active")
});



function toggleTab(tabId) {
    console.log('Toggle function called with tabId:', tabId);

    // Get all tabs and hide them
    var tabs = document.querySelectorAll('.tab-content');
    tabs.forEach(tab => {
        tab.classList.remove('active');
    });

    // Get all tab links and remove active class
    var tabLinks = document.querySelectorAll('.tabs ul li');
    tabLinks.forEach(link => {
        link.classList.remove('active');
    });

    // Show the selected tab and mark its link as active
    document.getElementById(tabId).classList.add('active');
    document.querySelector(`.tabs ul li[onclick="toggleTab('${tabId}')"]`).classList.add('active');

    console.log('Tab with ID', tabId, 'is now active.');
}
</script>
<style>
/* Style for tab navigation */
.tabs ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
}

.tabs ul li {
    display: inline-block;
    padding: 10px 20px;
    cursor: pointer;
    background-color: #f0f0f0;
    border: 1px solid #ccc;
    border-bottom: none;
}

.tabs ul li.active {
    background-color: #fff;
    border-bottom: 1px solid #fff;
}

/* Style for tab content */
.tab-content {
    display: none;
}

.tab-content.active {
    display: block;
}

.tabs ul li.active {
    font-weight: bold;
}

/* Styles for the Instagram-like heart button */
.like-button {
    background-color: transparent;
    border: none;
    cursor: pointer;
    outline: none;
    padding: 8px;
    display: flex;
    align-items: center;
}

.heart-icon {
    width: 24px;
    height: 24px;
    fill: #000;
    transition: transform 0.2s ease-out;
}

.liked .heart-icon {
    fill: #ed4956;
    /* Instagram red color */
    transform: scale(1.3);
}

.like-text {
    font-size: 14px;
    margin-left: 5px;
}

.grids {
    display: flex;
    flex-wrap: wrap;
    flex-direction: row;
    align-items: center;
    justify-content: center;
}

/***
 * Flexbox Images
 ***/
.grids-img1,
.grids-img2,
.grids-img3,
.grids-img4,
.grids-img5,
.grids-img6,
.grids-img7,
.grids-img8,
.grids-img9,
.grids-img10,
.grids-img11,
.grids-img12,
.grids-img13,
.grids-img14,
.grids-img15,
.grids-img16 {
    padding-left: 2%;
    padding-right: 1%;
    padding-bottom: 2%;
}

/* General Styles */
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f9;
    color: #333;
    margin: 0;
    padding: 0;
}

.cards {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    margin: 20px;
}

.card {
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    margin: 10px;
    width: 300px;
    transition: transform 0.2s;
}

.card:hover {
    transform: scale(1.05);
}

.card.active {
    background-color: #e0f7fa;
}

.card-toggle {
    text-align: right;
    padding: 10px;
    cursor: pointer;
}

.card-toggle i {
    font-size: 1.2em;
    color: #00796b;
}

.card-content {
    padding: 20px;
}

.card-content h2 {
    color: #00796b;
    font-size: 1.5em;
    margin: 0 0 10px;
}

.card-content p,
.card-content ul {
    color: #333;
    font-size: 1em;
    margin: 0 0 10px;
}

.card-content ul {
    list-style-type: none;
    padding: 0;
}

.card-content ul li {
    padding: 5px 0;
}

/* Contact Form Styles */
.contact-form {
    display: none;
    background-color: rgba(0, 0, 0, 0.7);
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    justify-content: center;
    align-items: center;
}

.contact-form form {
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    width: 300px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.contact-form .control {
    margin-bottom: 10px;
}

.contact-form .control label {
    display: block;
    margin-bottom: 5px;
}

.contact-form .control input,
.contact-form .control textarea {
    width: 100%;
    padding: 8px;
    box-sizing: border-box;
}

.contact-form .control.submit {
    text-align: right;
}

.contact-form .control.submit input {
    background-color: #00796b;
    color: #fff;
    border: none;
    padding: 10px 20px;
    cursor: pointer;
    border-radius: 4px;
}

.contact-form .close {
    position: absolute;
    top: 20px;
    right: 20px;
    font-size: 1.5em;
    color: #fff;
    cursor: pointer;
}

.profile-container {
    border: 1px solid #ddd;
    padding: 20px;
    margin: 20px;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    max-width: 600px;
    margin: auto;
}

.profile-container h1 {
    text-align: center;
    color: #333;
}

.profile-details {
    display: flex;
    flex-direction: column;
    gap: 10px;
}

.profile-details p {
    margin: 0;
    font-size: 16px;
}

.profile-label {
    font-weight: bold;
}

@import url("https://fonts.googleapis.com/css?family=Poppins&display=swap");

@import url("https://fonts.googleapis.com/css?family=Bree+Serif&display=swap");
/* 
* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
} */

/* body {
  background: #e9e9e9;
  overflow-x: hidden;
  padding-top: 90px;
  font-family: "Poppins", sans-serif;
  margin: 0 100px;
} */
.profile-header {
    background: #ccc3fa;
    width: 100%;
    display: flex;
    height: 190px;
    position: relative;
    box-shadow: 0px 3px 4px rgba(0, 0, 0, 0.2);
    border: solid 3px;
    border-color: #fff;
}

.profile-img {
    float: left;
    width: 340px;
    height: 200px;
}

.profile-img img {
    border-radius: 50%;
    height: 230px;
    width: 230px;
    border: 5px solid #fff;
    box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.2);
    position: absolute;
    left: 50px;
    top: 20px;
    z-index: 5;
    background: #fff;
}

.profile-nav-info {
    float: left;
    display: flex;
    flex-direction: column;
    justify-content: center;
    padding-top: 60px;
}

.profile-nav-info h3 {
    font-variant: small-caps;
    font-size: 2rem;
    font-family: sans-serif;
    font-weight: bold;
    color: #2a1d6ae5;
}

.profile-nav-info .address {
    display: flex;
    font-weight: bold;
    color: #3a426c;
}

.profile-nav-info .address p {
    margin-right: 5px;
}

.profile-option {
    width: 40px;
    height: 40px;
    position: absolute;
    right: 50px;
    top: 50%;
    transform: translateY(-50%);
    border-radius: 50%;
    display: flex;
    justify-content: center;
    align-items: center;
    cursor: pointer;
    transition: all 0.5s ease-in-out;
    outline: none;
    background: #e40046;
}

.profile-option:hover {
    background: #fff;
    border: 1px solid #e40046;
}

.profile-option:hover .notification i {
    color: #e40046;
}

.profile-option:hover span {
    background: #e40046;
}

.profile-option .notification i {
    color: #fff;
    font-size: 1.2rem;
    transition: all 0.5s ease-in-out;
}

.profile-option .notification .alert-message {
    position: absolute;
    top: -5px;
    right: -5px;
    background: #fff;
    color: #e40046;
    border: 1px solid #e40046;
    padding: 5px;
    border-radius: 50%;
    height: 20px;
    width: 20px;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 0.8rem;
    font-weight: bold;
}

.main-bd {
    width: 100%;
    display: flex;
    padding-right: 15px;
}

.profile-side {
    width: 300px;
    background: #fff;
    box-shadow: 0px 3px 5px rgba(0, 0, 0, 0.2);
    padding: 90px 30px 20px;
    font-family: "Bree Serif", serif;
    margin-left: 10px;
    z-index: 99;
    border: solid 1px;
    border-color: #353658;
}

.profile-side p {
    margin-bottom: 7px;
    color: #4e3a66;
    font-size: 14px;
}

    {
    color:
        #e7b338;


    margin-right:
        10px;


}

.mobile-no i {
    transform: rotateY(180deg);
    color: #e40046;
}

.profile-btn {
    display: flex;
}

button.chatbtn,
button.createbtn {
    border: 0;
    padding: 10px;
    width: 100%;
    border-radius: 3px;
    background: #363476;
    color: #fff;
    font-family: "Bree Serif";
    font-size: 1rem;
    margin: 5px 2px;
    cursor: pointer;
    outline: none;
    margin-bottom: 10px;
    transition: background 0.3s ease-in-out;
    box-shadow: 0px 5px 7px 0px rgba(0, 0, 0, 0.3);
}

button.chatbtn:hover,
button.createbtn:hover {
    background: rgb(255, 237, 87);
}

button.chatbtn i,
button.createbtn i {
    margin-right: 5px;
}

.user-rating {
    display: flex;
}

.user-rating h3 {
    font-size: 2.5rem;
    font-weight: 200;
    margin-right: 5px;
    letter-spacing: 1px;
    color: #4b4688;
}

.user-rating .no-of-user-rate {
    font-size: 0.9rem;
}

.rate {
    padding-top: 6px;
}

.rate i {
    font-size: 0.9rem;
    color: rgba(228, 0, 70, 1);
}

.nav {
    width: 100%;
    z-index: -1;
}

.nav ul {
    display: flex;
    justify-content: space-around;
    list-style-type: none;
    height: 40px;
    background: #fff;
    box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.3);
    padding-right: 150px;
    text-wrap: nowrap;
}

.nav ul li {
    padding: 10px;
    width: 100%;
    cursor: pointer;
    text-align: center;
    transition: all 0.2s ease-in-out;
}

.nav ul li:hover,
.nav ul li.active {
    box-shadow: 0px -3px 0px rgba(35, 50, 133, 0.9) inset;
}

.profile-body {
    width: 100%;
    z-index: -1;
}

.tab {
    padding: 20px;
    width: 100%;
    text-align: center;
}

@media (max-width : 1100px) {
    .profile-side {
        width: 250px;
        padding: 90px 15px 20px;
    }

    .profile-img img {
        height: 200px;
        width: 200px;
        left: 50px;
        top: 50px;
    }
}

@media (max-width : 900px) {
    .profile-header {
        display: flex;
        height: 100%;
        flex-direction: column;
        text-align: center;
        padding-bottom: 20px;
    }

    .profile-img {
        float: left;
        width: 100%;
        height: 200px;
    }

    .profile-img img {
        position: relative;
        height: 200px;
        width: 200px;
        left: 0px;
    }

    .profile-nav-info {
        text-align: center;
    }

    .profile-option {
        right: 20px;
        top: 75%;
        transform: translateY(50%);
    }

    .main-bd {
        flex-direction: column;
        padding-right: 0;
    }

    .profile-side {
        width: 100%;
        text-align: center;
        padding: 20px;
        margin: 5px 0;
    }

    .profile-nav-info .address {
        justify-content: center;
    }

    .user-rating {
        justify-content: center;
    }
}

@media (max-width : 400px) {
    .profile-header h3 {}

    .profile-option {
        width: 30px;
        height: 30px;
        position: absolute;
        right: 15px;
        top: 83%;
    }

    .profile-option .notification .alert-message {
        top: -3px;
        right: -4px;
        padding: 4px;
        height: 15px;
        width: 15px;
        font-size: 0.7rem;
    }

    .profile-nav-info h3 {
        font-size: 1.9rem;
    }

    .profile-nav-info .address p,
    .profile-nav-info .address span {
        font-size: 0.7rem;
    }
}

#see-more-bio,
#see-less-bio {
    color: blue;
    cursor: pointer;
    text-transform: lowercase;
}

.tab h1 {
    font-family: "Bree Serif", sans-serif;
    display: flex;
    justify-content: center;
    margin: 20px auto;
}

h3,
.h3 {
    font-size: calc(1rem * 1.75);
    color: #4d5381f7;
}

.profile-side p i {
    color: #5b48b8;
    margin-right: 10px;
}
</style>
