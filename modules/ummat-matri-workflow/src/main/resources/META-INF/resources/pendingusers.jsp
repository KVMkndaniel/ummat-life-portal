<%@page import="javax.portlet.PortletURL"%>
<%@ include file="./init.jsp" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="https://cdn.jsdelivr.net/npm/@mdi/font@6.5.95/css/materialdesignicons.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<style>
    .nikkha-matrimony-card {
        border-radius: 10px;
        box-shadow: 0 4px 20px rgba(0, 0, 0, 0.08);
        border: none;
        overflow: hidden;
    }
    
    .nikkha-card-header-custom {
        background: linear-gradient(135deg, #e11a89, #9330d9);
        color: white;
        border-bottom: none;
        padding: 1.25rem 1.5rem;
    }
    
    .nikkha-table-responsive {
        border-radius: 8px;
        overflow: hidden;
    }
    
    .nikkha-table-hover tbody tr:hover {
        background-color: rgba(255, 107, 107, 0.05);
    }
    
    .nikkha-table thead {
        background-color: #f8f9fa;
    }
    
    .nikkha-table th {
        font-weight: 600;
        color: #495057;
        text-transform: uppercase;
        font-size: 0.75rem;
        letter-spacing: 0.5px;
    }
    
    .nikkha-profile-img {
        width: 40px;
        height: 40px;
        object-fit: cover;
        border-radius: 50%;
        border: 2px solid #fff;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }
    
    .nikkha-status-badge {
        padding: 5px 10px;
        border-radius: 20px;
        font-size: 0.75rem;
        font-weight: 500;
    }
    
    .nikkha-badge-pending {
        background-color: #fff3cd;
        color: #856404;
    }
    
    .nikkha-badge-active {
        background-color: #d4edda;
        color: #155724;
    }
    
    .nikkha-badge-inactive {
        background-color: #f8d7da;
        color: #721c24;
    }
    
    .nikkha-action-btn {
        width: 32px;
        height: 32px;
        display: inline-flex;
        align-items: center;
        justify-content: center;
        border-radius: 50%;
        transition: all 0.3s;
    }
    
    .nikkha-action-btn:hover {
        background-color: rgba(0, 0, 0, 0.05);
    }
    
    .nikkha-dropdown-menu {
        border-radius: 8px;
        box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
        border: none;
        padding: 0.5rem 0;
    }
    
    .nikkha-dropdown-item {
        padding: 0.5rem 1.5rem;
        font-size: 0.875rem;
        transition: all 0.2s;
    }
    
    .nikkha-dropdown-item i {
        width: 20px;
        text-align: center;
        margin-right: 8px;
    }
    
    .nikkha-status-select {
        border-radius: 20px;
        padding: 5px 10px;
        font-size: 0.75rem;
        border: 1px solid #dee2e6;
        cursor: pointer;
        transition: all 0.3s;
    }
    
    .nikkha-status-select:focus {
        border-color: #ff6b6b;
        box-shadow: 0 0 0 0.2rem rgba(255, 107, 107, 0.25);
    }
    
    .nikkha-umm-id {
        font-weight: 600;
        color: #ff6b6b;
    }
    
    .nikkha-empty-state {
        padding: 3rem;
        text-align: center;
        color: #6c757d;
    }
    
    .nikkha-empty-state i {
        font-size: 3rem;
        margin-bottom: 1rem;
        color: #dee2e6;
    }
    
    h2.nikkha-portlet-title-text {
        display: none !important;
    }
    
    /* Additional utility classes */
    .nikkha-container-fluid {
        width: 100%;
        padding-right: var(--bs-gutter-x, 0.75rem);
        padding-left: var(--bs-gutter-x, 0.75rem);
        margin-right: auto;
        margin-left: auto;
    }
    
    .nikkha-py-3 {
        padding-top: 1rem !important;
        padding-bottom: 1rem !important;
    }
    
    .nikkha-card {
        position: relative;
        display: flex;
        flex-direction: column;
        min-width: 0;
        word-wrap: break-word;
        background-color: #fff;
        background-clip: border-box;
        border: 1px solid rgba(0,0,0,.125);
        border-radius: 0.25rem;
    }
    
    .nikkha-card-body {
        flex: 1 1 auto;
        padding: 1rem 1rem;
    }
    
    .nikkha-p-0 {
        padding: 0 !important;
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
    
    .nikkha-mb-0 {
        margin-bottom: 0 !important;
    }
    
    .nikkha-me-2 {
        margin-right: 0.5rem !important;
    }
    
    .nikkha-ms-2 {
        margin-left: 0.5rem !important;
    }
    
    .nikkha-me-3 {
        margin-right: 1rem !important;
    }
    
    .nikkha-opacity-75 {
        opacity: 0.75 !important;
    }
    
    .nikkha-input-group {
        position: relative;
        display: flex;
        flex-wrap: wrap;
        align-items: stretch;
        width: 100%;
    }
    
    .nikkha-input-group-sm {
        height: calc(1.5em + 0.5rem + 2px);
    }
    
    .nikkha-input-group-text {
        display: flex;
        align-items: center;
        padding: 0.375rem 0.75rem;
        margin-bottom: 0;
        font-size: 1rem;
        font-weight: 400;
        line-height: 1.5;
        color: #495057;
        text-align: center;
        white-space: nowrap;
        background-color: #e9ecef;
        border: 1px solid #ced4da;
        border-radius: 0.25rem;
    }
    
    .nikkha-form-control {
        display: block;
        width: 100%;
        padding: 0.375rem 0.75rem;
        font-size: 1rem;
        font-weight: 400;
        line-height: 1.5;
        color: #495057;
        background-color: #fff;
        background-clip: padding-box;
        border: 1px solid #ced4da;
        border-radius: 0.25rem;
        transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
    }
    
    .nikkha-btn {
        display: inline-block;
        font-weight: 400;
        color: #212529;
        text-align: center;
        vertical-align: middle;
        user-select: none;
        background-color: transparent;
        border: 1px solid transparent;
        padding: 0.375rem 0.75rem;
        font-size: 1rem;
        line-height: 1.5;
        border-radius: 0.25rem;
        transition: color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out,box-shadow .15s ease-in-out;
    }
    
    .nikkha-btn-light {
        color: #212529;
        background-color: #f8f9fa;
        border-color: #f8f9fa;
    }
    
    .nikkha-btn-sm {
        padding: 0.25rem 0.5rem;
        font-size: 0.875rem;
        line-height: 1.5;
        border-radius: 0.2rem;
    }
    
    .nikkha-text-primary {
        color: #0d6efd !important;
    }
    
    .nikkha-text-warning {
        color: #ffc107 !important;
    }
    
    .nikkha-text-danger {
        color: #dc3545 !important;
    }
    
    .nikkha-text-muted {
        color: #6c757d !important;
    }
    
    .nikkha-bg-white {
        background-color: #fff !important;
    }
    
    .nikkha-border-top {
        border-top: 1px solid #dee2e6 !important;
    }
    
    .nikkha-pagination {
        display: flex;
        padding-left: 0;
        list-style: none;
        border-radius: 0.25rem;
    }
    
    .nikkha-page-item.disabled .nikkha-page-link {
        color: #6c757d;
        pointer-events: none;
        background-color: #fff;
        border-color: #dee2e6;
    }
    
    .nikkha-page-item.active .nikkha-page-link {
        z-index: 3;
        color: #fff;
        background-color: #0d6efd;
        border-color: #0d6efd;
    }
    
    .nikkha-page-link {
        position: relative;
        display: block;
        color: #0d6efd;
        text-decoration: none;
        background-color: #fff;
        border: 1px solid #dee2e6;
        transition: color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out,box-shadow .15s ease-in-out;
    }
    
    .nikkha-pagination-sm .nikkha-page-link {
        padding: 0.25rem 0.5rem;
        font-size: 0.875rem;
    }
    
    .nikkha-pagination-sm .nikkha-page-item:first-child .nikkha-page-link {
        border-top-left-radius: 0.2rem;
        border-bottom-left-radius: 0.2rem;
    }
    
    .nikkha-pagination-sm .nikkha-page-item:last-child .nikkha-page-link {
        border-top-right-radius: 0.2rem;
        border-bottom-right-radius: 0.2rem;
    }
    
    .nikkha-form-check {
        display: block;
        min-height: 1.5rem;
        padding-left: 1.5em;
        margin-bottom: 0.125rem;
    }
    
    .nikkha-form-check-input {
        width: 1em;
        height: 1em;
        margin-top: 0.25em;
        vertical-align: top;
        background-color: #fff;
        background-repeat: no-repeat;
        background-position: center;
        background-size: contain;
        border: 1px solid rgba(0,0,0,.25);
        appearance: none;
    }
    
    .nikkha-m-0 {
        margin: 0 !important;
    }
    
    .nikkha-h6 {
        font-size: 1rem;
        margin-top: 0;
        margin-bottom: 0.5rem;
        font-weight: 500;
        line-height: 1.2;
    }
    
    .nikkha-mt-1 {
        margin-top: 0.25rem !important;
    }
</style>

<%
    List<User> pendingUsers = (List<User>) request.getAttribute("pendingUsers");
    List<User> inactiveUsers = (List<User>) request.getAttribute("inactiveUsers");
    PortletURL informationRenderURL = renderResponse.createRenderURL();
    informationRenderURL.setParameter("jspPage", "/userdetails.jsp");
%>

<div class="nikkha-container-fluid nikkha-py-3">
    <div class="nikkha-card nikkha-matrimony-card">
        <div class="nikkha-card-header nikkha-card-header-custom">
            <div class="nikkha-d-flex nikkha-justify-content-between nikkha-align-items-center">
                <div>
                    <h4 class="nikkha-mb-0"><i class="fas fa-user-clock nikkha-me-2"></i> Pending User Approvals</h4>
                    <p class="nikkha-mb-0 nikkha-opacity-75">Manage matrimony profile requests awaiting your approval</p>
                </div>
                <div class="nikkha-d-flex">
                    <div class="nikkha-input-group nikkha-input-group-sm" style="width: 250px;">
                        <span class="nikkha-input-group-text nikkha-bg-white"><i class="fas fa-search"></i></span>
                        <input type="text" class="nikkha-form-control" placeholder="Search users...">
                    </div>
                  
                </div>
            </div>
        </div>
        
        <div class="nikkha-card-body nikkha-p-0">
            <% if (pendingUsers.isEmpty()) { %>
                <div class="nikkha-empty-state">
                    <i class="fas fa-user-check"></i>
                    <h5>No Pending Requests</h5>
                    <p class="nikkha-mb-0">All matrimony profiles are currently approved</p>
                </div>
            <% } else { %>
                <div class="nikkha-table-responsive">
                    <table class="nikkha-table nikkha-table-hover nikkha-align-middle nikkha-mb-0">
                        <thead class="nikkha-table-light">
                            <tr>
                                <th style="width: 50px;"></th>
                                <th>ID</th>
                                <th>Profile</th>
                                <th>Contact</th>
                                <th>Status</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (User user1 : pendingUsers) { 
                                int status = user1.getStatus(); 
                                String statusText = "Unknown"; 
                                String badgeClass = "nikkha-badge-pending"; 

                                if (status == 0) { 
                                    statusText = "Active"; 
                                    badgeClass = "nikkha-badge-active"; 
                                } else if (status == 1) { 
                                    statusText = "Pending"; 
                                    badgeClass = "nikkha-badge-pending"; 
                                } else if (status == 2) { 
                                    statusText = "Inactive"; 
                                    badgeClass = "nikkha-badge-inactive"; 
                                } 

                                informationRenderURL.setParameter("userId", String.valueOf(user1.getUserId())); 
                            %>
                            <tr>
                                <td>
                                    <div class="nikkha-form-check">
                                        <input class="nikkha-form-check-input" type="checkbox" value="">
                                    </div>
                                </td>
                                <td>
                                    <span class="nikkha-umm-id">UM<%= user1.getUserId() %></span>
                                </td>
                                <td>
                                    <div class="nikkha-d-flex nikkha-align-items-center">
                                        <img src="<%=user1.getPortraitURL(themeDisplay)%>" 
                                            class="nikkha-profile-img nikkha-me-3" 
                                            alt="<%=user1.getFullName()%>">
                                        <div>
                                            <h6 class="nikkha-mb-0"><%= user1.getFullName() %></h6>
                                            <small class="nikkha-text-muted">Registered: <%= user1.getCreateDate() %></small>
                                        </div>
                                    </div>
                                </td>
                                <td>
                                    <div>
                                        <div><i class="fas fa-envelope nikkha-me-2 nikkha-text-muted"></i> <%= user1.getEmailAddress() %></div>
                                        <div class="nikkha-mt-1"><i class="fas fa-phone nikkha-me-2 nikkha-text-muted"></i> <%= user1.getScreenName() %></div>
                                    </div>
                                </td>
                                <td>
                                    <portlet:actionURL name="updateStatus" var="updateStatusURL"> 
                                        <portlet:param name="userId" value="<%= String.valueOf(user1.getUserId()) %>" /> 
                                    </portlet:actionURL> 
                                    
                                    <div class="nikkha-d-flex nikkha-align-items-center">
                                        <span class="nikkha-status-badge <%= badgeClass %> nikkha-me-2"><%= statusText %></span>
                                        <aui:form action="<%= updateStatusURL %>" method="post" name="updateStatusForm" cssClass="nikkha-m-0">
                                            <select name="updatedStatusValues" class="nikkha-status-select nikkha-form-select-sm" 
                                                onchange="this.form.submit()" style="width: 120px;">
                                                <option value="0" <%= status == 0 ? "selected" : "" %>>Active</option> 
                                                <option value="2" <%= status == 2 ? "selected" : "" %>>Inactive</option> 
                                                <option value="1" <%= status == 1 ? "selected" : "" %>>Pending</option> 
                                            </select> 
                                        </aui:form>
                                    </div>
                                </td>
                                <td>
                                    <div class="nikkha-d-flex">
                                        <a href="<%= informationRenderURL.toString() %>" 
                                            class="nikkha-action-btn nikkha-text-primary nikkha-me-2" 
                                            title="View Profile">
                                            <i class="fas fa-eye"></i>
                                        </a>
                                        
                                        <portlet:renderURL var="editUserURL">
                                            <portlet:param name="mvcPath" value="/edit_user.jsp" />
                                            <portlet:param name="userId" value="<%= String.valueOf(user1.getUserId()) %>" />
                                        </portlet:renderURL>
                                        <a href="${editUserURL}" 
                                            class="nikkha-action-btn nikkha-text-warning nikkha-me-2" 
                                            title="Edit Profile">
                                            <i class="fas fa-pencil-alt"></i>
                                        </a>
                                        
                                        <portlet:actionURL name="DeleteUser" var="DeleteUserActionURL"> 
                                            <portlet:param name="userId" value="<%= String.valueOf(user1.getUserId()) %>" /> 
                                        </portlet:actionURL> 
                                        <a href="${DeleteUserActionURL}" 
                                            class="nikkha-action-btn nikkha-text-danger" 
                                            title="Delete Profile"
                                            onclick="return confirm('Are you sure you want to delete this profile?');">
                                            <i class="fas fa-trash-alt"></i>
                                        </a>
                                    </div>
                                </td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
                
                <div class="nikkha-card-footer nikkha-bg-white nikkha-border-top nikkha-d-flex nikkha-justify-content-between nikkha-align-items-center">
                    <div class="nikkha-text-muted">
                        Showing 1 to <%= pendingUsers.size() %> of <%= pendingUsers.size() %> entries
                    </div>
                    <nav aria-label="Page navigation">
                        <ul class="nikkha-pagination nikkha-pagination-sm nikkha-mb-0">
                            <li class="nikkha-page-item disabled">
                                <a class="nikkha-page-link" href="#" tabindex="-1">Previous</a>
                            </li>
                            <li class="nikkha-page-item active"><a class="nikkha-page-link" href="#">1</a></li>
                            <li class="nikkha-page-item"><a class="nikkha-page-link" href="#">2</a></li>
                            <li class="nikkha-page-item"><a class="nikkha-page-link" href="#">3</a></li>
                            <li class="nikkha-page-item">
                                <a class="nikkha-page-link" href="#">Next</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            <% } %>
        </div>
    </div>
</div>