package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.domain.Emp;
import kosta.service.LoginService;

public class LoginAction implements Action{
	
	public LoginAction() {}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginService service = LoginService.getInstance();
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		//비즈니스 호출
		Emp emp = service.loginService(request);
		if(emp == null) {
			forward.setPath("loginFormAction.do?loginfail=1");
			forward.setRedirect(true);//redirect
			
			return forward;
		}else {
			
			if(emp.getSignupcheck() == 0) {
				forward.setPath("loginFormAction.do?loginfail=2");
				forward.setRedirect(true);//redirect
				
				return forward;
			}
				
		session.setAttribute("emp", emp);
		request.setAttribute("emp", emp);
		
		//페이지 이동 : 1)insertAction.jsp 2)list.jsp 3)기타(listAction.do)
		forward.setPath("mainAction.do");
		forward.setRedirect(true);//redirect
		
		return forward;
		}
	};
	
	

}
