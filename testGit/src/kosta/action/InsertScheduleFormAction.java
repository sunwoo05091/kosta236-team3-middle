package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertScheduleFormAction implements ScheduleAction {

	@Override
	public ScheduleActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ScheduleActionForward forward = new ScheduleActionForward();
		forward.setRedirect(false);
		forward.setPath("/insertForm.jsp");
		
		return forward; 
	}

}
