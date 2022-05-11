package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.domain.Emp;
import kosta.domain.ListModel;
import kosta.service.BoardService;

public class ListReferenceroomAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardService service = BoardService.getInstance();
		ActionForward forward = new ActionForward();
		/* String b_category = request.getParameter("b_category"); */
		ListModel listModel = service.listReferenceroomService(request);
		/* System.out.println("b_category"+ b_category); */
		request.setAttribute("listModel", listModel);
		
		HttpSession session = request.getSession();
		Emp emp = (Emp)session.getAttribute("emp");
		request.setAttribute("emp", emp);
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
		
		forward.setPath("/referenceroomlist.jsp"); //?b_category="+ b_category
		forward.setRedirect(false);
		
		
		return forward;
	}

}
