package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.Document;
import kosta.service.DocumentService;

public class UpdateDocumentFormAction implements Action {
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		DocumentService service = DocumentService.getInstance();
		
		int dc_no = Integer.parseInt(request.getParameter("dc_no"));
		Document document = service.detailDocumentService(dc_no);
		request.setAttribute("document", document);
		
		forward.setRedirect(false);
		forward.setPath("/update_DocumentForm.jsp");
		
		return forward;
	}

}
