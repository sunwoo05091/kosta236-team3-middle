package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.service.LoginService;

public class UpdateEmpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginService service = LoginService.getInstance();
		ActionForward forward = new ActionForward();
		
		service.updateEmpService(request);
		
		forward.setPath("listSignUpApproveAction.do");
		forward.setRedirect(true);//redirect
		
		return forward;
	}

}
