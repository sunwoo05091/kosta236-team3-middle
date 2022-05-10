package kosta.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.domain.Document;
import kosta.domain.DocumentDao;
import kosta.domain.DocumentList;
import kosta.domain.DocumentSearch;

public class DocumentService {
	
	private static DocumentService service = new DocumentService();
	private static DocumentDao dao;
	private static final int PAGE_SIZE = 5;	// 페이지의 글 갯수
	
	public static DocumentService getInstance() {
		dao = DocumentDao.getInstance();
		return service;
	}
	
	// 문서 작성
	public int insertDocumentService(HttpServletRequest request)throws Exception {
		request.setCharacterEncoding("utf-8");
		
		// 파일업로드 로직
		String uploadPath = request.getRealPath("upload");
		int size = 20 * 1024 * 1024; 
		
		MultipartRequest multi = 
				new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		
		// 파일 업로드 작성 코드
		Document document = new Document();
		document.setE_no(Integer.parseInt(multi.getParameter("e_no")));		// 사원번호
		document.setDc_title(multi.getParameter("dc_title"));								// 제목
		document.setDc_contents(multi.getParameter("dc_contents"));				// 내용
		document.setDc_state(multi.getParameter("dc_state"));							// 문서상태
		document.setDc_fname("");
		
		if (multi.getFilesystemName("dc_fname") != null) {
			String fname = (String)multi.getFilesystemName("dc_fname");
			document.setDc_fname(fname);
		
		}
		
		return dao.insertDocument(document);
	}
	
	// 목록 및 검색, 페이징 처리
	public DocumentList listDocumentService(HttpServletRequest request)throws Exception{
		
		// 글 검색
		DocumentSearch search = new DocumentSearch();
		HttpSession session = request.getSession();
		
		if (request.getParameterValues("area") != null) {
			session.removeAttribute("search"); 	
			
			search.setArea(request.getParameterValues("area"));
			search.setSearchKey("%"+request.getParameter("searchKey")+"%");
			
			session.setAttribute("search", search);
		}		
		
		else if(request.getParameter("area") == null
						&& request.getParameter("pageNum") == null) {
								session.removeAttribute("search");
		}
		
		if (session.getAttribute("search") != null) {
			search = (DocumentSearch)session.getAttribute("search");
		}
		
		// 페이징 처리
		int totalCount = dao.countDocument(search);
		
		int totalPageCount = totalCount/PAGE_SIZE;	
		if (totalCount%PAGE_SIZE > 0) {	
			totalPageCount++;
		}
				
	
		String pageNum = request.getParameter("pageNum");	
		if (pageNum == null) {
			pageNum = "1";
		}
				
		int requestPage = Integer.parseInt(pageNum);	
				
		int startPage = requestPage - (requestPage - 1) % 5;
				
		
		int endPage = startPage + 4;	
		if (endPage > totalPageCount) {
			endPage = totalPageCount;
		}
		
		int startRow = (requestPage - 1) * PAGE_SIZE;	
		
		// 글 목록
		List<Document> list = dao.listDocument(startRow, search);
		
		DocumentList documentList = new DocumentList(list, requestPage, totalPageCount, startPage, endPage);
		
		return documentList;
	}
	
	// 글 세부사항
	public Document detailDocumentService(int dc_no)throws Exception{
		return dao.detailDocument(dc_no);
	}
	
	// 글 수정
	public int updateDocumentService(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		Document document = new Document();		
		document.setDc_no(Integer.parseInt(request.getParameter("dc_no")));
		document.setDc_title(request.getParameter("dc_title"));								// 제목
		document.setDc_contents(request.getParameter("dc_contents"));				// 내용
		document.setDc_fname(request.getParameter("dc_fname"));										// 첨부파일				
		
		return dao.updateDocument(document);		
	}
	
	// 글 삭제
	public int deleteDocumentService(int dc_no)throws Exception{
		return dao.deleteDocument(dc_no);
	}
	
		// 결재 진행 문서함
		public DocumentList listDocumentSignProgressService(HttpServletRequest request)throws Exception{
			
			// 글 검색
			DocumentSearch search = new DocumentSearch();
			HttpSession session = request.getSession();
			
			if (request.getParameterValues("area") != null) {
				session.removeAttribute("search"); 	
				
				search.setArea(request.getParameterValues("area"));
				search.setSearchKey("%"+request.getParameter("searchKey")+"%");
				
				session.setAttribute("search", search);
			}		
			
			else if(request.getParameter("area") == null
							&& request.getParameter("pageNum") == null) {
									session.removeAttribute("search");
			}
			
			if (session.getAttribute("search") != null) {
				search = (DocumentSearch)session.getAttribute("search");
			}
			
			// 페이징 처리
			int totalCount = dao.countDocument(search);
			
			int totalPageCount = totalCount/PAGE_SIZE;	
			if (totalCount%PAGE_SIZE > 0) {	
				totalPageCount++;
			}
					
		
			String pageNum = request.getParameter("pageNum");	
			if (pageNum == null) {
				pageNum = "1";
			}
					
			int requestPage = Integer.parseInt(pageNum);	
					
			int startPage = requestPage - (requestPage - 1) % 5;
					
			
			int endPage = startPage + 4;	
			if (endPage > totalPageCount) {
				endPage = totalPageCount;
			}
			
			int startRow = (requestPage - 1) * PAGE_SIZE;	
			

			List<Document> list = dao.listDocumentSignProgress(startRow, search);
			
			DocumentList documentList = new DocumentList(list, requestPage, totalPageCount, startPage, endPage);
			
			return documentList;
		}
		
		
		// 결재 완료 문서함
		public DocumentList listDocumentSignComplete(HttpServletRequest request)throws Exception{
			
			// 글 검색
			DocumentSearch search = new DocumentSearch();
			HttpSession session = request.getSession();
			
			if (request.getParameterValues("area") != null) {
				session.removeAttribute("search"); 	
				
				search.setArea(request.getParameterValues("area"));
				search.setSearchKey("%"+request.getParameter("searchKey")+"%");
				
				session.setAttribute("search", search);
			}		
			
			else if(request.getParameter("area") == null
							&& request.getParameter("pageNum") == null) {
									session.removeAttribute("search");
			}
			
			if (session.getAttribute("search") != null) {
				search = (DocumentSearch)session.getAttribute("search");
			}
			
			// 페이징 처리
			int totalCount = dao.countDocument(search);
			
			int totalPageCount = totalCount/PAGE_SIZE;	
			if (totalCount%PAGE_SIZE > 0) {	
				totalPageCount++;
			}
					
		
			String pageNum = request.getParameter("pageNum");	
			if (pageNum == null) {
				pageNum = "1";
			}
					
			int requestPage = Integer.parseInt(pageNum);	
					
			int startPage = requestPage - (requestPage - 1) % 5;
					
			
			int endPage = startPage + 4;	
			if (endPage > totalPageCount) {
				endPage = totalPageCount;
			}
			
			int startRow = (requestPage - 1) * PAGE_SIZE;	
			
			List<Document> list = dao.listDocumentSignComplete(startRow, search);
			
			DocumentList documentList = new DocumentList(list, requestPage, totalPageCount, startPage, endPage);
			
			return documentList;
		}
		
		// 반려 문서함
		public DocumentList listDocumentSignCompanion(HttpServletRequest request)throws Exception{
			
			// 글 검색
			DocumentSearch search = new DocumentSearch();
			HttpSession session = request.getSession();
			
			if (request.getParameterValues("area") != null) {
				session.removeAttribute("search"); 	
				
				search.setArea(request.getParameterValues("area"));
				search.setSearchKey("%"+request.getParameter("searchKey")+"%");
				
				session.setAttribute("search", search);
			}		
			
			else if(request.getParameter("area") == null
							&& request.getParameter("pageNum") == null) {
									session.removeAttribute("search");
			}
			
			if (session.getAttribute("search") != null) {
				search = (DocumentSearch)session.getAttribute("search");
			}
			
			// 페이징 처리
			int totalCount = dao.countDocument(search);
			
			int totalPageCount = totalCount/PAGE_SIZE;	
			if (totalCount%PAGE_SIZE > 0) {	
				totalPageCount++;
			}
					
		
			String pageNum = request.getParameter("pageNum");	
			if (pageNum == null) {
				pageNum = "1";
			}
					
			int requestPage = Integer.parseInt(pageNum);	
					
			int startPage = requestPage - (requestPage - 1) % 5;
					
			
			int endPage = startPage + 4;	
			if (endPage > totalPageCount) {
				endPage = totalPageCount;
			}
			
			int startRow = (requestPage - 1) * PAGE_SIZE;	
			
			List<Document> list = dao.listDocumentSignCompanion(startRow, search);
			
			DocumentList documentList = new DocumentList(list, requestPage, totalPageCount, startPage, endPage);
			
			return documentList;
		}
		
		// 부서 문서함
		public DocumentList listDocumentSignCompleteDepartmentService(HttpServletRequest request)throws Exception{

			// 글 검색
			DocumentSearch search = new DocumentSearch();
			HttpSession session = request.getSession();
			
			if (request.getParameterValues("area") != null) {
				session.removeAttribute("search"); 	
				
				search.setArea(request.getParameterValues("area"));
				search.setSearchKey("%"+request.getParameter("searchKey")+"%");
				
				session.setAttribute("search", search);
			}		
			
			else if(request.getParameter("area") == null
							&& request.getParameter("pageNum") == null) {
									session.removeAttribute("search");
			}
			
			if (session.getAttribute("search") != null) {
				search = (DocumentSearch)session.getAttribute("search");
			}
			
			// 페이징 처리
			int totalCount = dao.countDocument(search);
			
			int totalPageCount = totalCount/PAGE_SIZE;	
			if (totalCount%PAGE_SIZE > 0) {	
				totalPageCount++;
			}
					
		
			String pageNum = request.getParameter("pageNum");	
			if (pageNum == null) {
				pageNum = "1";
			}
					
			int requestPage = Integer.parseInt(pageNum);	
					
			int startPage = requestPage - (requestPage - 1) % 5;
					
			
			int endPage = startPage + 4;	
			if (endPage > totalPageCount) {
				endPage = totalPageCount;
			}
			
			int startRow = (requestPage - 1) * PAGE_SIZE;	
			
			List<Document> list = dao.listDocumentSignCompleteDepartment(startRow, search);
			
			DocumentList documentList = new DocumentList(list, requestPage, totalPageCount, startPage, endPage);
			
			return documentList;
		}
	

}

