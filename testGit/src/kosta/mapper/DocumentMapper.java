package kosta.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import kosta.domain.Document;
import kosta.domain.DocumentSearch;

public interface DocumentMapper {
	
	
	// 글 작성
	int insertDocument(Document document);
	
	// 글 목록 및 검색
	List<Document> listDocument(DocumentSearch search, RowBounds row);
	
	// 페이징 처리
	int countDocument(DocumentSearch search);
	
	// 글 세부사항
	Document detailDocument(int dc_no);
	
	// 글 수정
	int updateDocument(Document document);
	
	// 글 삭제
	int deleteDocument(int dc_no);
	
	// 결재 진행 문서함
	List<Document> listDocumentSignProgress(DocumentSearch search, RowBounds row);
	
	// 결재 완료 문서함
	List<Document> listDocumentSignComplete(DocumentSearch search, RowBounds row);
	
	// 반려 문서함
	List<Document> listDocumentSignCompanion(DocumentSearch search, RowBounds row);
	
	// 부서 문서함
	List<Document> listDocumentSignCompleteDepartment(DocumentSearch search, RowBounds row);
	
	
	

}
