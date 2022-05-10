package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertMeetingRoomFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		System.out.println("sdasdas");
		forward.setRedirect(false);
		forward.setPath("/insert_meetingroomform.jsp");
		return forward;
	}

}
