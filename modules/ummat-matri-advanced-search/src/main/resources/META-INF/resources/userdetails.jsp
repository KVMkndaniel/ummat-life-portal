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

<!--Inner Heading Start-->
<div class="inner-heading">
  <div class="container">
    <h3>Ummat Nikkha Profile</h3>
  </div>
</div>
<!--Inner Heading End--> 




<!--Inner Content Start-->
<div class="inner-content">
  <div class="container">
    <div class="userdetailbox">
      <div class="row">
        <div class="col-lg-2 col-md-3">
          <div class="profile-picture">
            <div class="mx-auto profile-radius">
              <div class="profile_img"><img src="images/author-img.jpg" alt=""></div>
            </div>
          </div>
        </div>
        <div class="col-lg-10 col-md-9">
          <h3><%=fullName%></h3>
          <ul>
            <li><span>ProfileId</span>: UNIKKHA<%=UserId%></li>
            <li><span>Status</span>: <%=matriUser.getMaritalStatus()%></li>
            <li><span>Jamath</span>: <%= matriUser.getJamath() %></li>
            <li><i class="fas fa-map-marker-alt"></i> <%=matriUser.getCountryName()%>, <%=matriUser.getStateName()%></li>
          </ul>
        </div>
      </div>
    </div>
    <div class="usertabls">
      <ul>
        <li><a href="#" data-toggle="modal" data-target="#sendproposal"><i class="far fa-heart"></i> Send Proposal </a></li>
        <li><a href="#" data-toggle="modal" data-target="#sendmessage"><i class="far fa-comment"></i> Send Message </a></li>
     <!--    <li><a href="#"><i class="far fa-star"></i> Follow </a></li> -->
        <li><a href="#"><i class="far fa-envelope"></i> Report this profile Fake </a></li>
       <!--  <li class="views"><i class="far fa-eye"></i> 255 Views</li> -->
      </ul>
    </div>
    <div class="profile-Wrap">
      <div class="row">
        <div class="col-lg-4 col-md-4">
          <div class="introbox">
            <h4> Bio </h4>
            <p><%=matriUser.getBio()%></p>
          </div>
          <div class="hiddengal">
            <h3>Gallery Hidden</h3>
            <p>Photos are Hidden by user, if you are interested in this profile then send request to unlock for you.</p>
            <div class="viewbtn"><a href="#" data-toggle="modal" data-target="#picrequest">Request For Pictures</a></div>
          </div>
          <div class="authorgallery">
            <h2> Gallery </h2>
            <div class="row">
              <div class="col-lg-4 col-md-6 col-6">
                <div class="work_item ">
                  <div class="work"> <a href="images/users/01.jpg" title="Profile Gallery" data-lightbox="example-set" data-title="" class="lightbox-image work_image"> <img class="example-image" src="images/users/01.jpg" alt="Profile Gallery">
                    <div class="caption">
                      <div class="caption-box"> <i class="fas fa-plus"></i></div>
                    </div>
                    </a> </div>
                </div>
              </div>           
            </div>
          </div>
          <div class="google-add"><img src="images/gad-3.jpg" alt=""></div>
        </div>
        <div class="col-lg-8 col-md-8">
          <div class="viewpage">
            <ul class="nav nav-tabs profiletabs" id="usertabs" role="tablist">
              <li class="nav-item"> <a class="nav-link active" id="overview-tab" data-toggle="tab" href="#overview" role="tab" aria-controls="home" aria-selected="true">About</a> </li>
              <li class="nav-item"> <a class="nav-link" id="lookingfor-tab" data-toggle="tab" href="#lookingfor" role="tab" aria-controls="profile" aria-selected="false">Looking For</a> </li>
            </ul>
            <div class="tab-content userinfotabs" id="usertabsContent">
              <div class="tab-pane fade show active" id="overview" role="tabpanel" aria-labelledby="overview-tab">
                <div class="info-box">
                  <div class="header">
                    <h4 class="title">General Overview </h4>
                  </div>
                  <div class="row">
                    <div class="col-md-6">
                      <div class="content">
                        <ul class="infolist">
                          <li> <span> FIRST NAME </span> <span> <%=userDetails.getFirstName()%> </span> </li>
                          <li> <span> GENDER </span> <span> <%= userDetails.getMale() ? "Male" : "Female" %></span> </li>
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
                          <li> <span> AGE </span> <span> <%= age %> </span> </li>
                          <li> <span> NUMBER OF CHILDREN</span> <span> <%=matriUser.getMalechild()%></span> </li>
                          <li> <span> ON BEHALF</span> <span>Self </span> </li>
                          <li> <span> DATE OF BIRTH </span> <span> 13/12/1992 </span> </li>
                        </ul>
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="content">
                        <ul class="infolist">
                          <li> <span> LAST NAME </span> <span> <%= userDetails.getLastName()%> </span> </li>
                          <li> <span> EMAIL </span> <span> <%= userDetails.getEmailAddress() %></span> </li>
                          <li> <span>MARITAL STATUS </span> <span> Never Married </span> </li>
                          <li> <span> MOBILE</span> <span> <%= userDetails.getScreenName()%> </span> </li>
                          <li> <span> MOTHER TONGUE </span> <span> <%=matriUser.getMothertongueLanguage()%> </span> </li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="info-box">
                  <div class="header">
                    <h4 class="title"> Living at </h4>
                  </div>
                  <div class="row">
                    <div class="col-md-6">
                      <div class="content">
                        <ul class="infolist">
                          <li> <span> COUNTRY </span><%=matriUser.getCountryName()%> </li>
                          <li> <span> STATE </span><%=matriUser.getStateName()%> </li>
                        </ul>
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="content">
                        <ul class="infolist">
                          <li> <span>District</span> <span><%=matriUser.getDistrictName()%> </span> </li>
                          <li> <span>AREA</span> <span> <%=matriUser.getArea()%></span> </li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="info-box">
                  <div class="header">
                    <h4 class="title"> Qualification And Career </h4>
                  </div>
                  <div class="row">
                    <div class="col-md-6">
                      <div class="content">
                        <ul class="infolist">
                          <li> <span> HIGHEST EDUCATION </span> <span> <%=matriUser.getEducation()%> </span> </li>
                          <li> <span> ANNUAL INCOME </span> <span> <%=matriUser.getMonthlyincome()%></span> </li>
                        </ul>
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="content">
                        <ul class="infolist">
                          <li> <span> OCCUPATION </span> <span><%=userDetails.getJobTitle()%></span> </li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="info-box">
                  <div class="header">
                    <h4 class="title"> Physical Info</h4>
                  </div>
                  <div class="row">
                    <div class="col-md-6">
                      <div class="content">
                        <ul class="infolist">
                          <li> <span> HEIGHT </span> <span> <%=matriUser.getHeight()%> </span> </li>
                          <li> <span> COLOR </span> <span> <%=matriUser.getColor()%></span> </li>
                          <li> <span> COMPLEXION </span> <span>  </span> </li>
                          <li> <span> BODY TYPE </span> <span> </span> </li>
                          <li> <span> ANY DISABILITY </span> <span>  </span> </li>
                        </ul>
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="content">
                        <ul class="infolist">
                          <li> <span> WEIGHT </span> <span><%=matriUser.getWeight()%> </span> </li>
                          <li> <span> HAIR COLOR </span> <span> </span> </li>
                          <li> <span> BLOOD GROUP </span> <span> </span> </li>
                          <li> <span> BODY ART </span> <span>  </span> </li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="info-box">
                  <div class="header">
                    <h4 class="title"> Hobbies</h4>
                  </div>
                  <div class="row">
                    <div class="col-md-12">
                      <div class="content">
                        <ul class="infolist">
                          <li> <span> HOBBY </span> <span> INTEREST </span> </li>
                          <li> <span> MUSIC </span> <span> BOOKS</span> </li>
                          <li> <span> MOVIE </span> <span> TV SHOW</span> </li>
                          <li> <span> SPORTS SHOW </span> <span> FITNESS ACTIVITY</span> </li>
                          <li> <span> CUISINE </span> <span> DRESS STYLE</span> </li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="info-box">
                  <div class="header">
                    <h4 class="title">Social Background</h4>
                  </div>
                  <div class="row">
                    <div class="col-md-6">
                      <div class="content">
                        <ul class="infolist">
                          <li> <span> Jamath </span> <span> <%=matriUser.getJamath()%> </span> </li>
                          <li> <span> CASTE </span> <span> </span> </li>
                          <li> <span> PERSONAL VALUE </span> <span> Decent</span> </li>
                        </ul>
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="content">
                        <ul class="infolist">
                          <li> <span> LANGUAGE </span> <span> </span> </li>
                          <li> <span> FAMILY VALUE </span> <span>Moderate </span> </li>
                          <li> <span> FAMILY STATUS </span> <span>High Class </span> </li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="info-box">
                  <div class="header">
                    <h4 class="title">Life Style</h4>
                  </div>
                  <div class="row">
                    <div class="col-md-6">
                      <div class="content">
                        <ul class="infolist">
                          <li> <span> DIET </span> <span>  </span> </li>
                          <li> <span> SMOKE </span> <span> No </span> </li>
                        </ul>
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="content">
                        <ul class="infolist">
                          <li> <span> DRINK </span> <span>No </span> </li>
                          <li> <span> LIVING WITH </span> <span>Family </span> </li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="tab-pane fade" id="lookingfor" role="tabpanel" aria-labelledby="lookingfor-tab">
                <div class="info-box">
                  <div class="header">
                    <h4 class="title"> Partner Expectation </h4>
                  </div>
                  <div class="row">
                    <div class="col-md-6">
                      <div class="content">
                        <ul class="infolist">
                          <li> <span> GENERAL REQUIREMENT </span> <span> None </span> </li>
                          <li> <span> HEIGHT </span> <span> Doesn't Matter</span> </li>
                          <li> <span> MARITAL STATUS </span> <span> Never Married</span> </li>
                          <li> <span> COUNTRY OF RESIDENCE </span> <span> United States</span> </li>
                          <li> <span> CASTE / SECT </span> <span> Catholic</span> </li>
                          <li> <span> EDUCATION </span> <span> Doesn't Matter</span> </li>
                          <li> <span> DRINKING HABITS </span> <span> Doesn't Matter</span> </li>
                          <li> <span> DIET </span> <span> Doesn't Matter</span> </li>
                          <li> <span> PERSONAL VALUE </span> <span> Doesn't Matter</span> </li>
                          <li> <span> ANY DISABILITY </span> <span> None</span> </li>
                          <li> <span> FAMILY VALUE </span> <span> Doesn't Matter</span> </li>
                          <li> <span> PREFERED STATE </span> <span> Cambridge</span> </li>
                          <li> <span> COMPLEXION </span> <span> Doesn't Matter</span> </li>
                        </ul>
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="content">
                        <ul class="infolist">
                          <li> <span> AGE </span> <span>18-24 </span> </li>
                          <li> <span> WEIGHT </span> <span>Doesn't Matter </span> </li>
                          <li> <span> WITH CHILDREN ACCEPTABLES </span> <span>Doesn't Matter </span> </li>
                          <li> <span> RELIGION </span> <span>Cristianity </span> </li>
                          <li> <span> SUB CASTE </span> <span> </span> </li>
                          <li> <span> PROFESSION </span> <span>Professor </span> </li>
                          <li> <span> SMOKING HABITS </span> <span>Doesn't Matter </span> </li>
                          <li> <span> BODY TYPE </span> <span>Fit </span> </li>
                          <li> <span> MANGLIK </span> <span> </span> </li>
                          <li> <span> MOTHER TONGUE </span> <span>Bengali </span> </li>
                          <li> <span> PREFERED COUNTRY </span> <span>United Kingdom </span> </li>
                          <li> <span> PREFERED STATUS </span> <span>Doesn't Matter </span> </li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- <div class="google-add"><img src="images/google-add.jpg"></div> -->
    </div>
  </div>
</div>
<!--Inner Content End--> 
<style>
h2.portlet-title-text
 {
    display: none !important;
}
</style>

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