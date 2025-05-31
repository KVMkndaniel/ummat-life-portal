<%@page import="com.liferay.portal.kernel.model.Region"%>
<%@page
	import="com.liferay.portal.kernel.service.CountryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Country"%>
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
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>

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

<div class="matrimony-profile-container">
    <div class="profile-header">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-md-8">
                    <h1 class="profile-name"><%=fullName%></h1>
                    <p class="profile-id">UMMATM<%=UserId%></p>
                    <div class="profile-meta">
                        <span><i class="fas fa-map-marker-alt"></i> <%=matriUser.getCountryName()%>, <%=matriUser.getStateName()%></span>
                        <span><i class="fas fa-user"></i> 
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
                            <%= age %> years
                        </span>
                        <span><i class="fas fa-heart"></i> <%=matriUser.getMaritalStatus()%></span>
                    </div>
                </div>
                <div class="col-md-4 text-md-right">
                    <!-- <button class="btn btn-primary btn-lg"><i class="fas fa-heart"></i> Express Interest</button> -->
                    <button class="btn btn-outline-warning btn-lg"><i class="fas fa-comment"></i> Message</button>
                </div>
            </div>
        </div>
    </div>

    <div class="container profile-content mt-4">
        <div class="row">
            <!-- Left Sidebar -->
            <div class="col-lg-4">
                <div class="card profile-card">
                    <div class="profile-photo-container">
                        <img src="<%=userDetails.getPortraitURL(themeDisplay)%>" alt="Profile Photo" class="profile-photo">
                        <a href="#" class="edit-photo-btn" data-toggle="modal" data-target="#photoModal">
                            <i class="fas fa-camera"></i>
                        </a>
                    </div>
                    
                    <div class="profile-basic-info">
                        <h4>Basic Information</h4>
                        <ul class="info-list">
                            <li>
                                <span class="info-label">Height:</span>
                                <span class="info-value"><%= matriUser.getHeight() %></span>
                            </li>
                            <li>
                                <span class="info-label">Religion:</span>
                                <span class="info-value"><%= matriUser.getConvertMuslim() %></span>
                            </li>
                            <li>
                                <span class="info-label">Mother Tongue:</span>
                                <span class="info-value"><%= matriUser.getMothertongueLanguage() %></span>
                            </li>
                            <li>
                                <span class="info-label">Education:</span>
                                <span class="info-value"><%= matriUser.getEducation() %></span>
                            </li>
                            <li>
                                <span class="info-label">Profession:</span>
                                <span class="info-value"><%= userDetails.getJobTitle() %></span>
                            </li>
                        </ul>
                    </div>
                    
                    <div class="profile-contact-info mt-4">
                        <h4>Contact Information</h4>
                        <ul class="info-list">
                            <li>
                                <span class="info-label"><i class="fas fa-envelope"></i> Email:</span>
                                <span class="info-value"><%=userDetails.getEmailAddress()%></span>
                            </li>
                            <li>
                                <span class="info-label"><i class="fas fa-phone"></i> Phone:</span>
                                <span class="info-value"><%=userDetails.getScreenName()%></span>
                            </li>
                            <li>
                                <span class="info-label"><i class="fas fa-map-marker-alt"></i> Location:</span>
                                <span class="info-value">
                                    <%=matriUser.getCountryName()%>, <%=matriUser.getStateName() %>, 
                                    <%=matriUser.getDistrictName()%>, <%=matriUser.getArea()%>
                                </span>
                            </li>
                        </ul>
                    </div>
                    
                    <div class="profile-social mt-4">
                        <h4>Social Connections</h4>
                        <div class="social-links">
                            <a href="#" class="social-link facebook"><i class="fab fa-facebook-f"></i></a>
                            <a href="#" class="social-link instagram"><i class="fab fa-instagram"></i></a>
                            <a href="#" class="social-link whatsapp"><i class="fab fa-whatsapp"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            
            <!-- Main Content -->
            <div class="col-lg-8">
                <div class="card main-profile-card">
                    <nav class="profile-nav">
                        <div class="nav nav-tabs" id="profileTab" role="tablist">
                            <a class="nav-item nav-link active" id="about-tab" data-toggle="tab" href="#about" role="tab">About</a>
                            <a class="nav-item nav-link" id="family-tab" data-toggle="tab" href="#family" role="tab">Family</a>
                            <a class="nav-item nav-link" id="preferences-tab" data-toggle="tab" href="#preferences" role="tab">Preferences</a>
                            <a class="nav-item nav-link" id="gallery-tab" data-toggle="tab" href="#gallery" role="tab">Gallery</a>
                        </div>
                    </nav>
                    
                    <div class="tab-content" id="profileTabContent">
                        <!-- About Tab -->
                        <div class="tab-pane fade show active" id="about" role="tabpanel">
                            <div class="profile-section">
                                <h3>Bio</h3>
                                <p><%= matriUser.getBio() %></p>
                            </div>
                            
                            <div class="profile-section">
                                <h3>Personal Details</h3>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="detail-item">
                                            <span class="detail-label">Jamath:</span>
                                            <span class="detail-value"><%= matriUser.getJamath() %></span>
                                        </div>
                                        <div class="detail-item">
                                            <span class="detail-label">Height:</span>
                                            <span class="detail-value"><%= matriUser.getHeight() %></span>
                                        </div>
                                        <div class="detail-item">
                                            <span class="detail-label">Weight:</span>
                                            <span class="detail-value"><%= matriUser.getWeight() %></span>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="detail-item">
                                            <span class="detail-label">Color:</span>
                                            <span class="detail-value"><%= matriUser.getColor() %></span>
                                        </div>
                                        <div class="detail-item">
                                            <span class="detail-label">Living Place:</span>
                                            <span class="detail-value"><%= matriUser.getLivingPlace() %></span>
                                        </div>
                                        <div class="detail-item">
                                            <span class="detail-label">Children:</span>
                                            <span class="detail-value"><%= matriUser.getMalechild() %></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="profile-section">
                                <h3>Education & Career</h3>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="detail-item">
                                            <span class="detail-label">Education:</span>
                                            <span class="detail-value"><%= matriUser.getEducation() %></span>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="detail-item">
                                            <span class="detail-label">Profession:</span>
                                            <span class="detail-value"><%= userDetails.getJobTitle() %></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <!-- Family Tab -->
                        <div class="tab-pane fade" id="family" role="tabpanel">
                            <div class="profile-section">
                                <h3>Family Information</h3>
                                <p>Family details would be displayed here.</p>
                            </div>
                        </div>
                        
                        <!-- Preferences Tab -->
                        <div class="tab-pane fade" id="preferences" role="tabpanel">
                            <div class="profile-section">
                                <h3>Partner Preferences</h3>
                                <p>Partner preference details would be displayed here.</p>
                            </div>
                        </div>
                        
                        <!-- Gallery Tab -->
                        <div class="tab-pane fade" id="gallery" role="tabpanel">
                            <div class="profile-section">
                                <h3>Photo Gallery</h3>
                                <div class="profile-gallery">
                                    <div class="row">
                                        <div class="col-6 col-md-4">
                                            <img src="<%=userDetails.getPortraitURL(themeDisplay)%>" class="gallery-thumbnail" alt="Profile Photo">
                                        </div>
                                        <!-- Additional photos would go here -->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <!-- Interest/Message Buttons for Mobile -->
                <div class="profile-action-buttons d-lg-none mt-3">
                    <button class="btn btn-primary btn-block"><i class="fas fa-heart"></i> Express Interest</button>
                    <button class="btn btn-outline-primary btn-block"><i class="fas fa-comment"></i> Send Message</button>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Photo Modal -->
<div class="modal fade" id="photoModal" tabindex="-1" role="dialog" aria-labelledby="photoModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="photoModalLabel">Profile Photo</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body text-center">
                <img src="<%=userDetails.getPortraitURL(themeDisplay)%>" class="img-fluid" alt="Profile Photo">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Update Photo</button>
            </div>
        </div>
    </div>
</div>

<style>
/* Modern Profile Styles */
.matrimony-profile-container {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    color: #333;
}

.profile-header {
    background: linear-gradient(135deg, #6a11cb 0%, #2575fc 100%);
    color: white;
    padding: 2rem 0;
    margin-bottom: 2rem;
}

.profile-name {
    font-weight: 700;
    margin-bottom: 0.5rem;
}

.profile-id {
    color: rgba(255,255,255,0.8);
    margin-bottom: 1rem;
}

.profile-meta span {
    margin-right: 1.5rem;
    font-size: 0.9rem;
}

.profile-meta i {
    margin-right: 0.3rem;
}

.profile-card, .main-profile-card {
    border: none;
    border-radius: 10px;
    box-shadow: 0 5px 15px rgba(0,0,0,0.05);
    margin-bottom: 1.5rem;
    overflow: hidden;
}

.profile-photo-container {
    position: relative;
    width: 100%;
    padding-top: 100%;
    overflow: hidden;
    border-radius: 10px 10px 0 0;
}

.profile-photo {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    object-fit: cover;
}

.edit-photo-btn {
    position: absolute;
    bottom: 15px;
    right: 15px;
    background: white;
    width: 40px;
    height: 40px;
    border-radius: 50%;
    display: flex;
    align-items: center;
    justify-content: center;
    color: #2575fc;
    box-shadow: 0 3px 10px rgba(0,0,0,0.2);
    transition: all 0.3s ease;
}

.edit-photo-btn:hover {
    transform: scale(1.1);
    color: #6a11cb;
}

.profile-basic-info, .profile-contact-info, .profile-social {
    padding: 1.5rem;
}

.profile-basic-info h4, .profile-contact-info h4, .profile-social h4 {
    font-weight: 600;
    margin-bottom: 1.2rem;
    color: #2575fc;
    border-bottom: 1px solid #eee;
    padding-bottom: 0.5rem;
}

.info-list {
    list-style: none;
    padding: 0;
    margin: 0;
}

.info-list li {
    margin-bottom: 0.8rem;
    display: flex;
    justify-content: space-between;
}

.info-label {
    font-weight: 500;
    color: #666;
}

.info-value {
    font-weight: 600;
    color: #333;
}

.social-links {
    display: flex;
    gap: 10px;
}

.social-link {
    width: 40px;
    height: 40px;
    border-radius: 50%;
    display: flex;
    align-items: center;
    justify-content: center;
    color: white;
    transition: all 0.3s ease;
}

.social-link.facebook {
    background: #3b5998;
}

.social-link.instagram {
    background: #e1306c;
}

.social-link.whatsapp {
    background: #25D366;
}

.social-link:hover {
    transform: translateY(-3px);
    box-shadow: 0 5px 15px rgba(0,0,0,0.1);
}

.profile-nav {
    border-bottom: 1px solid #eee;
}

.profile-nav .nav-link {
    color: #666;
    font-weight: 500;
    border: none;
    padding: 1rem 1.5rem;
    transition: all 0.3s ease;
}

.profile-nav .nav-link.active {
    color: #2575fc;
    background: transparent;
    border-bottom: 3px solid #2575fc;
}

.profile-section {
    padding: 1.5rem;
    border-bottom: 1px solid #eee;
}

.profile-section:last-child {
    border-bottom: none;
}

.profile-section h3 {
    font-weight: 600;
    margin-bottom: 1.2rem;
    color: #333;
}

.detail-item {
    margin-bottom: 1rem;
}

.detail-label {
    font-weight: 500;
    color: #666;
    display: block;
}

.detail-value {
    font-weight: 600;
    color: #333;
}

.profile-gallery {
    padding: 1rem 0;
}

.gallery-thumbnail {
    width: 100%;
    height: 120px;
    object-fit: cover;
    border-radius: 8px;
    margin-bottom: 1rem;
    transition: all 0.3s ease;
    cursor: pointer;
}

.gallery-thumbnail:hover {
    transform: scale(1.05);
    box-shadow: 0 5px 15px rgba(0,0,0,0.1);
}

.profile-action-buttons .btn {
    margin-bottom: 0.5rem;
}

/* Responsive Adjustments */
@media (max-width: 991.98px) {
    .profile-header {
        padding: 1.5rem 0;
    }
    
    .profile-name {
        font-size: 1.5rem;
    }
    
    .profile-meta span {
        display: block;
        margin-bottom: 0.5rem;
    }
}

@media (max-width: 767.98px) {
    .profile-photo-container {
        width: 150px;
        height: 150px;
        padding-top: 0;
        margin: 0 auto;
        border-radius: 50%;
    }
    
    .profile-header {
        text-align: center;
    }
    
    .profile-header .col-md-4 {
        margin-top: 1rem;
    }
    
    .profile-nav .nav-link {
        padding: 0.75rem;
        font-size: 0.9rem;
    }
}
h2.portlet-title-text {
    display: none !important;
}

		.logo {
    width: 19% !important;
}

.active-profile {
    margin-left: -307px !important;
  }
  .navbar-collapse {
    padding-left: 274px !important;
  }
  .navbar {
  padding: 5px !important;
}
.slider-wrap {
    margin-top: -17px;
  }

</style>

<script>
$(document).ready(function() {
    // Initialize tooltips
    $('[data-toggle="tooltip"]').tooltip();
    
    // Profile tab switching
    $('#profileTab a').on('click', function (e) {
        e.preventDefault();
        $(this).tab('show');
    });
    
    // Photo modal
    $('.gallery-thumbnail').click(function() {
        var imgSrc = $(this).attr('src');
        $('#photoModal img').attr('src', imgSrc);
        $('#photoModal').modal('show');
    });
    
    // Smooth scrolling for anchor links
    $('a[href*="#"]').on('click', function(e) {
        e.preventDefault();
        $('html, body').animate(
            {
                scrollTop: $($(this).attr('href')).offset().top,
            },
            500,
            'linear'
        );
    });
});
</script>

<%
        } catch (PortalException e) {
            // Handle exception when user details are not found
%>
<div class="alert alert-danger">User not found. Please check the user ID.</div>
<%
        }
    } else {
        // Handle case when the provided user ID is not valid
%>
<div class="alert alert-warning">Invalid user ID provided.</div>
<%
    }
%>