package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.service.DocumentService;

import kosta.action.Action;
import kosta.action.ActionForward;

public class InsertSignEmpAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DocumentService service = DocumentService.getInstance();
		ActionForward forward = new ActionForward();
		
		service.insertSignEmpService(request);
		forward.setPath("insertAction.do");
		forward.setRedirect(true);
		
		return forward;
	}

}