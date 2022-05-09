package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainScheduleAction implements ScheduleAction{

	@Override
	public ScheduleActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ScheduleActionForward forward = new ScheduleActionForward();
		
		forward.setPath("/schedule.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
