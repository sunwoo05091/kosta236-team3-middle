package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.service.ScheduleService;

public class UpdateScheduleAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ScheduleService service = ScheduleService.getInstance();
		
		service.updateSchedule(request);
	
		forward.setPath("listAction.do");
		forward.setRedirect(true);
		
		return forward;
	}

}
