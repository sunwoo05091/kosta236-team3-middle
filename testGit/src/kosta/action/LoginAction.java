package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.Emp;
import kosta.service.LoginService;

public class LoginAction implements Action{
	
	public LoginAction() {}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginService service = LoginService.getInstance();
		ActionForward forward = new ActionForward();
		
		//비즈니스 호출
		Emp emp = service.loginService(request);
		System.out.println(emp);
		if(emp == null) {
			forward.setPath("loginFormAction.do");
			forward.setRedirect(true);//redirect
			
			return forward;
			
		}else {
		request.setAttribute("emp", emp);
		
		//페이지 이동 : 1)insertAction.jsp 2)list.jsp 3)기타(listAction.do)
		forward.setPath("mainAction.do");
		forward.setRedirect(true);//redirect
		
		return forward;
		}
	};
	
	

}
