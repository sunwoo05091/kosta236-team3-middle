package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.Reserve;
import kosta.service.MeetingRoomService;

public class UpdateReserveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MeetingRoomService service = MeetingRoomService.getInstance();
		ActionForward forward = new ActionForward();
		
		service.updateMeetingRoomService(request);
				
		forward.setPath("listReserveAction.do");
		forward.setRedirect(true);
		
		
		return forward;
	}

}
