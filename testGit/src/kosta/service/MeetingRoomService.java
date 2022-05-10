package kosta.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kosta.domain.MeetingRoom;
import kosta.domain.MeetingRoomDao;
import kosta.domain.Reserve;

public class MeetingRoomService {
	private static MeetingRoomService service = new MeetingRoomService();
	private static MeetingRoomDao dao;
	
	public static MeetingRoomService getInstance() {
		dao = MeetingRoomDao.getInsance();
		return service;
	}
	
	public int insertMeetingRoomService(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		Reserve reserve = new Reserve(); 
		reserve.setMr_no(Integer.parseInt(request.getParameter("mr_no")));
		reserve.setR_date(request.getParameter("r_date"));
		reserve.setR_starttime(request.getParameter("r_starttime"));
		reserve.setR_endtime(request.getParameter("r_endtime"));
		reserve.setMeetingtitle(request.getParameter("meetingtitle"));
		System.out.println(request.getParameter("r_starttime"));
		return dao.insertMeetingRoom(reserve);
	}
	
	public List<Reserve> listReserveService(HttpServletRequest request)throws Exception{
		List<Reserve> list = dao.listReserve();
		
		return list;
	}
	
	public int updateMeetingRoomService(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		Reserve reserve = new Reserve();
		reserve.setR_no(Integer.parseInt(request.getParameter("r_no")));
		reserve.setMeetingtitle(request.getParameter("meetingtitle"));
		reserve.setR_starttime(request.getParameter("r_starttime"));
		reserve.setR_endtime(request.getParameter("r_endtime"));
		
		
		return dao.updateMeetingRoom(reserve);
	}

	public Reserve detailMeetingRoomService(int r_no)throws Exception{
		return dao.detailMeetingRoom(r_no);
	} 
	
	public int deleteMeetingRoomService(int r_no)throws Exception{
		return dao.deleteMeetingRoom(r_no);
	}
	
}//end class
