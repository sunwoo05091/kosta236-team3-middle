package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.Reserve;
import kosta.service.MeetingRoomService;

public class UpdateReserveFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		MeetingRoomService service = MeetingRoomService.getInstance();
		
		int r_no = Integer.parseInt(request.getParameter("r_no"));
		Reserve reserve = service.detailMeetingRoomService(r_no);
		request.setAttribute("reserve", reserve);
		
		forward.setRedirect(false);
		forward.setPath("/updatereserveform.jsp");
	
		
		return forward;
	}

}
