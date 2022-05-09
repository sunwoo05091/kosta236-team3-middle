package kosta.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.Community;
import kosta.domain.Reply;
import kosta.service.CommunityService;

public class detailCommunityTradeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommunityService service = CommunityService.getInstance();
		ActionForward forward = new ActionForward();
		
		int cm_no = Integer.parseInt(request.getParameter("cm_no"));
		Community community = service.detailCommunityTradeService(cm_no);
		List<Reply> replys = service.listReplyService(request);
		
		request.setAttribute("community", community);
		request.setAttribute("replys", replys);
		
		forward.setPath("/communityTradeDetail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
