package kosta.domain;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.sql.SQLSyntaxErrorException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.mapper.ScheduleMapper;




public class ScheduleDao {
	private static ScheduleDao dao = new ScheduleDao();
	
	public static ScheduleDao getInstance() {
		return dao;
	}
	
	public SqlSessionFactory getSqlsessionFactory() {
		String resource = "mybatis-config.xml";
		
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	public int insertSchedule(Schedule schedule) {
		SqlSession session = getSqlsessionFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(ScheduleMapper.class).insertSchedule(schedule);
			System.out.println("re :"+re);
			if(re > 0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		System.out.println("출력");
		return re;
	}
	
	public List<Schedule> listSchedule(int startRow){
		SqlSession session = getSqlsessionFactory().openSession();
		List<Schedule> list = null;
		try {
			list = session.getMapper(ScheduleMapper.class).listSchedule(new RowBounds(startRow, 5));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
	}
		return list;
}
	public Schedule detailSchedule(int s_no){
		SqlSession session = getSqlsessionFactory().openSession();
		Schedule schedule = null;
		try {
			schedule = session.getMapper(ScheduleMapper.class).detailSchedule(s_no);
			System.out.println(schedule.getS_no());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
	}
		return schedule;
	}
	
	
	public int deleteSchedule(Schedule schedule) {
		SqlSession session = getSqlsessionFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(ScheduleMapper.class).deleteSchedule(schedule);
			if(re > 0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return re;
	}
	
	public int updateSchedule(Schedule schedule) {
		SqlSession session = getSqlsessionFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(ScheduleMapper.class).updateSchedule(schedule);
			if(re > 0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return re;
	}
	
	public int countSchedule() {
		SqlSession session = getSqlsessionFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(ScheduleMapper.class).countSchedule();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return re;
	}
	
	public List<Schedule> todaySchedule(int startRow) {
		SqlSession session = getSqlsessionFactory().openSession();
		List<Schedule> list = null;
	
		try {
			list = session.getMapper(ScheduleMapper.class).todaySchedule(new RowBounds(startRow, 5));
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return list;
	}
	
	public List<Schedule> typeSchedule(String s_type) {
		SqlSession session = getSqlsessionFactory().openSession();
		List<Schedule> list = null;
		try {
			list = session.getMapper(ScheduleMapper.class).typeSchedule(s_type);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return list;
	}
	
	public int countMainPage() {
		SqlSession session = getSqlsessionFactory().openSession();
		int re = 0;
		try {
			re = session.getMapper(ScheduleMapper.class).countMainPage();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return re;
	}
	
	
	
}
