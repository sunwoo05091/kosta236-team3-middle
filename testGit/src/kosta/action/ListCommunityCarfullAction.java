package kosta.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.Community;
import kosta.domain.CommunityListModel;
import kosta.service.CommunityService;

public class ListCommunityCarfullAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommunityService service = CommunityService.getInstance();
		ActionForward forward = new ActionForward();
		
		CommunityListModel listModel = service.listCommunityCarfullService(request);
		request.setAttribute("listModel", listModel);
		
		List<Community> notice = service.noticeCommunityService(request);
		request.setAttribute("Notice", notice);
		
		forward.setPath("/communityCarfullList.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
