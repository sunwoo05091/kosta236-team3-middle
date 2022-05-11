package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.domain.Emp;
import kosta.service.LoginService;

public class LogOutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		session.removeAttribute("emp");
		
		//페이지 이동 : 1)insertAction.jsp 2)list.jsp 3)기타(listAction.do)
		forward.setPath("loginFormAction.do?loginfail=0");
		forward.setRedirect(true);//redirect
		
		return forward;
	}

}
