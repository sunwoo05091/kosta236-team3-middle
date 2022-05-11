package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.Reserve;
import kosta.service.MeetingRoomService;

public class DetailReserveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MeetingRoomService service = MeetingRoomService.getInstance();
		ActionForward forward = new ActionForward();
		
		int r_no = Integer.parseInt(request.getParameter("r_no"));
		Reserve reserve = service.detailMeetingRoomService(r_no);
		request.setAttribute("reserve", reserve);
		System.out.println(request.getParameter("r_no"));
		
		forward.setRedirect(false);
		forward.setPath("/detailreserve.jsp");
		
		
		return forward;
	}

}
