package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.service.DocumentService;

public class UpdateDocumentAction implements Action {
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception {
		ActionForward forward = new ActionForward();
		DocumentService service = DocumentService.getInstance();
		
		service.updateDocumentService(request);
		
		forward.setPath("listAction.do");
		forward.setRedirect(true);
				
		return forward;
	}

}
