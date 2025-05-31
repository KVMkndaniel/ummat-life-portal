package com.mvc.ummat.matri.portlet;

import com.mvc.ummat.matri.constants.UmmatMatriWorkflowPortletKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Personal
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=UmmatMatriWorkflow", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + UmmatMatriWorkflowPortletKeys.UMMATMATRIWORKFLOW,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class UmmatMatriWorkflowPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
	        throws PortletException, IOException {

	    ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

	    try {
	        List<User> pendingUsers = new ArrayList<>();
	        List<User> inactiveUsers = new ArrayList<>();

	        int start = QueryUtil.ALL_POS;
	        int end = QueryUtil.ALL_POS;

	        // Get all users from Liferay
	        List<User> allUsers = UserLocalServiceUtil.getUsers(-1, -1);

	        for (User user : allUsers) {
	            int status = user.getStatus();

	            // Filter only users from the current company
	            if (user.getCompanyId() == themeDisplay.getCompanyId()) {
	                if (status == 1) {
	                    pendingUsers.add(user);
	                } else if ( status == 0 || status == 2 || status == 1) {
	                    inactiveUsers.add(user);
	                }
	            }
	        }

	        // Debug output to console (can be removed in production)
	        System.out.println("Found " + pendingUsers.size() + " pending users");
	        System.out.println("Found " + inactiveUsers.size() + " inactive users");

	        // Pass both lists to JSP
	        renderRequest.setAttribute("pendingUsers", pendingUsers);
	        renderRequest.setAttribute("inactiveUsers", inactiveUsers);

	    } catch (Exception e) {
	        e.printStackTrace();
	        renderRequest.setAttribute("error", "Unable to fetch users by status.");
	    }
	    
	    // Dispatch to inactive.jsp instead of default view.jsp
	    PortletRequestDispatcher dispatcher = 
	        getPortletContext().getRequestDispatcher("/pendingusers.jsp");
	    dispatcher.include(renderRequest, renderResponse);

	    super.doView(renderRequest, renderResponse);
	}

	/* ======================= User Status Updated ========================= */
	public void updateStatus(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		long userId = ParamUtil.getLong(actionRequest, "userId");
		int updatedStatusValues = ParamUtil.getInteger(actionRequest, "updatedStatusValues");

		System.out.println("Updated Status Method inside ::::: ");
		System.out.println("User ID: " + userId + ", New Status: " + updatedStatusValues);

		if (userId == 0) {
			System.out.println("Error: Invalid User ID (userId is 0)");
			return;
		}

		User user = UserLocalServiceUtil.fetchUser(userId);
		if (user != null) {

			if (user.getStatus() != updatedStatusValues) {
				user.setStatus(updatedStatusValues);
				UserLocalServiceUtil.updateUser(user);
				System.out.println("User status updated successfully. New Status: " + updatedStatusValues);
			} else {
				System.out.println("Status is the same, no update needed. Current Status: " + updatedStatusValues);
			}
		} else {
			System.out.println("User not found for userId: " + userId);
		}

		actionResponse.setRenderParameter("mvcRenderCommandName", "/view");
	}
}