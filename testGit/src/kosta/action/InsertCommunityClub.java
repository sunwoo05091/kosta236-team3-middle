package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.service.CommunityService;

public class InsertCommunityClub implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommunityService service = CommunityService.getInstance();
		ActionForward forward = new ActionForward();
		
		service.insertCommunityClubService(request);
		
		forward.setPath("listCommunityClubAction.do");
		forward.setRedirect(true);
		
		return forward;
	}

}
