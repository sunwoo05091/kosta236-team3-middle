package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.Schedule;
import kosta.service.ScheduleService;

public class MoveUpdateAction implements ScheduleAction{

	@Override
	public ScheduleActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ScheduleActionForward forward = new ScheduleActionForward();
		ScheduleService service = ScheduleService.getInstance();
		
		int s_no = Integer.parseInt(request.getParameter("s_no"));
		Schedule schedule = service.detailSchedule(s_no);
		request.setAttribute("schedule", schedule);
		
		forward.setPath("/UpdateSchedule.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
