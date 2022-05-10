package kosta.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.domain.Emp;
import kosta.service.LoginService;

public class ListOrganizationChartAction implements Action{

	public ListOrganizationChartAction() {}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		LoginService service = LoginService.getInstance();
		HttpSession session = request.getSession();
		
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
		
		String d_name2 = null;
		int dep = Integer.parseInt(request.getParameter("dep"));
		List<Emp> list = service.listEmpService(dep);
		request.setAttribute("list", list);
		
		switch (dep) {
		case 1:
			d_name2 = "인사"; 
			break;
		case 2:
			d_name2 = "영업"; 
			break;
		case 3:
			d_name2 = "개발"; 
			break;
		case 4:
			d_name2 = "임원"; 
			break;
		case 5:
			d_name2 = "총무"; 
			break;
		}
		request.setAttribute("dep", d_name2);
		
		
		
		forward.setRedirect(false);
		forward.setPath("/list_organization_chart.jsp");
		
		return forward;
	}
}
