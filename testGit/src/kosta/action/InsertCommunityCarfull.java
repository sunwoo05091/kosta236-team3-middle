package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.service.CommunityService;

public class InsertCommunityCarfull implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommunityService service = CommunityService.getInstance();
		ActionForward forward = new ActionForward();
		
		service.insertCommunityCarfullService(request);
		
		forward.setPath("listCommunityCarfullAction.do");
		forward.setRedirect(true);
		
		return forward;
	}

}
