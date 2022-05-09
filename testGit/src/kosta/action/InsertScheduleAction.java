package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.service.ScheduleService;

public class InsertScheduleAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ScheduleService service = ScheduleService.getInstance();

		service.insertSchedule(request);
		
		forward.setPath("moveSchedule.do");
		forward.setRedirect(true);
		
		return forward;
	}

}
