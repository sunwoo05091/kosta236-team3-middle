package kosta.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.Schedule;
import kosta.service.ScheduleService;

public class DetailScheduleAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ScheduleService service = ScheduleService.getInstance();
		
		int seq = Integer.parseInt(request.getParameter("s_no"));
		Schedule schedule = service.detailSchedule(seq);
		request.setAttribute("schedule", schedule);
		
		forward.setPath("/scheduleDetail.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}

}
