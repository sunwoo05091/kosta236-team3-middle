package kosta.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.Schedule;
import kosta.domain.ScheduleListModel;
import kosta.service.ScheduleService;

public class ListScheduleAction implements Action{
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ScheduleService service = ScheduleService.getInstance();
		
		ScheduleListModel schedule = service.listSchedule(request);
		
		request.setAttribute("ScheduleListModel", schedule);
		
		forward.setPath("/list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
