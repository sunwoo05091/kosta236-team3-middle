package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.service.LoginService;

public class CheckInAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginService service = LoginService.getInstance();
		ActionForward forward = new ActionForward();
		
		int re = service.checkInService(request);
		if(re == 0) {
			forward.setPath("insertEmpFormAction.do?check=1");
			forward.setRedirect(true);
		}else {
			forward.setPath("mainAction.do");
			forward.setRedirect(true);
		}
		return forward;
		
	}
}
