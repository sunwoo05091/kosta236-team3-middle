package kosta.domain;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.mapper.DocumentMapper;

public class DocumentDao {
	
	private static DocumentDao dao = new DocumentDao();
	
	public static DocumentDao getInstance() {
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
	
	
	// 문서 작성
	public int insertDocument(Document document) {
		SqlSession sqlSession = getSqlSessionFactory().openSession(); 
		int re = -1;
		
		try {
			re = sqlSession.getMapper(DocumentMapper.class).insertDocument(document);
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
	
	// 목록 및 검색
	public List <Document> listDocument(int startRow, DocumentSearch search){
		SqlSession sqlSession = getSqlSessionFactory().openSession(); 
		List<Document> list = null;
		try {
			list = sqlSession.getMapper(DocumentMapper.class).listDocument(search, new RowBounds(startRow, 5));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return list;
	}
	
	// 페이징 처리
	public int countDocument(DocumentSearch search) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = 0;
		
		try {
			re = sqlSession.getMapper(DocumentMapper.class).countDocument(search);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return re;

	}
	
	// 문서 세부사항
	public Document detailDocument(int dc_no) {
		SqlSession sqlSession = getSqlSessionFactory().openSession(); 
		Document document = null;
		try {
			document = sqlSession.getMapper(DocumentMapper.class).detailDocument(dc_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return document;
	}
	
	// 문서 수정
	public int updateDocument(Document document) {
		SqlSession sqlSession = getSqlSessionFactory().openSession(); 
		int re = -1;
		
		try {
			re = sqlSession.getMapper(DocumentMapper.class).updateDocument(document);
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
	
	// 문서 삭제
	public int deleteDocument(int dc_no) {
		SqlSession sqlSession = getSqlSessionFactory().openSession(); 
		int re = -1;
		
		try {
			re = sqlSession.getMapper(DocumentMapper.class).deleteDocument(dc_no);
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
	
	// 결재 진행 문서함
	public List <Document> listDocumentSignProgress(int startRow, DocumentSearch search){
		SqlSession sqlSession = getSqlSessionFactory().openSession(); 
		List<Document> list = null;
		try {
			list = sqlSession.getMapper(DocumentMapper.class).listDocumentSignProgress(search, new RowBounds(startRow, 5));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return list;
	}
	
	// 결재 완료 문서함
	public List <Document> listDocumentSignComplete(int startRow, DocumentSearch search){
		SqlSession sqlSession = getSqlSessionFactory().openSession(); 
		List<Document> list = null;
		try {
			list = sqlSession.getMapper(DocumentMapper.class).listDocumentSignComplete(search, new RowBounds(startRow, 5));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return list;
	}
	
	// 반려 문서함
	public List <Document> listDocumentSignCompanion(int startRow, DocumentSearch search){
		SqlSession sqlSession = getSqlSessionFactory().openSession(); 
		List<Document> list = null;
		try {
			list = sqlSession.getMapper(DocumentMapper.class).listDocumentSignCompanion(search, new RowBounds(startRow, 5));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return list;
	}
	
	// 부서 문서함
	public List <Document> listDocumentSignCompleteDepartment(int startRow, DocumentSearch search){
		SqlSession sqlSession = getSqlSessionFactory().openSession(); 
		List<Document> list = null;
		try {
			list = sqlSession.getMapper(DocumentMapper.class).listDocumentSignCompleteDepartment(search, new RowBounds(startRow, 5));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return list;
	}
	
	
	

}
