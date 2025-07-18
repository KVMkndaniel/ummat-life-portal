<%--
/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
--%>

<c:choose>
    <c:when test="<%= themeDisplay.isSignedIn() %>">
        <%
        String signedInAs = HtmlUtil.escape(user.getFullName());

        if (themeDisplay.isShowMyAccountIcon() && (themeDisplay.getURLMyAccount() != null)) {
            String myAccountURL = String.valueOf(themeDisplay.getURLMyAccount());

            signedInAs = "<a class=\"signed-in\" href=\"" + HtmlUtil.escape(myAccountURL) + "\">" + signedInAs + "</a>";
        }
        %>

        <liferay-ui:message arguments="<%= signedInAs %>" key="you-are-signed-in-as-x" translateArguments="<%= false %>" />
    </c:when>
    <c:otherwise>
        <%
        String formName = "loginForm";

        if (windowState.equals(LiferayWindowState.EXCLUSIVE)) {
            formName += "Modal";
        }

        String redirect = ParamUtil.getString(request, "redirect");

        String login = (String)SessionErrors.get(renderRequest, "login");

        if (Validator.isNull(login)) {
            login = LoginUtil.getLogin(request, "login", company);
        }

        String password = StringPool.BLANK;
        boolean rememberMe = ParamUtil.getBoolean(request, "rememberMe");

        if (Validator.isNull(authType)) {
            authType = company.getAuthType();
        }
        
        String loginLabel = "Email";

        if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
            loginLabel = "Screen Name";
        }
        else if (authType.equals(CompanyConstants.AUTH_TYPE_ID)) {
            loginLabel = "ID";
        }
        %>

        <!--Inner Content Start-->
        <div class="inner-content loginbg">
            <div class="container"> 
                <!--Wedding Register Start-->
                <div class="quick-wrap loginWrp">
                    <h3>User Login</h3>
                    
                    <div class="socialLogin"> 
                        <a href="#" class="fb"><i class="fab fa-facebook" aria-hidden="true"></i> Login with Facebook</a> 
                        <a href="#" class="tw"><i class="fab fa-google" aria-hidden="true"></i> Login with Twitter</a> 
                    </div>
                    
                    <portlet:actionURL name="/login/login" secure="<%= PropsValues.COMPANY_SECURITY_AUTH_REQUIRES_HTTPS || request.isSecure() %>" var="loginURL">
                        <portlet:param name="mvcRenderCommandName" value="/login/login" />
                    </portlet:actionURL>

                    <aui:form action="<%= loginURL %>" autocomplete='<%= PropsValues.COMPANY_SECURITY_LOGIN_FORM_AUTOCOMPLETE ? "on" : "off" %>' cssClass="sign-in-form" method="post" name="<%= formName %>" onSubmit="event.preventDefault();" validateOnBlur="<%= false %>">
                        <aui:input name="saveLastPath" type="hidden" value="<%= false %>" />
                        <aui:input name="redirect" type="hidden" value="<%= redirect %>" />
                        <aui:input name="doActionAfterLogin" type="hidden" value="<%= portletName.equals(PortletKeys.FAST_LOGIN) ? true : false %>" />

                        <div class="inline-alert-container lfr-alert-container">
                            <liferay-util:dynamic-include key="com.liferay.login.web#/login.jsp#alertPre" />

                            <c:choose>
                                <c:when test='<%= SessionMessages.contains(request, "forgotPasswordSent") %>'>
                                    <div class="alert alert-success">
                                        <liferay-ui:message key="your-request-completed-successfully" />
                                    </div>
                                </c:when>
                                <c:when test='<%= SessionMessages.contains(request, "userAdded") %>'>
                                    <%
                                    String userEmailAddress = (String)SessionMessages.get(request, "userAdded");
                                    %>
                                    <div class="alert alert-success">
                                        <liferay-ui:message key="thank-you-for-creating-an-account" />
                                        <c:if test="<%= company.isStrangersVerify() %>">
                                            <liferay-ui:message arguments="<%= HtmlUtil.escape(userEmailAddress) %>" key="your-email-verification-code-was-sent-to-x" translateArguments="<%= false %>" />
                                        </c:if>
                                        <c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_USER_ADDED_ENABLED) %>">
                                            <c:choose>
                                                <c:when test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.LOGIN_CREATE_ACCOUNT_ALLOW_CUSTOM_PASSWORD, PropsValues.LOGIN_CREATE_ACCOUNT_ALLOW_CUSTOM_PASSWORD) %>">
                                                    <liferay-ui:message key="use-your-password-to-login" />
                                                </c:when>
                                                <c:otherwise>
                                                    <liferay-ui:message arguments="<%= HtmlUtil.escape(userEmailAddress) %>" key="you-can-set-your-password-following-instructions-sent-to-x" translateArguments="<%= false %>" />
                                                </c:otherwise>
                                            </c:choose>
                                        </c:if>
                                    </div>
                                </c:when>
                                <c:when test='<%= SessionMessages.contains(request, "userPending") %>'>
                                    <%
                                    String userEmailAddress = (String)SessionMessages.get(request, "userPending");
                                    %>
                                    <div class="alert alert-success">
                                        <liferay-ui:message arguments="<%= HtmlUtil.escape(userEmailAddress) %>" key="thank-you-for-creating-an-account.-you-will-be-notified-via-email-at-x-when-your-account-has-been-approved" translateArguments="<%= false %>" />
                                    </div>
                                </c:when>
                            </c:choose>

                            <c:if test="<%= PropsValues.SESSION_ENABLE_PERSISTENT_COOKIES && PropsValues.SESSION_TEST_COOKIE_SUPPORT %>">
                                <div class="alert alert-danger" id="<portlet:namespace />cookieDisabled" style="display: none;">
                                    <liferay-ui:message key="authentication-failed-please-enable-browser-cookies" />
                                </div>
                            </c:if>

                            <liferay-ui:error exception="<%= AuthException.class %>" message="authentication-failed" />
                            <liferay-ui:error exception="<%= CompanyMaxUsersException.class %>" message="unable-to-log-in-because-the-maximum-number-of-users-has-been-reached" />
                            <liferay-ui:error exception="<%= CookieNotSupportedException.class %>" message="authentication-failed-please-enable-browser-cookies" />
                            <liferay-ui:error exception="<%= NoSuchUserException.class %>" message="authentication-failed" />
                            <liferay-ui:error exception="<%= PasswordExpiredException.class %>" message="your-password-has-expired" />
                            <liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeNull.class %>" message="please-enter-an-email-address" />
                            <liferay-ui:error exception="<%= UserLockoutException.LDAPLockout.class %>" message="this-account-is-locked" />
                            <liferay-ui:error exception="<%= UserLockoutException.PasswordPolicyLockout.class %>">
                                <%
                                UserLockoutException.PasswordPolicyLockout ule = (UserLockoutException.PasswordPolicyLockout)errorException;
                                %>
                                <c:choose>
                                    <c:when test="<%= ule.passwordPolicy.isRequireUnlock() %>">
                                        <liferay-ui:message key="this-account-is-locked" />
                                    </c:when>
                                    <c:otherwise>
                                        <%
                                        Format dateFormat = FastDateFormatFactoryUtil.getDateTime(FastDateFormatConstants.SHORT, FastDateFormatConstants.LONG, locale, TimeZone.getTimeZone(ule.user.getTimeZoneId()));
                                        %>
                                        <liferay-ui:message arguments="<%= dateFormat.format(ule.user.getUnlockDate()) %>" key="this-account-is-locked-until-x" translateArguments="<%= false %>" />
                                    </c:otherwise>
                                </c:choose>
                            </liferay-ui:error>
                            <liferay-ui:error exception="<%= UserPasswordException.class %>" message="authentication-failed" />
                            <liferay-ui:error exception="<%= UserScreenNameException.MustNotBeNull.class %>" message="the-screen-name-cannot-be-blank" />

                            <liferay-util:dynamic-include key="com.liferay.login.web#/login.jsp#alertPost" />
                        </div>

                        <div class="input-group">
                            <label class="input-group-append"><%= loginLabel %></label>
                            <aui:input cssClass="form-control" label="" name="login" placeholder="<%= loginLabel %>" required="<%= true %>" showRequiredLabel="<%= false %>" type="text" value="<%= login %>">
                                <c:if test="<%= authType.equals(CompanyConstants.AUTH_TYPE_EA) %>">
                                    <aui:validator name="email" />
                                </c:if>
                            </aui:input>
                        </div>

                        <div class="input-group">
                            <label class="input-group-append">
                                Password 
                                <span>
                                    <a href="#">Forgot password?</a>
                                </span>
                            </label>
                            <aui:input cssClass="form-control" label="" name="password" placeholder="Password" required="<%= true %>" showRequiredLabel="<%= false %>" type="password" value="<%= password %>" />
                        </div>

                        <span id="<portlet:namespace />passwordCapsLockSpan" style="display: none;"><liferay-ui:message key="caps-lock-is-on" /></span>

                        <c:if test="<%= company.isAutoLogin() %>">
                            <div class="input-group checkbox">
                                <input type="checkbox" name="<portlet:namespace />rememberMe" id="<portlet:namespace />rememberMe" <%= rememberMe ? "checked" : "" %> />
                                <label for="<portlet:namespace />rememberMe"></label>
                                Remember Me
                            </div>
                        </c:if>

                        <div class="input-group">
                            <button class="btn btn-primary" type="submit">Login</button>
                        </div>
                         <div class="loginformtext"><a href="signup.html" style="color:#CB0380; font-size:16px;">Join Now – Free !</a></div>
                    </aui:form>

                    <%@ include file="/navigation.jspf" %>
                </div>
                <!--Wedding Register End--> 
            </div>
        </div>
        <!--Inner Content End-->

        <aui:script sandbox="<%= true %>">
            var form = document.getElementById('<portlet:namespace /><%= formName %>');

            if (form) {
                form.addEventListener('submit', (event) => {
                    <c:if test="<%= PropsValues.SESSION_ENABLE_PERSISTENT_COOKIES && PropsValues.SESSION_TEST_COOKIE_SUPPORT %>">
                        if (!navigator.cookieEnabled) {
                            document.getElementById(
                                '<portlet:namespace />cookieDisabled'
                            ).style.display = '';

                            return;
                        }
                    </c:if>

                    <c:if test="<%= Validator.isNotNull(redirect) %>">
                        var redirect = form.querySelector('#<portlet:namespace />redirect');

                        if (redirect) {
                            var redirectVal = redirect.getAttribute('value');

                            redirect.setAttribute('value', redirectVal + window.location.hash);
                        }
                    </c:if>

                    submitForm(form);
                });

                var password = form.querySelector('#<portlet:namespace />password');

                if (password) {
                    password.addEventListener('keypress', (event) => {
                        Liferay.Util.showCapsLock(
                            event,
                            '<portlet:namespace />passwordCapsLockSpan'
                        );
                    });
                }
            }
        </aui:script>
    </c:otherwise>
</c:choose>

<style>
span#qfkd____ {
    display: none !important;
}
h2.portlet-title-text {
    display: none !important;
}
.loginWrp .form-control
 {
    padding: 13px 125px !important;
    height: auto;
}
button.btn.btn-primary {
    width: 100%;
    height: 49px;
}
</style>
<%-- <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/init.jsp" %>
<% if(themeDisplay.getCompanyId()== 50300){%>
<c:choose>
    <c:when test="<%= themeDisplay.isSignedIn() %>">
        <%
        String signedInAs = HtmlUtil.escape(user.getFullName());

        if (themeDisplay.isShowMyAccountIcon() && (themeDisplay.getURLMyAccount() != null)) {
            String myAccountURL = String.valueOf(themeDisplay.getURLMyAccount());

            signedInAs = "<a class=\"signed-in\" href=\"" + HtmlUtil.escape(myAccountURL) + "\">" + signedInAs + "</a>";
        }
        %>

        <liferay-ui:message arguments="<%= signedInAs %>" key="you-are-signed-in-as-x" translateArguments="<%= false %>" />
    </c:when>
    <c:otherwise>
        <%
        String formName = "loginForm";

        if (windowState.equals(LiferayWindowState.EXCLUSIVE)) {
            formName += "Modal";
        }

        String redirect = ParamUtil.getString(request, "redirect");

        String login = (String)SessionErrors.get(renderRequest, "login");

        if (Validator.isNull(login)) {
            login = LoginUtil.getLogin(request, "login", company);
        }

        String password = StringPool.BLANK;
        boolean rememberMe = ParamUtil.getBoolean(request, "rememberMe");

        if (Validator.isNull(authType)) {
            authType = company.getAuthType();
        }
        
        String loginLabel = "Email";

        if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
            loginLabel = "Screen Name";
        }
        else if (authType.equals(CompanyConstants.AUTH_TYPE_ID)) {
            loginLabel = "ID";
        }
        %>

        <!--Inner Content Start-->
        <div class="inner-content loginbg">
            <div class="container"> 
                <!--Wedding Register Start-->
                <div class="quick-wrap loginWrp">
                    <h3>User Login</h3>
                    
                    <div class="socialLogin"> 
                        <a href="#" class="fb"><i class="fab fa-facebook" aria-hidden="true"></i> Login with Facebook</a> 
                        <a href="#" class="tw"><i class="fab fa-google" aria-hidden="true"></i> Login with Twitter</a> 
                    </div>
                    
                    <portlet:actionURL name="/login/login" secure="<%= PropsValues.COMPANY_SECURITY_AUTH_REQUIRES_HTTPS || request.isSecure() %>" var="loginURL">
                        <portlet:param name="mvcRenderCommandName" value="/login/login" />
                    </portlet:actionURL>

                    <aui:form action="<%= loginURL %>" autocomplete='<%= PropsValues.COMPANY_SECURITY_LOGIN_FORM_AUTOCOMPLETE ? "on" : "off" %>' cssClass="sign-in-form" method="post" name="<%= formName %>" onSubmit="event.preventDefault();" validateOnBlur="<%= false %>">
                        <aui:input name="saveLastPath" type="hidden" value="<%= false %>" />
                        <aui:input name="redirect" type="hidden" value="<%= redirect %>" />
                        <aui:input name="doActionAfterLogin" type="hidden" value="<%= portletName.equals(PortletKeys.FAST_LOGIN) ? true : false %>" />

                        <div class="inline-alert-container lfr-alert-container">
                            <liferay-util:dynamic-include key="com.liferay.login.web#/login.jsp#alertPre" />

                            <c:choose>
                                <c:when test='<%= SessionMessages.contains(request, "forgotPasswordSent") %>'>
                                    <div class="alert alert-success">
                                        <liferay-ui:message key="your-request-completed-successfully" />
                                    </div>
                                </c:when>
                                <c:when test='<%= SessionMessages.contains(request, "userAdded") %>'>
                                    <%
                                    String userEmailAddress = (String)SessionMessages.get(request, "userAdded");
                                    %>
                                    <div class="alert alert-success">
                                        <liferay-ui:message key="thank-you-for-creating-an-account" />
                                        <c:if test="<%= company.isStrangersVerify() %>">
                                            <liferay-ui:message arguments="<%= HtmlUtil.escape(userEmailAddress) %>" key="your-email-verification-code-was-sent-to-x" translateArguments="<%= false %>" />
                                        </c:if>
                                        <c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_USER_ADDED_ENABLED) %>">
                                            <c:choose>
                                                <c:when test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.LOGIN_CREATE_ACCOUNT_ALLOW_CUSTOM_PASSWORD, PropsValues.LOGIN_CREATE_ACCOUNT_ALLOW_CUSTOM_PASSWORD) %>">
                                                    <liferay-ui:message key="use-your-password-to-login" />
                                                </c:when>
                                                <c:otherwise>
                                                    <liferay-ui:message arguments="<%= HtmlUtil.escape(userEmailAddress) %>" key="you-can-set-your-password-following-instructions-sent-to-x" translateArguments="<%= false %>" />
                                                </c:otherwise>
                                            </c:choose>
                                        </c:if>
                                    </div>
                                </c:when>
                                <c:when test='<%= SessionMessages.contains(request, "userPending") %>'>
                                    <%
                                    String userEmailAddress = (String)SessionMessages.get(request, "userPending");
                                    %>
                                    <div class="alert alert-success">
                                        <liferay-ui:message arguments="<%= HtmlUtil.escape(userEmailAddress) %>" key="thank-you-for-creating-an-account.-you-will-be-notified-via-email-at-x-when-your-account-has-been-approved" translateArguments="<%= false %>" />
                                    </div>
                                </c:when>
                            </c:choose>

                            <c:if test="<%= PropsValues.SESSION_ENABLE_PERSISTENT_COOKIES && PropsValues.SESSION_TEST_COOKIE_SUPPORT %>">
                                <div class="alert alert-danger" id="<portlet:namespace />cookieDisabled" style="display: none;">
                                    <liferay-ui:message key="authentication-failed-please-enable-browser-cookies" />
                                </div>
                            </c:if>

                            <liferay-ui:error exception="<%= AuthException.class %>" message="authentication-failed" />
                            <liferay-ui:error exception="<%= CompanyMaxUsersException.class %>" message="unable-to-log-in-because-the-maximum-number-of-users-has-been-reached" />
                            <liferay-ui:error exception="<%= CookieNotSupportedException.class %>" message="authentication-failed-please-enable-browser-cookies" />
                            <liferay-ui:error exception="<%= NoSuchUserException.class %>" message="authentication-failed" />
                            <liferay-ui:error exception="<%= PasswordExpiredException.class %>" message="your-password-has-expired" />
                            <liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeNull.class %>" message="please-enter-an-email-address" />
                            <liferay-ui:error exception="<%= UserLockoutException.LDAPLockout.class %>" message="this-account-is-locked" />
                            <liferay-ui:error exception="<%= UserLockoutException.PasswordPolicyLockout.class %>">
                                <%
                                UserLockoutException.PasswordPolicyLockout ule = (UserLockoutException.PasswordPolicyLockout)errorException;
                                %>
                                <c:choose>
                                    <c:when test="<%= ule.passwordPolicy.isRequireUnlock() %>">
                                        <liferay-ui:message key="this-account-is-locked" />
                                    </c:when>
                                    <c:otherwise>
                                        <%
                                        Format dateFormat = FastDateFormatFactoryUtil.getDateTime(FastDateFormatConstants.SHORT, FastDateFormatConstants.LONG, locale, TimeZone.getTimeZone(ule.user.getTimeZoneId()));
                                        %>
                                        <liferay-ui:message arguments="<%= dateFormat.format(ule.user.getUnlockDate()) %>" key="this-account-is-locked-until-x" translateArguments="<%= false %>" />
                                    </c:otherwise>
                                </c:choose>
                            </liferay-ui:error>
                            <liferay-ui:error exception="<%= UserPasswordException.class %>" message="authentication-failed" />
                            <liferay-ui:error exception="<%= UserScreenNameException.MustNotBeNull.class %>" message="the-screen-name-cannot-be-blank" />

                            <liferay-util:dynamic-include key="com.liferay.login.web#/login.jsp#alertPost" />
                        </div>

                        <div class="input-group">
                            <label class="input-group-append"><%= loginLabel %></label>
                            <aui:input cssClass="form-control" label="" name="login" placeholder="<%= loginLabel %>" required="<%= true %>" showRequiredLabel="<%= false %>" type="text" value="<%= login %>">
                                <c:if test="<%= authType.equals(CompanyConstants.AUTH_TYPE_EA) %>">
                                    <aui:validator name="email" />
                                </c:if>
                            </aui:input>
                        </div>

                        <div class="input-group">
                            <label class="input-group-append">
                                Password 
                                <span>
                                    <a href="#">Forgot password?</a>
                                </span>
                            </label>
                            <aui:input cssClass="form-control" label="" name="password" placeholder="Password" required="<%= true %>" showRequiredLabel="<%= false %>" type="password" value="<%= password %>" />
                        </div>

                        <span id="<portlet:namespace />passwordCapsLockSpan" style="display: none;"><liferay-ui:message key="caps-lock-is-on" /></span>

                        <c:if test="<%= company.isAutoLogin() %>">
                            <div class="input-group checkbox">
                                <input type="checkbox" name="<portlet:namespace />rememberMe" id="<portlet:namespace />rememberMe" <%= rememberMe ? "checked" : "" %> />
                                <label for="<portlet:namespace />rememberMe"></label>
                                Remember Me
                            </div>
                        </c:if>

                        <div class="input-group">
                            <button class="btn btn-primary" type="submit">Login</button>
                        </div>
                         <div class="loginformtext"><a href="signup.html" style="color:#CB0380; font-size:16px;">Join Now – Free !</a></div>
                    </aui:form>

                    <%@ include file="/navigation.jspf" %>
                </div>
                <!--Wedding Register End--> 
            </div>
        </div>
        <!--Inner Content End-->

        <aui:script sandbox="<%= true %>">
            var form = document.getElementById('<portlet:namespace /><%= formName %>');

            if (form) {
                form.addEventListener('submit', (event) => {
                    <c:if test="<%= PropsValues.SESSION_ENABLE_PERSISTENT_COOKIES && PropsValues.SESSION_TEST_COOKIE_SUPPORT %>">
                        if (!navigator.cookieEnabled) {
                            document.getElementById(
                                '<portlet:namespace />cookieDisabled'
                            ).style.display = '';

                            return;
                        }
                    </c:if>

                    <c:if test="<%= Validator.isNotNull(redirect) %>">
                        var redirect = form.querySelector('#<portlet:namespace />redirect');

                        if (redirect) {
                            var redirectVal = redirect.getAttribute('value');

                            redirect.setAttribute('value', redirectVal + window.location.hash);
                        }
                    </c:if>

                    submitForm(form);
                });

                var password = form.querySelector('#<portlet:namespace />password');

                if (password) {
                    password.addEventListener('keypress', (event) => {
                        Liferay.Util.showCapsLock(
                            event,
                            '<portlet:namespace />passwordCapsLockSpan'
                        );
                    });
                }
            }
        </aui:script>
    </c:otherwise>
</c:choose>

<style>
span#qfkd____ {
    display: none !important;
}
h2.portlet-title-text {
    display: none !important;
}
.loginWrp .form-control
 {
    padding: 13px 125px !important;
    height: auto;
}
button.btn.btn-primary {
    width: 100%;
    height: 49px;
}
</style>

<%} else {%>

<c:choose>
	<c:when test="<%= themeDisplay.isSignedIn() %>">

		<%
		String signedInAs = HtmlUtil.escape(user.getFullName());

		if (themeDisplay.isShowMyAccountIcon() && (themeDisplay.getURLMyAccount() != null)) {
			String myAccountURL = String.valueOf(themeDisplay.getURLMyAccount());

			signedInAs = "<a class=\"signed-in\" href=\"" + HtmlUtil.escape(myAccountURL) + "\">" + signedInAs + "</a>";
		}
		%>

		<liferay-ui:message arguments="<%= signedInAs %>" key="you-are-signed-in-as-x" translateArguments="<%= false %>" />
	</c:when>
	<c:otherwise>

		<%
		String formName = "loginForm";

		if (windowState.equals(LiferayWindowState.EXCLUSIVE)) {
			formName += "Modal";
		}

		String redirect = ParamUtil.getString(request, "redirect");

		String login = (String)SessionErrors.get(renderRequest, "login");

		if (Validator.isNull(login)) {
			login = LoginUtil.getLogin(request, "login", company);
		}

		String password = StringPool.BLANK;
		boolean rememberMe = ParamUtil.getBoolean(request, "rememberMe");

		if (Validator.isNull(authType)) {
			authType = company.getAuthType();
		}
		%>

		<div class="login-container">
			<portlet:actionURL name="/login/login" secure="<%= PropsValues.COMPANY_SECURITY_AUTH_REQUIRES_HTTPS || request.isSecure() %>" var="loginURL">
				<portlet:param name="mvcRenderCommandName" value="/login/login" />
			</portlet:actionURL>

			<aui:form action="<%= loginURL %>" autocomplete='<%= PropsValues.COMPANY_SECURITY_LOGIN_FORM_AUTOCOMPLETE ? "on" : "off" %>' cssClass="sign-in-form" method="post" name="<%= formName %>" onSubmit="event.preventDefault();" validateOnBlur="<%= false %>">
				<aui:input name="saveLastPath" type="hidden" value="<%= false %>" />
				<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
				<aui:input name="doActionAfterLogin" type="hidden" value="<%= portletName.equals(PortletKeys.FAST_LOGIN) ? true : false %>" />

				<div class="inline-alert-container lfr-alert-container"></div>

				<liferay-util:dynamic-include key="com.liferay.login.web#/login.jsp#alertPre" />

				<c:choose>
					<c:when test='<%= SessionMessages.contains(request, "forgotPasswordSent") %>'>
						<div class="alert alert-success">
							<liferay-ui:message key="your-request-completed-successfully" />
						</div>
					</c:when>
					<c:when test='<%= SessionMessages.contains(request, "userAdded") %>'>

						<%
						String userEmailAddress = (String)SessionMessages.get(request, "userAdded");
						%>

						<div class="alert alert-success">
							<liferay-ui:message key="thank-you-for-creating-an-account" />

							<c:if test="<%= company.isStrangersVerify() %>">
								<liferay-ui:message arguments="<%= HtmlUtil.escape(userEmailAddress) %>" key="your-email-verification-code-was-sent-to-x" translateArguments="<%= false %>" />
							</c:if>

							<c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_USER_ADDED_ENABLED) %>">
								<c:choose>
									<c:when test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.LOGIN_CREATE_ACCOUNT_ALLOW_CUSTOM_PASSWORD, PropsValues.LOGIN_CREATE_ACCOUNT_ALLOW_CUSTOM_PASSWORD) %>">
										<liferay-ui:message key="use-your-password-to-login" />
									</c:when>
									<c:otherwise>
										<liferay-ui:message arguments="<%= HtmlUtil.escape(userEmailAddress) %>" key="you-can-set-your-password-following-instructions-sent-to-x" translateArguments="<%= false %>" />
									</c:otherwise>
								</c:choose>
							</c:if>
						</div>
					</c:when>
					<c:when test='<%= SessionMessages.contains(request, "userPending") %>'>

						<%
						String userEmailAddress = (String)SessionMessages.get(request, "userPending");
						%>

						<div class="alert alert-success">
							<liferay-ui:message arguments="<%= HtmlUtil.escape(userEmailAddress) %>" key="thank-you-for-creating-an-account.-you-will-be-notified-via-email-at-x-when-your-account-has-been-approved" translateArguments="<%= false %>" />
						</div>
					</c:when>
				</c:choose>

				<c:if test="<%= PropsValues.SESSION_ENABLE_PERSISTENT_COOKIES && PropsValues.SESSION_TEST_COOKIE_SUPPORT %>">
					<div class="alert alert-danger" id="<portlet:namespace />cookieDisabled" style="display: none;">
						<liferay-ui:message key="authentication-failed-please-enable-browser-cookies" />
					</div>
				</c:if>

				<liferay-ui:error exception="<%= AuthException.class %>" message="authentication-failed" />
				<liferay-ui:error exception="<%= CompanyMaxUsersException.class %>" message="unable-to-log-in-because-the-maximum-number-of-users-has-been-reached" />
				<liferay-ui:error exception="<%= CookieNotSupportedException.class %>" message="authentication-failed-please-enable-browser-cookies" />
				<liferay-ui:error exception="<%= NoSuchUserException.class %>" message="authentication-failed" />
				<liferay-ui:error exception="<%= PasswordExpiredException.class %>" message="your-password-has-expired" />
				<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeNull.class %>" message="please-enter-an-email-address" />
				<liferay-ui:error exception="<%= UserLockoutException.LDAPLockout.class %>" message="this-account-is-locked" />

				<liferay-ui:error exception="<%= UserLockoutException.PasswordPolicyLockout.class %>">

					<%
					UserLockoutException.PasswordPolicyLockout ule = (UserLockoutException.PasswordPolicyLockout)errorException;
					%>

					<c:choose>
						<c:when test="<%= ule.passwordPolicy.isRequireUnlock() %>">
							<liferay-ui:message key="this-account-is-locked" />
						</c:when>
						<c:otherwise>

							<%
							Format dateFormat = FastDateFormatFactoryUtil.getDateTime(FastDateFormatConstants.SHORT, FastDateFormatConstants.LONG, locale, TimeZone.getTimeZone(ule.user.getTimeZoneId()));
							%>

							<liferay-ui:message arguments="<%= dateFormat.format(ule.user.getUnlockDate()) %>" key="this-account-is-locked-until-x" translateArguments="<%= false %>" />
						</c:otherwise>
					</c:choose>
				</liferay-ui:error>

				<liferay-ui:error exception="<%= UserPasswordException.class %>" message="authentication-failed" />
				<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeNull.class %>" message="the-screen-name-cannot-be-blank" />

				<liferay-util:dynamic-include key="com.liferay.login.web#/login.jsp#alertPost" />

				<aui:fieldset>

					<%
					String loginLabel = null;

					if (authType.equals(CompanyConstants.AUTH_TYPE_EA)) {
						loginLabel = "email-address";
					}
					else if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
						loginLabel = "screen-name";
					}
					else if (authType.equals(CompanyConstants.AUTH_TYPE_ID)) {
						loginLabel = "id";
					}
					%>

					<aui:input cssClass="clearable" label="<%= loginLabel %>" name="login" required="<%= true %>" showRequiredLabel="<%= false %>" type="text" value="<%= login %>">
						<c:if test="<%= authType.equals(CompanyConstants.AUTH_TYPE_EA) %>">
							<aui:validator name="email" />
						</c:if>
					</aui:input>

					<aui:input name="password" required="<%= true %>" showRequiredLabel="<%= false %>" type="password" value="<%= password %>" />

					<span id="<portlet:namespace />passwordCapsLockSpan" style="display: none;"><liferay-ui:message key="caps-lock-is-on" /></span>

					<c:if test="<%= company.isAutoLogin() %>">
						<aui:input checked="<%= rememberMe %>" name="rememberMe" type="checkbox" />
					</c:if>
				</aui:fieldset>

				<aui:button-row>
					<aui:button type="submit" value="sign-in" />
				</aui:button-row>
			</aui:form>

			<%@ include file="/navigation.jspf" %>
		</div>

		<aui:script sandbox="<%= true %>">
			var form = document.getElementById('<portlet:namespace /><%= formName %>');

			if (form) {
				form.addEventListener('submit', (event) => {
					<c:if test="<%= PropsValues.SESSION_ENABLE_PERSISTENT_COOKIES && PropsValues.SESSION_TEST_COOKIE_SUPPORT %>">
						if (!navigator.cookieEnabled) {
							document.getElementById(
								'<portlet:namespace />cookieDisabled'
							).style.display = '';

							return;
						}
					</c:if>

					<c:if test="<%= Validator.isNotNull(redirect) %>">
						var redirect = form.querySelector('#<portlet:namespace />redirect');

						if (redirect) {
							var redirectVal = redirect.getAttribute('value');

							redirect.setAttribute('value', redirectVal + window.location.hash);
						}
					</c:if>

					submitForm(form);
				});

				var password = form.querySelector('#<portlet:namespace />password');

				if (password) {
					password.addEventListener('keypress', (event) => {
						Liferay.Util.showCapsLock(
							event,
							'<portlet:namespace />passwordCapsLockSpan'
						);
					});
				}
			}
		</aui:script>
	</c:otherwise>
</c:choose>
<%}%> --%>