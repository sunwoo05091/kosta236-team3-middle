package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.service.DocumentService;

import kosta.action.Action;
import kosta.action.ActionForward;

public class InsertDocumentAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DocumentService service = DocumentService.getInstance();
		ActionForward forward = new ActionForward();
		
		service.insertDocumentService(request);
		forward.setPath("listAction.do");
		forward.setRedirect(true);
		
		return forward;
	}

}