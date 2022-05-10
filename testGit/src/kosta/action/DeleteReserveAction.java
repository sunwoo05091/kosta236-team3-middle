package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.service.BoardService;
import kosta.service.MeetingRoomService;

public class DeleteReserveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MeetingRoomService service = MeetingRoomService.getInstance();
		ActionForward forward = new ActionForward();
		
		int r_no = Integer.parseInt(request.getParameter("r_no"));
		
		service.deleteMeetingRoomService(r_no); 
		forward.setPath("listReserveAction.do");
		forward.setRedirect(true);
		
		
		return forward;
	}

}
