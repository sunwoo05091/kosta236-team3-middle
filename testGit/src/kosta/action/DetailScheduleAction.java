package kosta.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.Schedule;
import kosta.service.ScheduleService;

public class DetailScheduleAction implements ScheduleAction{

	@Override
	public ScheduleActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ScheduleActionForward forward = new ScheduleActionForward();
		ScheduleService service = ScheduleService.getInstance();
		
		int seq = Integer.parseInt(request.getParameter("s_no"));
		Schedule schedule = service.detailSchedule(seq);
		request.setAttribute("schedule", schedule);
		
		forward.setPath("/scheduleDetail.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}

}
