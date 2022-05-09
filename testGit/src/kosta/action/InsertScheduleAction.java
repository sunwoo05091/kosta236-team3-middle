package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.service.ScheduleService;

public class InsertScheduleAction implements ScheduleAction {

	@Override
	public ScheduleActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ScheduleActionForward forward = new ScheduleActionForward();
		ScheduleService service = ScheduleService.getInstance();

		service.insertSchedule(request);
		
		forward.setPath("moveSchedule.do");
		forward.setRedirect(true);
		
		return forward;
	}

}
