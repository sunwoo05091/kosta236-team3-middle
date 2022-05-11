package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.Community;
import kosta.service.CommunityService;

public class UpdateCommunityTradeFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CommunityService service = CommunityService.getInstance();
		
		int cm_no = Integer.parseInt(request.getParameter("cm_no"));
		Community community = service.detailCommunityTradeService(cm_no);
		request.setAttribute("community", community);
		
		forward.setRedirect(false);
		forward.setPath("/communityTradeUpdate.jsp");
		return forward;
	}

}
