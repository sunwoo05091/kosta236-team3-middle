package kosta.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.domain.Emp;
import kosta.domain.ListModel;
import kosta.domain.MeetingRoom;
import kosta.domain.Reserve;
import kosta.service.BoardService;
import kosta.service.MeetingRoomService;

public class ListReserveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MeetingRoomService service = MeetingRoomService.getInstance();
		ActionForward forward = new ActionForward();
		
		List<Reserve> list = service.listReserveService(request);
		
		request.setAttribute("list", list);
		
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
		
		forward.setPath("/meetingroomlist.jsp");
		forward.setRedirect(false);		
		
		return forward;
	}

}
