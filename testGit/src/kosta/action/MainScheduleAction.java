package kosta.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.Schedule;
import kosta.domain.ScheduleListModel;
import kosta.service.ScheduleService;

public class MainScheduleAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ScheduleService service = ScheduleService.getInstance();
		
		ScheduleListModel list = service.schedulePage(request);
		request.setAttribute("ScheduleListModel", list);
		
		forward.setPath("/schedule.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
