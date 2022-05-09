package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.Schedule;
import kosta.service.ScheduleService;

public class DeleteScheduleAction implements ScheduleAction{

	@Override
	public ScheduleActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ScheduleActionForward forward = new ScheduleActionForward();
		ScheduleService service = ScheduleService.getInstance();
		
		service.deleteSchedule(request);
		
		forward.setPath("listAction.do");
		forward.setRedirect(true);
		
		return forward;
		
	}

}
