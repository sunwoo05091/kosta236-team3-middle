package kosta.domain;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.mapper.BoardMapper;

public class BoardDao {
	private static BoardDao dao = new BoardDao();
	
	public static BoardDao getInstance() {
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
	
	public int insertBoard(Board board) { //공지사항
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {

			re = sqlSession.getMapper(BoardMapper.class).insertBoard(board);
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
	
	public int insertReferenceroom(Board board) { //자료실
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {

			re = sqlSession.getMapper(BoardMapper.class).insertReferenceroom(board);
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
	
	public List<Board> listBoard(int startRow,Search search){ //공지사항리스트
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Board> list = null;
		try {
			list = sqlSession.getMapper(BoardMapper.class).listBoard(search,new RowBounds(startRow, 2));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
		
	}
	
	public List<Board> listReferenceroom(int startRow,Search search){ //자료실리스트
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Board> list = null;
		try {
			list = sqlSession.getMapper(BoardMapper.class).listReferenceroom(search,new RowBounds(startRow, 2));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
		
	}
	
	public Board detailBoard(int b_no) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Board board = null;
		try {
			board = sqlSession.getMapper(BoardMapper.class).detailBoard(b_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return board;
	}
	
	
	
	public int updateBoard(Board board) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(BoardMapper.class).updateBoard(board);	
			if(re > 0) {
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
	
	public int deleteBoard(int b_no) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(BoardMapper.class).deleteBoard(b_no);
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
	
	public int deleteReferenceroom(int b_no) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(BoardMapper.class).deleteReferenceroom(b_no);
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
	
	public int countBoard(Search search) {
		SqlSession sqlSession = getSqlSessionFactory().openSession(); 
		int re = 0;
		try {
			re = sqlSession.getMapper(BoardMapper.class).countBoard(search);//글개수를 알려줌
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return re;
	}
	
}//end class
