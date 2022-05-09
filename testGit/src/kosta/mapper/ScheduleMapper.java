package kosta.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import kosta.domain.Schedule;

public interface ScheduleMapper {
	
	int insertSchedule(Schedule schedule);
	List<Schedule> listSchedule(RowBounds row);
	Schedule detailSchedule(int s_no);
	int deleteSchedule(Schedule schedule);
	int updateSchedule(Schedule schedule);
	int countSchedule();
}
