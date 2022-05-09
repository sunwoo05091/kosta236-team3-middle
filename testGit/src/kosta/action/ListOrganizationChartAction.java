package kosta.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.Emp;
import kosta.service.LoginService;

public class ListOrganizationChartAction implements Action{

	public ListOrganizationChartAction() {}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		LoginService service = LoginService.getInstance();
		
		int d_no = Integer.parseInt(request.getParameter("d_no"));
		
		List<Emp> list = service.listEmpService(d_no);
		request.setAttribute("list", list);
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
		
		forward.setRedirect(false);
		forward.setPath("/list_organization_chart.jsp");
		
		return forward;
	}
}
