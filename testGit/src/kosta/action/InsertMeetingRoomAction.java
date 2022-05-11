package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.service.BoardService;
import kosta.service.MeetingRoomService;

public class InsertMeetingRoomAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MeetingRoomService service = MeetingRoomService.getInstance();
		ActionForward forward = new ActionForward();
		
		service.insertMeetingRoomService(request);
		System.out.println("hhhhh");
		forward.setPath("listReserveAction.do");
		forward.setRedirect(true);
		
		return forward;
	}

}
