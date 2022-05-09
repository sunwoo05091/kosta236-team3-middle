package kosta.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.domain.Emp;
import kosta.service.LoginService;

public class ListSignUpApproveAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginService service = LoginService.getInstance();
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		List<Emp> list = service.listSignUpApproveAction();
		Emp emp = (Emp)session.getAttribute("emp");
		int d_no = emp.getD_no();
		String d_name = null;

		switch (d_no) {
		case 1:
			d_name = "인사"; 
			break;
		case 2:
			d_name = "영업"; 
			break;
		case 3:
			d_name = "개발"; 
			break;
		case 4:
			d_name = "임원"; 
			break;
		case 5:
			d_name = "총무"; 
			break;
		}
		request.setAttribute("d_name", d_name);
		request.setAttribute("list", list);
		
		forward.setPath("/HRM.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
