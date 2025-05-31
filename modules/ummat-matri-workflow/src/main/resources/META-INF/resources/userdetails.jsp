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
	<portlet:param name="jspPage" value="/view.jsp" />
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
<div class="row">
	<div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 mb-30">
		<div class="pd-20 card-box height-100-p">
			<div class="profile-photo">
				<a href="modal" data-toggle="modal" data-target="#modal"
					class="edit-avatar"><i class="fa fa-pencil"></i></a> <img
					src="<%=userDetails.getPortraitURL(themeDisplay)%>" alt=""
					class="avatar-photo">
				<div class="modal fade" id="modal" tabindex="-1" role="dialog"
					aria-labelledby="modalLabel" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="modal-content">
							<div class="modal-body pd-5">
								<div class="img-container">
									<img id="image"
										src="<%=userDetails.getPortraitURL(themeDisplay)%>"
										alt="Picture">
								</div>
							</div>
							<div class="modal-footer">
								<input type="submit" value="Update" class="btn btn-primary">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<h5 class="text-center h5 mb-0"><%=fullName%></h5>
			<p class="text-center text-muted font-14">
				UMMATM<%=UserId%></p>
			<div class="profile-info">
				<h5 class="mb-20 h5 text-blue">Contact Information</h5>
				<ul>
					<li><span>Email Address:</span> <%=userDetails.getEmailAddress()%>
					</li>
					<li><span>Phone Number:</span> <%=userDetails.getScreenName()%>
					</li>
					<li>
						 <span>Country:</span> <%=matriUser.getCountryName()%>
					</li>
					
					<li><span>State:</span> <%=matriUser.getStateName() %><br> 
					 <span>District:</span> <%=matriUser.getDistrictName()%>
					  <span>Area:</span> <%=matriUser.getArea()%>
					</li>
				</ul>
			</div>
			<div class="profile-social">
				<h5 class="mb-20 h5 text-blue">Social Links</h5>
				<ul class="clearfix" id="sa-error">
					<li><a href="#" class="btn" data-bgcolor="#3b5998"
						data-color="#ffffff"><i class="fa fa-facebook"></i></a></li>
					<li><a href="#" class="btn" data-bgcolor="#f46f30"
						data-color="#ffffff"><i class="fa fa-instagram"></i></a></li>
					<li><a href="#" class="btn" data-bgcolor="#00b489"
						data-color="#ffffff"><i class="fa fa-whatsapp"></i></a></li>

				</ul>
			</div>

		</div>
	</div>
	<div class="col-xl-8 col-lg-8 col-md-8 col-sm-12 mb-30">
		<div class="card-box height-100-p overflow-hidden">
			<div class="profile-tab height-100-p">
				<div class="tab height-100-p">
					<ul class="nav nav-tabs customtab" role="tablist">
						<!-- <li class="nav-item">
											<a class="nav-link active" data-toggle="tab" href="#timeline" role="tab">Timeline</a>
										</li> -->
						<li class="nav-item"><a class="nav-link" data-toggle="tab"
							href="#tasks" role="tab">My Details</a></li>
						<li class="nav-item"><a class="nav-link" data-toggle="tab"
							href="#setting" role="tab">Settings</a></li>
					</ul>
					<!-- <div class="tab-content">
										Timeline Tab start
										<div class="tab-pane fade show active" id="timeline" role="tabpanel">
											<div class="pd-20">
												<div class="profile-timeline">
													<div class="timeline-month">
														<h5>August, 2020</h5>
													</div>
													<div class="profile-timeline-list">
														<ul>
															<li>
																<div class="date">12 Aug</div>
																<div class="task-name"><i class="ion-android-alarm-clock"></i> Task Added</div>
																<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
																<div class="task-time">09:30 am</div>
															</li>
															<li>
																<div class="date">10 Aug</div>
																<div class="task-name"><i class="ion-ios-chatboxes"></i> Task Added</div>
																<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
																<div class="task-time">09:30 am</div>
															</li>
															<li>
																<div class="date">10 Aug</div>
																<div class="task-name"><i class="ion-ios-clock"></i> Event Added</div>
																<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
																<div class="task-time">09:30 am</div>
															</li>
															<li>
																<div class="date">10 Aug</div>
																<div class="task-name"><i class="ion-ios-clock"></i> Event Added</div>
																<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
																<div class="task-time">09:30 am</div>
															</li>
														</ul>
													</div>
													<div class="timeline-month">
														<h5>July, 2020</h5>
													</div>
													<div class="profile-timeline-list">
														<ul>
															<li>
																<div class="date">12 July</div>
																<div class="task-name"><i class="ion-android-alarm-clock"></i> Task Added</div>
																<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
																<div class="task-time">09:30 am</div>
															</li>
															<li>
																<div class="date">10 July</div>
																<div class="task-name"><i class="ion-ios-chatboxes"></i> Task Added</div>
																<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
																<div class="task-time">09:30 am</div>
															</li>
														</ul>
													</div>
													<div class="timeline-month">
														<h5>June, 2020</h5>
													</div>
													<div class="profile-timeline-list">
														<ul>
															<li>
																<div class="date">12 June</div>
																<div class="task-name"><i class="ion-android-alarm-clock"></i> Task Added</div>
																<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
																<div class="task-time">09:30 am</div>
															</li>
															<li>
																<div class="date">10 June</div>
																<div class="task-name"><i class="ion-ios-chatboxes"></i> Task Added</div>
																<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
																<div class="task-time">09:30 am</div>
															</li>
															<li>
																<div class="date">10 June</div>
																<div class="task-name"><i class="ion-ios-clock"></i> Event Added</div>
																<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
																<div class="task-time">09:30 am</div>
															</li>
														</ul>
													</div>
												</div>
											</div>
										</div> -->
					<!-- Timeline Tab End -->
					<!-- Tasks Tab start -->
					<div class="tab-pane fade show active" id="tasks" role="tabpanel">
						<div class="pd-20 profile-task-wrap">
							<div class="container pd-0">
								<!-- Open Task start -->
								<div class="task-title row align-items-center">
									<div class="col-md-8 col-sm-12">
										<h5>Personal Detials</h5>
									</div>
									<div class="col-md-4 col-sm-12 text-right">
										<a href="task-add" data-toggle="modal" data-target="#task-add"
											class="bg-light-blue btn text-blue weight-500"><i
											class="ion-plus-round"></i> Add</a>
									</div>
								</div>
								<div class="table-responsive pb-3">
									<table class="table table-bordered table-striped">
										<tbody>
											<tr>
												<th>Jamath</th>
												<td><%= matriUser.getJamath() %></td>
											</tr>
											<tr>
												<th>Age</th>
												<td>
													<%
                        Date birthday = userDetails.getBirthday(); 
                        Calendar birthCal = Calendar.getInstance(); 
                        birthCal.setTime(birthday); 
                        Calendar today = Calendar.getInstance(); 
                        int age = today.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR); 
                        if (today.get(Calendar.DAY_OF_YEAR) < birthCal.get(Calendar.DAY_OF_YEAR)) { 
                            age--; 
                        } 
                    %> <%= age %>
												</td>
											</tr>
											<tr>
												<th>Height</th>
												<td><%= matriUser.getHeight() %></td>
											</tr>
											<tr>
												<th>Weight</th>
												<td><%= matriUser.getWeight() %></td>
											</tr>
											<tr>
												<th>Education</th>
												<td><%= matriUser.getEducation() %></td>
											</tr>
											<tr>
												<th>Job</th>
												<td><%= userDetails.getJobTitle() %></td>
											</tr>
											<tr>
												<th>Mother Language</th>
												<td><%= matriUser.getMothertongueLanguage() %></td>
											</tr>
											<tr>
												<th>Religion</th>
												<td><%= matriUser.getConvertMuslim() %></td>
											</tr>
											<tr>
												<th>Marital Status</th>
												<td><%= matriUser.getMaritalStatus() %></td>
											</tr>
											<tr>
												<th>Color</th>
												<td><%= matriUser.getColor() %></td>
											</tr>
											<tr>
												<th>Bio</th>
												<td><%= matriUser.getBio() %></td>
											</tr>
											<tr>
												<th>Childs</th>
												<td><%= matriUser.getMalechild() %></td>
											</tr>
											<tr>
												<th>Living Place</th>
												<td><%= matriUser.getLivingPlace() %></td>
											</tr>
										</tbody>
									</table>
								</div>

								<!-- Open Task End -->
								<!-- Close Task start -->
								<!-- <div class="task-title row align-items-center">
														<div class="col-md-12 col-sm-12">
															<h5>Closed Tasks</h5>
														</div>
													</div> -->
								<!-- <div class="profile-task-list close-tasks">
														<ul>
															<li>
																<div class="custom-control custom-checkbox mb-5">
																	<input type="checkbox" class="custom-control-input" id="task-close-1" checked="" disabled="">
																	<label class="custom-control-label" for="task-close-1"></label>
																</div>
																<div class="task-type">Email</div>
																Lorem ipsum dolor sit amet, consectetur adipisicing elit. Id ea earum.
																<div class="task-assign">Assigned to Ferdinand M. <div class="due-date">due date <span>22 February 2018</span></div></div>
															</li>
															<li>
																<div class="custom-control custom-checkbox mb-5">
																	<input type="checkbox" class="custom-control-input" id="task-close-2" checked="" disabled="">
																	<label class="custom-control-label" for="task-close-2"></label>
																</div>
																<div class="task-type">Email</div>
																Lorem ipsum dolor sit amet.
																<div class="task-assign">Assigned to Ferdinand M. <div class="due-date">due date <span>22 February 2018</span></div></div>
															</li>
															<li>
																<div class="custom-control custom-checkbox mb-5">
																	<input type="checkbox" class="custom-control-input" id="task-close-3" checked="" disabled="">
																	<label class="custom-control-label" for="task-close-3"></label>
																</div>
																<div class="task-type">Email</div>
																Lorem ipsum dolor sit amet, consectetur adipisicing elit.
																<div class="task-assign">Assigned to Ferdinand M. <div class="due-date">due date <span>22 February 2018</span></div></div>
															</li>
															<li>
																<div class="custom-control custom-checkbox mb-5">
																	<input type="checkbox" class="custom-control-input" id="task-close-4" checked="" disabled="">
																	<label class="custom-control-label" for="task-close-4"></label>
																</div>
																<div class="task-type">Email</div>
																Lorem ipsum dolor sit amet. Id ea earum.
																<div class="task-assign">Assigned to Ferdinand M. <div class="due-date">due date <span>22 February 2018</span></div></div>
															</li>
														</ul>
													</div> -->
								<!-- Close Task start -->
								<!-- add task popup start -->
								<div class="modal fade customscroll" id="task-add" tabindex="-1"
									role="dialog">
									<div class="modal-dialog modal-dialog-centered" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="exampleModalLongTitle">Updated
													Detials</h5>
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close" data-toggle="tooltip"
													data-placement="bottom" title=""
													data-original-title="Close Modal">
													<span aria-hidden="true">&times;</span>
												</button>
											</div>
											<div class="modal-body pd-0">
												<div class="task-list-form">
													<ul>
														<li>
															<form>
																<div class="form-group row">
																	<label class="col-md-4">Bio</label>
																	<div class="col-md-8">
																		<input type="text" class="form-control">
																	</div>
																</div>
																<div class="form-group row">
																	<label class="col-md-4">expectation</label>
																	<div class="col-md-8">
																		<textarea class="form-control"></textarea>
																	</div>
																</div>
																<div class="form-group row">
																	<label class="col-md-4">Selected Jamath</label>
																	<div class="col-md-8">
																		<select class="selectpicker form-control"
																			data-style="btn-outline-primary" title="Not Chosen"
																			multiple="" data-selected-text-format="count"
																			data-count-selected-text="{0} people selected">
																			<option>TNTJ</option>
																			<option>Thoweed Jamath</option>
																			<option>Sunnath Jamath</option>
																			<option>Other</option>

																		</select>
																	</div>
																</div>
																<div class="form-group row mb-0">
																	<label class="col-md-4">Due Date</label>
																	<div class="col-md-8">
																		<input type="text" class="form-control date-picker">
																	</div>
																</div>
															</form>
														</li>
														<li><a href="javascript:;" class="remove-task"
															data-toggle="tooltip" data-placement="bottom" title=""
															data-original-title="Remove Task"><i
																class="ion-minus-circled"></i></a>
															<form>
																<div class="form-group row">
																	<label class="col-md-4">Task Type</label>
																	<div class="col-md-8">
																		<input type="text" class="form-control">
																	</div>
																</div>
																<div class="form-group row">
																	<label class="col-md-4">Task Message</label>
																	<div class="col-md-8">
																		<textarea class="form-control"></textarea>
																	</div>
																</div>
																<div class="form-group row">
																	<label class="col-md-4">Assigned to</label>
																	<div class="col-md-8">
																		<select class="selectpicker form-control"
																			data-style="btn-outline-primary" title="Not Chosen"
																			multiple="" data-selected-text-format="count"
																			data-count-selected-text="{0} people selected">
																			<option>Ferdinand M.</option>
																			<option>Don H. Rabon</option>
																			<option>Ann P. Harris</option>
																			<option>Katie D. Verdin</option>
																			<option>Christopher S. Fulghum</option>
																			<option>Matthew C. Porter</option>
																		</select>
																	</div>
																</div>
																<div class="form-group row mb-0">
																	<label class="col-md-4">Due Date</label>
																	<div class="col-md-8">
																		<input type="text" class="form-control date-picker">
																	</div>
																</div>
															</form></li>
													</ul>
												</div>
												<div class="add-more-task">
													<a href="#" data-toggle="tooltip" data-placement="bottom"
														title="" data-original-title="Add Task"><i
														class="ion-plus-circled"></i> Add More Task</a>
												</div>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-primary">Add</button>
												<button type="button" class="btn btn-secondary"
													data-dismiss="modal">Close</button>
											</div>
										</div>
									</div>
								</div>
								<!-- add task popup End -->
							</div>
						</div>
					</div>
					<!-- Tasks Tab End -->
					<!-- Setting Tab start -->
					<div class="tab-pane fade height-100-p" id="setting"
						role="tabpanel">
						<div class="profile-setting">
							<form>
								<ul class="profile-edit-list row">
									<li class="weight-500 col-md-6">
										<h4 class="text-blue h5 mb-20">Edit Your Personal Setting</h4>
										<div class="form-group">
											<label>Full Name</label> <input
												class="form-control form-control-lg" type="text">
										</div>
										<div class="form-group">
											<label>Title</label> <input
												class="form-control form-control-lg" type="text">
										</div>
										<div class="form-group">
											<label>Email</label> <input
												class="form-control form-control-lg" type="email">
										</div>
										<div class="form-group">
											<label>Date of birth</label> <input
												class="form-control form-control-lg date-picker" type="text">
										</div>
										<div class="form-group">
											<label>Gender</label>
											<div class="d-flex">
												<div class="custom-control custom-radio mb-5 mr-20">
													<input type="radio" id="customRadio4" name="customRadio"
														class="custom-control-input"> <label
														class="custom-control-label weight-400" for="customRadio4">Male</label>
												</div>
												<div class="custom-control custom-radio mb-5">
													<input type="radio" id="customRadio5" name="customRadio"
														class="custom-control-input"> <label
														class="custom-control-label weight-400" for="customRadio5">Female</label>
												</div>
											</div>
										</div>
										<div class="form-group">
											<label>Country</label> <select
												class="selectpicker form-control form-control-lg"
												data-style="btn-outline-secondary btn-lg" title="Not Chosen">
												<option>United States</option>
												<option>India</option>
												<option>United Kingdom</option>
											</select>
										</div>
										<div class="form-group">
											<label>State/Province/Region</label> <input
												class="form-control form-control-lg" type="text">
										</div>
										<div class="form-group">
											<label>Postal Code</label> <input
												class="form-control form-control-lg" type="text">
										</div>
										<div class="form-group">
											<label>Phone Number</label> <input
												class="form-control form-control-lg" type="text">
										</div>
										<div class="form-group">
											<label>Address</label>
											<textarea class="form-control"></textarea>
										</div>
										<div class="form-group">
											<label>Visa Card Number</label> <input
												class="form-control form-control-lg" type="text">
										</div>
										<div class="form-group">
											<label>Paypal ID</label> <input
												class="form-control form-control-lg" type="text">
										</div>
										<div class="form-group">
											<div class="custom-control custom-checkbox mb-5">
												<input type="checkbox" class="custom-control-input"
													id="customCheck1-1"> <label
													class="custom-control-label weight-400"
													for="customCheck1-1">I agree to receive
													notification emails</label>
											</div>
										</div>
										<div class="form-group mb-0">
											<input type="submit" class="btn btn-primary"
												value="Update Information">
										</div>
									</li>
									<li class="weight-500 col-md-6">
										<h4 class="text-blue h5 mb-20">Edit Social Media links</h4>
										<div class="form-group">
											<label>Facebook URL:</label> <input
												class="form-control form-control-lg" type="text"
												placeholder="Paste your link here">
										</div>

										<div class="form-group">
											<label>Instagram URL:</label> <input
												class="form-control form-control-lg" type="text"
												placeholder="Paste your link here">
										</div>

										<div class="form-group">
											<label>Whatsapp URL:</label> <input
												class="form-control form-control-lg" type="text"
												placeholder="Paste your link here">
										</div>
										<div class="form-group mb-0">
											<input type="submit" class="btn btn-primary"
												value="Save & Update">
										</div>
									</li>
								</ul>
							</form>
						</div>
					</div>
					<!-- Setting Tab End -->
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
.profile-setting {
	margin-top: -98% !important;
}

body {
	background-color: #f8f9fa;
}

.profile-card, .info-card, .side-card {
	background: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	margin-bottom: 20px;
}

.profile-pic img {
	border-radius: 8px;
	width: 120px;
	height: 120px;
}

.btn-custom {
	margin-right: 5px;
}

.progress {
	height: 20px;
}

.progress-bar {
	font-weight: bold;
}

.profile-photo {
	width: 127px !important;
	height: 157px !important;
}

h2.portlet-title-text {
	display: none !important;
}
</style>