package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.ScheduleListModel;
import kosta.service.ScheduleService;

public class SchedulePageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ScheduleService service = ScheduleService.getInstance();
		
		ScheduleListModel schedule = service.schedulePage(request);
		
		request.setAttribute("ScheduleListModel", schedule);
		
		forward.setPath("/schedule.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
