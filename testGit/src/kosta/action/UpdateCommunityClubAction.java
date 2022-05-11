package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.service.CommunityService;

public class UpdateCommunityClubAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CommunityService service = CommunityService.getInstance();
		
		service.updateCommunityClubService(request);
		
		forward.setPath("listCommunityClubAction.do");
		forward.setRedirect(true);
		return forward;
	}

}
