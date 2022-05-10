package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.Document;
import kosta.service.DocumentService;

public class DeleteDocumentAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DocumentService service = DocumentService.getInstance();
		ActionForward forward = new ActionForward();
		
		int dc_no = Integer.parseInt(request.getParameter("dc_no"));
		int document = service.deleteDocumentService(dc_no);
		
		request.setAttribute("document", document);
		
		forward.setRedirect(false);
		forward.setPath("listAction.do");
				
		return forward;
	}
}