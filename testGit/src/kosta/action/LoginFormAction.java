package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFormAction implements Action{

	public LoginFormAction() {}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		int loginfail = Integer.parseInt(request.getParameter("loginfail"));
		request.setAttribute("loginfail", loginfail);
		
		forward.setRedirect(false);
		forward.setPath("/login_form.jsp");
		
		return forward;
	}
}
