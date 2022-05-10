package kosta.domain;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.mapper.BoardMapper;
import kosta.mapper.MeetingRoomMapper;

public class MeetingRoomDao {
	private static MeetingRoomDao dao = new MeetingRoomDao();

	public static MeetingRoomDao getInsance() {
		return dao;
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream in = null;

		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new SqlSessionFactoryBuilder().build(in);
	}
	
	public int insertMeetingRoom(Reserve reserve) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {

			re = sqlSession.getMapper(MeetingRoomMapper.class).insertMeetingRoom(reserve);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return re;

	}
	
	public List<Reserve> listReserve() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Reserve> list = null;
		try {
			System.out.println(1);
			list = sqlSession.getMapper(MeetingRoomMapper.class).listReserve();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return list;
	}
	
	public int updateMeetingRoom(Reserve reserve) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(MeetingRoomMapper.class).updateMeetingRoom(reserve);
				
			if(re>0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return re;
}
	
	public Reserve detailMeetingRoom(int r_no) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Reserve reserve = null;
		try {
			reserve = sqlSession.getMapper(MeetingRoomMapper.class).detailMeetingRoom(r_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return reserve;
	}
	public int deleteMeetingRoom(int r_no) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(MeetingRoomMapper.class).deleteMeetingRoom(r_no);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}			
		}
		return re;
	}
}//end dao
