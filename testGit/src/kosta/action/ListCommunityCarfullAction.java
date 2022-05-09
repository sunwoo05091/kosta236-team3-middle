package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.ListModel;
import kosta.service.CommunityService;

public class ListCommunityCarfullAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommunityService service = CommunityService.getInstance();
		ActionForward forward = new ActionForward();
		
		ListModel listModel = service.listCommunityCarfullService(request);
		request.setAttribute("listModel", listModel);
		
		forward.setPath("/communityCarfullList.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
