package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ScheduleAction {
	public ScheduleActionForward excute(HttpServletRequest request, HttpServletResponse response)throws Exception;
}
