package kosta.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.ListScheduleAction;
import kosta.domain.Schedule;
import kosta.domain.ScheduleDao;
import kosta.domain.ScheduleListModel;

public class ScheduleService {
	private static ScheduleService service = new ScheduleService();
	private static ScheduleDao dao;
	private static final int PAGE_SIZE = 5;
	
	public static ScheduleService getInstance() {
		dao = ScheduleDao.getInstance();
		return service;
	}
	
	public int insertSchedule(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		Schedule schedule = new Schedule();
		schedule.setS_title(request.getParameter("s_title"));
		schedule.setS_contents(request.getParameter("s_contents"));
		schedule.setS_type(request.getParameter("s_type"));
		schedule.setS_startday(request.getParameter("s_startday"));
		schedule.setS_finishday(request.getParameter("s_finishday"));
		schedule.setSituation(request.getParameter("situation"));
		
		System.out.println(request.getParameter("s_type"));
		
		return dao.insertSchedule(schedule);
	 }
	
	public ScheduleListModel listSchedule(HttpServletRequest request){
		
		//startPage, endPage, startRow, endRow
		
				//총글개수
				int totalCount = dao.countSchedule();
				
				//총페이지수
				int totalPageCount = totalCount/PAGE_SIZE;
				if(totalCount%PAGE_SIZE > 0) {
					totalPageCount++;
				}
				
				//현재페이지
				String pageNum = request.getParameter("pageNum");
				if(pageNum == null) {
					pageNum = "1";
				}		
				
				int requestPage = Integer.parseInt(pageNum);
				
				//startPage = 현재페이지 - (현재페이지 - 1)%5  => ex)  14 - (14 -1)%5 = 11
				int startPage = requestPage - (requestPage - 1) % 5;
						
				//endPage 
				int endPage = startPage + 4;
				if(endPage > totalPageCount) {
					endPage = totalPageCount;
				}
				
				//startRow = (현재페이지 - 1) * 페이지당 글개수
				int startRow = (requestPage - 1) * PAGE_SIZE;
				
				List<Schedule> list = dao.listSchedule(startRow);
				
				ScheduleListModel model = new ScheduleListModel(list, requestPage, totalPageCount, startPage, endPage);
		
		return model;
	}
	public ScheduleListModel schedulePage(HttpServletRequest request) {

		//startPage, endPage, startRow, endRow
		
				//총글개수
				int totalCount = dao.countMainPage();
				
				//총페이지수
				int totalPageCount = totalCount/PAGE_SIZE;
				if(totalCount%PAGE_SIZE > 0) {
					totalPageCount++;
				}
				
				//현재페이지
				String pageNum = request.getParameter("pageNum");
				if(pageNum == null) {
					pageNum = "1";
				}		
				
				int requestPage = Integer.parseInt(pageNum);
				
				//startPage = 현재페이지 - (현재페이지 - 1)%5  => ex)  14 - (14 -1)%5 = 11
				int startPage = requestPage - (requestPage - 1) % 5;
						
				//endPage 
				int endPage = startPage + 4;
				if(endPage > totalPageCount) {
					endPage = totalPageCount;
				}
				
				//startRow = (현재페이지 - 1) * 페이지당 글개수
				int startRow = (requestPage - 1) * PAGE_SIZE;
				
				List<Schedule> list = dao.todaySchedule(startRow);
				
				ScheduleListModel model = new ScheduleListModel(list, requestPage, totalPageCount, startPage, endPage);
		
				return model;
	}
	
	public Schedule detailSchedule(int seq)throws Exception{
		return dao.detailSchedule(seq);
	}
	public int deleteSchedule(HttpServletRequest request)throws Exception{
		Schedule schedule = new Schedule();
		schedule.setS_no(Integer.parseInt(request.getParameter("s_no")));
		
		return dao.deleteSchedule(schedule);
	}
	public int updateSchedule(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		Schedule schedule = new Schedule();
		schedule.setS_no(Integer.parseInt(request.getParameter("s_no")));
		schedule.setS_title(request.getParameter("s_title"));
		schedule.setS_contents(request.getParameter("s_contents"));
		schedule.setS_startday(request.getParameter("s_startday"));
		schedule.setS_finishday(request.getParameter("s_finishday"));
		schedule.setS_type(request.getParameter("s_type"));
		schedule.setSituation(request.getParameter("situation"));
		
		return dao.updateSchedule(schedule);
	}

	
	public List<Schedule> typeSchedule(HttpServletRequest request) {
		int no = Integer.parseInt(request.getParameter("s_type"));
		
		String s_type = null;

		switch (no) {
		case 1:
			s_type = "개인";
			break;
		case 2:
			s_type = "미팅";
			break;
		case 3:
			s_type = "회의";
			break;
		}
		
		return dao.typeSchedule(s_type);
	}
	
	
}
