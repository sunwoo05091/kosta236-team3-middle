package kosta.domain;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.mapper.CommunityMapper;



public class CommunityDao {

	private static CommunityDao dao = new CommunityDao();
	
	public static CommunityDao getInstance() {
		return dao;
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream in = null;
		
		try {
			in = org.apache.ibatis.io.Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	public List<Community> listCommunity(int startRow, Search search){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Community> list = null;
		
		try {
			list = sqlSession.getMapper(CommunityMapper.class).listCommunity(search, new RowBounds(startRow, 2));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
	}
	
	public int insertCommunityTrade(Community community) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(CommunityMapper.class).insertCommunityTrade(community);
			if(re>0) {
				sqlSession.commit();
			}else {
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
	
	public List<Community> listCommunityClub(int startRow, Search search){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Community> list = null;
		
		try {
			list = sqlSession.getMapper(CommunityMapper.class).listCommunityClub(search, new RowBounds(startRow, 2));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
	}
	
	public int insertCommunityClub(Community community) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(CommunityMapper.class).insertCommunityClub(community);
			if(re>0) {
				sqlSession.commit();
			}else {
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
	
	public List<Community> listCommunityCarfull(int startRow, Search search){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Community> list = null;
		
		try {
			list = sqlSession.getMapper(CommunityMapper.class).listCommunityCarfull(search, new RowBounds(startRow, 2));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
	}
	
	public int insertCommunityCarfull(Community community) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(CommunityMapper.class).insertCommunityCarfull(community);
			if(re>0) {
				sqlSession.commit();
			}else {
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
	
	public Community detailCommunityTrade(int cm_no) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Community community = null;
		
		try {
			community = sqlSession.getMapper(CommunityMapper.class).detailCommunityTrade(cm_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return community;
	}
	
	public int updateCommunityTrade(Community community) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(CommunityMapper.class).updateCommunityTrade(community);
			if(re>0) {
				sqlSession.commit();
			}else {
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
	
	public int deleteCommunityTrade(Community community) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(CommunityMapper.class).deleteCommunityTrade(community);
			if(re>0) {
				sqlSession.commit();
			}else {
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
	
	public int insertReply(Reply reply) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(CommunityMapper.class).insertReply(reply);
			if(re>0) {
				sqlSession.commit();
			}else {
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
	
	public List<Reply> listReply(int cm_no){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Reply> list = null;
		
		try {
			list = sqlSession.getMapper(CommunityMapper.class).listReply(cm_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
	}
	
	public int countBoard(Search search) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = 0;
		try {
			re = sqlSession.getMapper(CommunityMapper.class).countBoard(search);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return re;
	}
	
	public List<Community> noticeCommunity(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Community> notice = null;
		try {
			notice = sqlSession.getMapper(CommunityMapper.class).noticeCommunity();
			System.out.println(notice.size());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return notice;
	}
}
