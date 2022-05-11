package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.domain.Emp;
import kosta.service.DocumentService;

public class UpdateDocumentAction implements Action {
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception {
		ActionForward forward = new ActionForward();
		DocumentService service = DocumentService.getInstance();
		
		service.updateDocumentService(request);
		
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
		
		forward.setPath("listAction.do");
		forward.setRedirect(true);
				
		return forward;
	}

}
