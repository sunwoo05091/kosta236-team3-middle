package kosta.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.domain.Community;
import kosta.domain.CommunityListModel;
import kosta.domain.Emp;
import kosta.service.CommunityService;

public class ListCommunityAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommunityService service = CommunityService.getInstance();
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		Emp emp = (Emp)session.getAttribute("emp");
		request.setAttribute("emp", emp);
		int d_no = emp.getD_no();
		String d_name = null;

		switch (d_no) {
		case 1:
			d_name = "인사"; 
			break;
		case 2:
			d_name = "영업"; 
			break;
		case 3:
			d_name = "개발"; 
			break;
		case 4:
			d_name = "임원"; 
			break;
		case 5:
			d_name = "총무"; 
			break;
		}
		request.setAttribute("d_name", d_name);
		
		CommunityListModel listModel = service.listCommunityService(request);
		request.setAttribute("listModel", listModel);
		
		List<Community> notice = service.noticeCommunityService(request);
		request.setAttribute("Notice", notice);
		
		forward.setPath("/communityTradeList.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
