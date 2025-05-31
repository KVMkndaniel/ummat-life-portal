<%@page import="javax.portlet.PortletURL"%>
<%@ include file="./init.jsp" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="https://cdn.jsdelivr.net/npm/@mdi/font@6.5.95/css/materialdesignicons.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/dataTables.bootstrap5.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.4/js/dataTables.bootstrap5.min.js"></script>

<%
    List<User> pendingUsers = (List<User>) request.getAttribute("pendingUsers");
    List<User> inactiveUsers = (List<User>) request.getAttribute("inactiveUsers");
    PortletURL informationRenderURL = renderResponse.createRenderURL();
    informationRenderURL.setParameter("jspPage", "/userdetails.jsp");
%>

<div class="nikkha-container-fluid nikkha-py-4">
    <div class="nikkha-card nikkha-shadow-sm">
        <div class="nikkha-card-header nikkha-bg-white nikkha-border-bottom-0 nikkha-py-3">
            <div class="nikkha-d-flex nikkha-justify-content-between nikkha-align-items-center">
                <div>
                    <h5 class="nikkha-mb-0 nikkha-text-primary">Matrimony User Verification</h5>
                    <p class="nikkha-text-muted nikkha-mb-0">Manage user verification status and profiles</p>
                </div>
                <div class="nikkha-d-flex">
                    <div class="nikkha-input-group nikkha-me-3" style="width: 250px;">
                        <span class="nikkha-input-group-text nikkha-bg-transparent"><i class="mdi mdi-magnify"></i></span>
                        <input type="text" class="nikkha-form-control " placeholder="Search users..." id="nikkha-searchInput">
                    </div>
                </div>
            </div>
        </div>
        
        <div class="nikkha-card-body nikkha-pt-0">
            <ul class="nikkha-nav nikkha-nav-tabs nikkha-mb-4" id="nikkha-userTabs" role="tablist">
                <li class="nikkha-nav-item" role="presentation">
                    <button class="nikkha-nav-link nikkha-active" id="nikkha-inactive-tab" data-bs-toggle="tab" data-bs-target="#nikkha-inactive" type="button" role="tab">
                        Inactive Users <span class="nikkha-badge nikkha-bg-danger nikkha-ms-2"><%= inactiveUsers.size() %></span>
                    </button>
                </li>
                <li class="nikkha-nav-item" role="presentation">
                    <button class="nikkha-nav-link" id="nikkha-pending-tab" data-bs-toggle="tab" data-bs-target="#nikkha-pending" type="button" role="tab">
                        Pending Verification <span class="nikkha-badge nikkha-bg-warning nikkha-ms-2"><%= pendingUsers.size() %></span>
                    </button>
                </li>
            </ul>
            
            <div class="nikkha-tab-content" id="nikkha-userTabsContent">
                <div class="nikkha-tab-pane nikkha-fade nikkha-show nikkha-active" id="nikkha-inactive" role="tabpanel">
                    <div class="nikkha-table-responsive">
                        <table class="nikkha-table nikkha-table-hover nikkha-align-middle" id="nikkha-inactiveTable">
                            <thead class="nikkha-table-light">
                                <tr>
                                    <th width="50px">Profile</th>
                                    <th>Matri ID</th>
                                    <th>Full Name</th>
                                    <th>Email</th>
                                    <th>Mobile</th>
                                    <th>Status</th>
                                    <th width="150px">Verification</th>
                                    <th width="80px">Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% for (User user2 : inactiveUsers) { 
                                    int status = user2.getStatus(); 
                                    String statusText = "Unknown"; 
                                    String badgeClass = "nikkha-bg-secondary"; 

                                    if (status == 0) { 
                                        statusText = "Verified"; 
                                        badgeClass = "nikkha-bg-success"; 
                                    } else if (status == 1) { 
                                        statusText = "Pending"; 
                                        badgeClass = "nikkha-bg-warning"; 
                                    } else if (status == 2) { 
                                        statusText = "Inactive"; 
                                        badgeClass = "nikkha-bg-danger"; 
                                    } 

                                    informationRenderURL.setParameter("userId", String.valueOf(user2.getUserId())); 
                                %>
                                <tr>
                                    <td>
                                        <div class="nikkha-avatar nikkha-avatar-md">
                                            <img class="nikkha-rounded-circle" src="<%=user2.getPortraitURL(themeDisplay)%>" 
                                                alt="<%=user2.getFullName()%>" width="40" height="40">
                                        </div>
                                    </td>
                                    <td><span class="nikkha-fw-semibold">MAT<%= user2.getUserId() %></span></td>
                                    <td>
                                        <div class="nikkha-d-flex nikkha-flex-column">
                                            <span class="nikkha-fw-semibold"><%= user2.getFullName() %></span>
                                            <small class="nikkha-text-muted"><%= user2.getScreenName() %></small>
                                        </div>
                                    </td>
                                    <td><%= user2.getEmailAddress() %></td>
                                    <td><%= user2.getExpandoBridge().getAttribute("phone") != null ? user2.getExpandoBridge().getAttribute("phone") : "N/A" %></td>
                                    <td>
                                        <span class="nikkha-badge <%= badgeClass %> nikkha-rounded-pill"><%= statusText %></span>
                                    </td>
                                    <portlet:actionURL name="updateStatus" var="updateStatusURL"> 
                                        <portlet:param name="userId" value="<%= String.valueOf(user2.getUserId()) %>" /> 
                                    </portlet:actionURL> 
                                    <td>
                                        <aui:form action="<%= updateStatusURL %>" method="post" name="updateStatusForm" cssClass="nikkha-mb-0">
                                            <select class="nikkha-form-select nikkha-form-select-sm" name="<portlet:namespace />updatedStatusValues" onchange="this.form.submit()">
                                                <option value="0" <%= status == 0 ? "selected" : "" %>>Verify</option>
                                                <option value="1" <%= status == 1 ? "selected" : "" %>>Pending</option>
                                                <option value="2" <%= status == 2 ? "selected" : "" %>>Reject</option>
                                            </select>
                                        </aui:form>
                                    </td>
                                    <td>
                                        <div class="nikkha-dropdown">
                                            <button class="nikkha-btn nikkha-btn-sm nikkha-btn-icon nikkha-btn-link nikkha-text-dark" type="button" data-bs-toggle="dropdown">
                                                <i class="mdi mdi-dots-vertical nikkha-fs-5"></i>
                                            </button>
                                            <ul class="nikkha-dropdown-menu nikkha-dropdown-menu-end">
                                                <li>
                                                    <a class="nikkha-dropdown-item" href="<%= informationRenderURL.toString() %>">
                                                        <i class="mdi mdi-eye-outline nikkha-me-2"></i>View Profile
                                                    </a>
                                                </li>
                                                <li>
                                                    <a class="nikkha-dropdown-item" href="#">
                                                        <i class="mdi mdi-pencil-outline nikkha-me-2"></i>Edit
                                                    </a>
                                                </li>
                                                <li><hr class="nikkha-dropdown-divider"></li>
                                                <portlet:actionURL name="DeleteUser" var="DeleteUserActionURL"> 
                                                    <portlet:param name="userId" value="<%= String.valueOf(user2.getUserId()) %>" /> 
                                                </portlet:actionURL> 
                                                <li>
                                                    <a class="nikkha-dropdown-item nikkha-text-danger" href="${DeleteUserActionURL}" onclick="return confirm('Are you sure you want to delete this user?');">
                                                        <i class="mdi mdi-delete-outline nikkha-me-2"></i>Delete
                                                    </a>
                                                </li>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>
                                <% } %>
                            </tbody>
                        </table>
                    </div>
                </div>
                
                <div class="nikkha-tab-pane nikkha-fade" id="nikkha-pending" role="tabpanel">
                    <div class="nikkha-alert nikkha-alert-info">
                        <i class="mdi mdi-information-outline nikkha-me-2"></i> Pending verification users will appear here
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
$(document).ready(function() {
    // Initialize DataTables
    $('#nikkha-inactiveTable').DataTable({
        responsive: true,
        dom: '<"top"f>rt<"bottom"lip><"clear">',
        language: {
            search: "_INPUT_",
            searchPlaceholder: "Search users...",
        }
    });
    
    // Tab persistence
    $('a[data-bs-toggle="tab"]').on('shown.bs.tab', function(e) {
        localStorage.setItem('nikkha-lastTab', $(e.target).attr('href'));
    });
    
    var lastTab = localStorage.getItem('nikkha-lastTab');
    if (lastTab) {
        $('[href="' + lastTab + '"]').tab('show');
    }
});
</script>

<style>
.nikkha-card {
    border-radius: 10px;
    border: none;
    box-shadow: 0 0.5rem 1.5rem rgba(0, 0, 0, 0.05);
}

.nikkha-nav-tabs {
    border-bottom: 1px solid #e9ecef;
}

.nikkha-nav-tabs .nikkha-nav-link {
    border: none;
    color: #6c757d;
    font-weight: 500;
    padding: 0.75rem 1.25rem;
}

.nikkha-nav-tabs .nikkha-nav-link.nikkha-active {
    color: #0d6efd;
    background-color: transparent;
    border-bottom: 2px solid #0d6efd;
}

.nikkha-table th {
    font-weight: 600;
    font-size: 0.85rem;
    text-transform: uppercase;
    color: #6c757d;
    border-top: none;
}

.nikkha-avatar {
    position: relative;
    display: inline-block;
}

.nikkha-avatar img {
    object-fit: cover;
}

.nikkha-select2-container .nikkha-select2-selection--single {
    height: 38px !important;
}

.nikkha-dataTables_wrapper .nikkha-dataTables_filter input {
    border-radius: 20px;
    padding: 5px 10px;
    border: 1px solid #dee2e6;
}

.nikkha-dropdown-menu {
    box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.1);
    border: none;
    border-radius: 8px;
}

.nikkha-dropdown-item {
    padding: 0.5rem 1.25rem;
    font-size: 0.875rem;
}

.nikkha-form-select {
    cursor: pointer;
}

/* Additional custom styles */
.nikkha-badge {
    padding: 0.35em 0.65em;
    font-size: 0.75em;
    font-weight: 500;
}

.nikkha-rounded-circle {
    border-radius: 50% !important;
}

.nikkha-shadow-sm {
    box-shadow: 0 .125rem .25rem rgba(0,0,0,.075) !important;
}

.nikkha-bg-white {
    background-color: #fff !important;
}

.nikkha-text-primary {
    color: #0d6efd !important;
}

.nikkha-text-muted {
    color: #6c757d !important;
}

.nikkha-bg-success {
    background-color: #198754 !important;
}

.nikkha-bg-warning {
    background-color: #ffc107 !important;
}

.nikkha-bg-danger {
    background-color: #dc3545 !important;
}

.nikkha-bg-secondary {
    background-color: #6c757d !important;
}

.nikkha-py-4 {
    padding-top: 1.5rem !important;
    padding-bottom: 1.5rem !important;
}

.nikkha-me-3 {
    margin-right: 1rem !important;
}

.nikkha-ms-2 {
    margin-left: 0.5rem !important;
}

.nikkha-mb-0 {
    margin-bottom: 0 !important;
}

.nikkha-pt-0 {
    padding-top: 0 !important;
}

.nikkha-d-flex {
    display: flex !important;
}

.nikkha-justify-content-between {
    justify-content: space-between !important;
}

.nikkha-align-items-center {
    align-items: center !important;
}

.nikkha-input-group-text {
    display: flex;
    align-items: center;
    padding: 0.375rem 0.75rem;
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    color: #212529;
    text-align: center;
    white-space: nowrap;
    background-color: #f8f9fa;
    border: 1px solid #ced4da;
    border-radius: 0.375rem;
}

.nikkha-form-control {
    display: block;
    width: 100%;
    padding: 0.375rem 0.75rem;
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    color: #212529;
    background-color: #fff;
    background-clip: padding-box;
    border: 1px solid #ced4da;
    appearance: none;
    border-radius: 0.375rem;
    transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
    height: 38px;
}

.nikkha-btn {
    display: inline-block;
    font-weight: 400;
    line-height: 1.5;
    color: #212529;
    text-align: center;
    text-decoration: none;
    vertical-align: middle;
    cursor: pointer;
    user-select: none;
    background-color: transparent;
    border: 1px solid transparent;
    padding: 0.375rem 0.75rem;
    font-size: 1rem;
    border-radius: 0.375rem;
    transition: color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out,box-shadow .15s ease-in-out;
}

.nikkha-btn-sm {
    padding: 0.25rem 0.5rem;
    font-size: 0.875rem;
    border-radius: 0.25rem;
}

.nikkha-btn-link {
    font-weight: 400;
    color: #0d6efd;
    text-decoration: underline;
}

.nikkha-btn-link:hover {
    color: #0a58ca;
}

.nikkha-text-dark {
    color: #212529 !important;
}

.nikkha-fs-5 {
    font-size: 1.25rem !important;
}

.nikkha-dropdown {
    position: relative;
}

.nikkha-dropdown-menu {
    position: absolute;
    z-index: 1000;
    display: none;
    min-width: 10rem;
    padding: 0.5rem 0;
    margin: 0;
    font-size: 1rem;
    color: #212529;
    text-align: left;
    list-style: none;
    background-color: #fff;
    background-clip: padding-box;
    border: 1px solid rgba(0,0,0,.15);
    border-radius: 0.25rem;
}

.nikkha-dropdown-menu-end {
    right: 0;
    left: auto;
}

.nikkha-dropdown-divider {
    height: 0;
    margin: 0.5rem 0;
    overflow: hidden;
    border-top: 1px solid rgba(0,0,0,.15);
}

.nikkha-text-danger {
    color: #dc3545 !important;
}

.nikkha-alert {
    position: relative;
    padding: 1rem 1rem;
    margin-bottom: 1rem;
    border: 1px solid transparent;
    border-radius: 0.25rem;
}

.nikkha-alert-info {
    color: #055160;
    background-color: #cff4fc;
    border-color: #b6effb;
}

.nikkha-fw-semibold {
    font-weight: 600 !important;
}

.nikkha-rounded-pill {
    border-radius: 50rem !important;
}

.nikkha-form-select {
    display: block;
    width: 100%;
    padding: 0.375rem 2.25rem 0.375rem 0.75rem;
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    color: #212529;
    background-color: #fff;
    background-image: url("data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 16 16'%3e%3cpath fill='none' stroke='%23343a40' stroke-linecap='round' stroke-linejoin='round' stroke-width='2' d='M2 5l6 6 6-6'/%3e%3c/svg%3e");
    background-repeat: no-repeat;
    background-position: right 0.75rem center;
    background-size: 16px 12px;
    border: 1px solid #ced4da;
    border-radius: 0.375rem;
    transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
    appearance: none;
}

.nikkha-form-select-sm {
    padding-top: 0.25rem;
    padding-bottom: 0.25rem;
    padding-left: 0.5rem;
    font-size: 0.875rem;
    border-radius: 0.25rem;
}

.nikkha-table {
    width: 100%;
    margin-bottom: 1rem;
    color: #212529;
    vertical-align: top;
    border-color: #dee2e6;
}

.nikkha-table th {
    text-align: inherit;
    text-align: -webkit-match-parent;
}

.nikkha-table thead th {
    vertical-align: bottom;
    border-bottom: 2px solid #dee2e6;
}

.nikkha-table tbody tr:nth-of-type(odd) {
    background-color: rgba(0, 0, 0, 0.02);
}

.nikkha-table-hover tbody tr:hover {
    color: #212529;
    background-color: rgba(0, 0, 0, 0.075);
}

.nikkha-table-light {
    color: #000;
    background-color: #f8f9fa;
}

.nikkha-align-middle {
    vertical-align: middle !important;
}

.nikkha-table-responsive {
    overflow-x: auto;
    -webkit-overflow-scrolling: touch;
}

.nikkha-container-fluid {
    width: 100%;
    padding-right: var(--bs-gutter-x, 0.75rem);
    padding-left: var(--bs-gutter-x, 0.75rem);
    margin-right: auto;
    margin-left: auto;
}
</style>