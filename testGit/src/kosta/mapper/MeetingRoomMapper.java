package kosta.mapper;

import java.util.List;

import kosta.domain.MeetingRoom;
import kosta.domain.Reserve;

public interface MeetingRoomMapper {
	int insertMeetingRoom(Reserve reserve);
	int updateMeetingRoom(Reserve reserve);
	List<Reserve> listReserve();
	Reserve detailMeetingRoom(int r_no);
	int deleteMeetingRoom(int r_no);
}
