package kosta.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.Schedule;
import kosta.service.ScheduleService;

public class TypeScheduleAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ScheduleService service = ScheduleService.getInstance();
		
		List<Schedule> list = service.typeSchedule(request);
		
		request.setAttribute("schedule", list);
		
		forward.setPath("/mainDetailSchedule.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
