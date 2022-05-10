package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.ListModel;
import kosta.service.CommunityService;

public class ListCommunityClubAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommunityService service = CommunityService.getInstance();
		ActionForward forward = new ActionForward();
		
		ListModel listModel = service.listCommunityClubService(request);
		request.setAttribute("listModel", listModel);
		
		forward.setPath("/communityClubList.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
