package kosta.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.Community;
import kosta.domain.ListModel;
import kosta.service.CommunityService;

public class ListCommunityAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommunityService service = CommunityService.getInstance();
		ActionForward forward = new ActionForward();
		
		ListModel listModel = service.listCommunityService(request);
		request.setAttribute("listModel", listModel);
		
		List<Community> notice = service.noticeCommunityService(request);
		request.setAttribute("Notice", notice);
		
		forward.setPath("/communityTradeList.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
