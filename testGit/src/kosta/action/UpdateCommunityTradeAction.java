package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.service.CommunityService;

public class UpdateCommunityTradeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CommunityService service = CommunityService.getInstance();
		
		service.updateCommunityTradeService(request);
		
		forward.setPath("listCommunityAction.do");
		forward.setRedirect(true);
		return forward;
	}

}
