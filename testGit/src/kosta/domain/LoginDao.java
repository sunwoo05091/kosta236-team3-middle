package kosta.domain;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.mapper.EmpMapper;

public class LoginDao {
	private static LoginDao dao = new LoginDao();
	
	public static LoginDao getInstance() {
		return dao;
	}
	
	public LoginDao() {}
	
	public SqlSessionFactory getSqlSessionFactory() {
		//mybaits-config.xml => SqlSesstionFactory 변환
		String resource = "mybatis-config.xml";
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	public Emp loginEmp(Login login) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Emp emp = new Emp();
		try {
			emp = sqlSession.getMapper(EmpMapper.class).loginEmp(login);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return emp;
	}

	public int insertEmp(Emp emp) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(EmpMapper.class).insertEmp(emp);
			if (re > 0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return re;
	}

	public int checkId(String id) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int check = -1;
		try {
			check = sqlSession.getMapper(EmpMapper.class).checkId(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return check;
	}

	public List<Emp> listSignUpApprove() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Emp> list = null;
		try {
			list = sqlSession.getMapper(EmpMapper.class).listSignUpApprove();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return list;
	}

	public int updateEmp(Emp emp) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(EmpMapper.class).updateEmp(emp);
			if(re > 0) {	//트랜잭션처리 insert update delete 필수
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

	public int checkIn(int e_no) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(EmpMapper.class).checkIn(e_no);
			if(re > 0) {	//트랜잭션처리 insert update delete 필수
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

	public int checkOut(int e_no) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(EmpMapper.class).checkOut(e_no);
			if(re > 0) {	//트랜잭션처리 insert update delete 필수
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

	public List<Emp> listEmp(int d_no) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Emp> list = null;
		try {
			list = sqlSession.getMapper(EmpMapper.class).listEmp(d_no);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return list;
	}
	
}
