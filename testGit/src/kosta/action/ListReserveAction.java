package kosta.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		forward.setPath("/meetingroomlist.jsp");
		forward.setRedirect(false);		
		
		return forward;
	}

}
