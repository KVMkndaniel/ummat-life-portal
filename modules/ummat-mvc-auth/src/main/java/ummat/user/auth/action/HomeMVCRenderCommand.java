
package ummat.user.auth.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=ummat_users_auth_UmmatMatriAccountPortlet",
		"mvc.command.name=/login" }, service = MVCRenderCommand.class)
public class HomeMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		return "/c/portal/login";
	}
}
