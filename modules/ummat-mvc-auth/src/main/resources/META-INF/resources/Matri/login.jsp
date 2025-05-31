<div aria-labelledby="clay-modal-label-2" aria-modal="true" class="modal-content" role="dialog" tabindex="-1">
    <div class="modal-header">
        <h1 class="modal-title" id="clay-modal-label-2">Sign In<span class="sr-only">- Loading</span></h1>
        <button class="close btn btn-unstyled" type="button" aria-label="close">
            <svg class="lexicon-icon lexicon-icon-times" role="presentation">
                <use xlink:href="http://ummatnikkha.com:8080/o/classic-theme/images/clay/icons.svg#times"></use>
            </svg>
        </button>
    </div>
    <div class="modal-body">
        <div class="liferay-modal-body">
            <div class="login-container">
                <form action="http://ummatnikkha.com:8080/home?p_p_id=com_liferay_login_web_portlet_LoginPortlet&amp;p_p_lifecycle=1&amp;p_p_state=exclusive&amp;p_p_mode=view&amp;_com_liferay_login_web_portlet_LoginPortlet_javax.portlet.action=%2Flogin%2Flogin&amp;_com_liferay_login_web_portlet_LoginPortlet_mvcRenderCommandName=%2Flogin%2Flogin&amp;p_auth=uFG0l1vn" class="form sign-in-form" data-fm-namespace="_com_liferay_login_web_portlet_LoginPortlet_" id="_com_liferay_login_web_portlet_LoginPortlet_loginFormModal" method="post" name="_com_liferay_login_web_portlet_LoginPortlet_loginFormModal" autocomplete="on">
                    <div aria-label="Sign In" class="input-container" role="group">
                        <input class="field form-control" id="_com_liferay_login_web_portlet_LoginPortlet_formDate" name="_com_liferay_login_web_portlet_LoginPortlet_formDate" type="hidden" value="1713603504534">
                        <input class="field form-control" id="_com_liferay_login_web_portlet_LoginPortlet_saveLastPath" name="_com_liferay_login_web_portlet_LoginPortlet_saveLastPath" type="hidden" value="false">
                        <input class="field form-control" id="_com_liferay_login_web_portlet_LoginPortlet_redirect" name="_com_liferay_login_web_portlet_LoginPortlet_redirect" type="hidden" value="">
                        <input class="field form-control" id="_com_liferay_login_web_portlet_LoginPortlet_doActionAfterLogin" name="_com_liferay_login_web_portlet_LoginPortlet_doActionAfterLogin" type="hidden" value="false">
                        <div class="inline-alert-container lfr-alert-container"></div>
                        <div class="alert alert-danger" id="_com_liferay_login_web_portlet_LoginPortlet_cookieDisabled" style="display: none;">
                            Authentication failed. Please enable browser cookies and try again.
                        </div>
                        <fieldset class="">
                            <legend class="sr-only">Sign In</legend>
                            <div class="show" id="Content" role="presentation">
                                <div class="panel-body">
                                    <div class="form-group input-text-wrapper">
                                        <label class="control-label" for="_com_liferay_login_web_portlet_LoginPortlet_login">Email Address</label>
                                        <input class="field clearable form-control" id="_com_liferay_login_web_portlet_LoginPortlet_login" name="_com_liferay_login_web_portlet_LoginPortlet_login" type="text" value="@UmmatNikkha.com">
                                    </div>
                                    <div class="form-group input-text-wrapper">
                                        <label class="control-label" for="_com_liferay_login_web_portlet_LoginPortlet_password">Password</label>
                                        <input class="field form-control" id="_com_liferay_login_web_portlet_LoginPortlet_password" name="_com_liferay_login_web_portlet_LoginPortlet_password" type="password" value="">
                                    </div>
                                    <span id="_com_liferay_login_web_portlet_LoginPortlet_passwordCapsLockSpan" style="display: none;">Caps Lock is on.</span>
                                    <div class="form-group form-inline input-checkbox-wrapper">
                                        <label class="" for="_com_liferay_login_web_portlet_LoginPortlet_rememberMe">
                                            <input class="field" id="_com_liferay_login_web_portlet_LoginPortlet_rememberMe" name="_com_liferay_login_web_portlet_LoginPortlet_rememberMe" onclick="" type="checkbox">
                                            Remember Me
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                        <div class="button-holder">
                            <button class="btn btn-primary" id="_com_liferay_login_web_portlet_LoginPortlet_wdji" type="submit">
                                <span class="lfr-btn-label">Sign In</span>
                            </button>
                        </div>
                        <input class="field form-control" id="_com_liferay_login_web_portlet_LoginPortlet_checkboxNames" name="_com_liferay_login_web_portlet_LoginPortlet_checkboxNames" type="hidden" value="rememberMe">
                    </div>
                </form>
                <!-- Create Account link -->
                <div class="create-account-link">
                    <a href="http://ummatnikkha.com:8080/widget/web/guest/registration/-/ummat_users_auth_UmmatMatriAccountPortlet">Create Account</a>
                </div>
            </div>
        </div>
    </div>
</div>
<style>
.login-card {
    max-width: 400px;
    margin: 0 auto;
    border: 1px solid #ccc;
    border-radius: 8px;
    overflow: hidden;
}

.card-content {
    padding: 20px;
}

.login-image img {
    width: 100%;
    height: auto;
}

.login-form {
    margin-top: 20px;
}

.form-group {
    margin-bottom: 15px;
}

.form-group label {
    display: block;
    font-weight: bold;
}

.form-group input[type="email"],
.form-group input[type="password"] {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

.btn-primary {
    background-color: #007bff;
    color: #fff;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

.create-account-link {
    text-align: center;
}

.create-account-link a {
    color: #007bff;
    text-decoration: none;
}

.create-account-link a:hover {
    text-decoration: underline;
}

</style>
<script>
document.addEventListener('DOMContentLoaded', function() {
    var loginForm = document.getElementById('login-form');

    loginForm.addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent the form from submitting normally

        // Perform your login validation here
        var email = document.getElementById('email').value;
        var password = document.getElementById('password').value;

        // For demonstration purposes, check if email and password are not empty
        if (email && password) {
            // Successful login, hide the login form
            document.querySelector('.login-form').style.display = 'none';
            alert('Login successful!'); // Display an alert, you can replace this with your desired action
        } else {
            // Login failed, display an error message
            alert('Invalid email or password!');
        }
    });
});

</script>