package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.service.CommunityService;

public class InsertReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CommunityService service = CommunityService.getInstance();
		
		service.insertReplyService(request);
		forward.setPath("detailTradeAction.do?cm_no=" + request.getParameter("cm_no"));
		forward.setRedirect(true);
		return forward;
	}

}
