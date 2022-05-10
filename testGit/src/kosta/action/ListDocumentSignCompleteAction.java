package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.DocumentList;
import kosta.service.DocumentService;

public class ListDocumentSignCompleteAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DocumentService service = DocumentService.getInstance();
		ActionForward forward = new ActionForward();
		
		DocumentList documentList = service.listDocumentSignComplete(request);
		
		request.setAttribute("documentList", documentList);
		
		forward.setPath("/list_DocumentSignComplete.jsp");
		forward.setRedirect(false);
		
		return forward;
		
	}

}
