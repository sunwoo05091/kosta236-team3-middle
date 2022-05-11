package kosta.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.domain.Board;
import kosta.domain.BoardDao;
import kosta.domain.ListModel;
import kosta.domain.Search;
import kosta.util.ImageUtil;

public class BoardService {
	private static BoardService service = new BoardService();
	private static BoardDao dao;
	private static final int PAGE_SIZE = 2;
	
	public static BoardService getInstance() {
		dao = BoardDao.getInstance();
		return service;
	}
	
	public int insertBoardService(HttpServletRequest request)throws Exception{ //공지사항서비스
		request.setCharacterEncoding("UTF-8");
		
		String uploadPath = request.getRealPath("upload");
		int size = 20 * 1024 * 1024;
		
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		
		Board board = new Board();
		board.setB_title(multi.getParameter("b_title"));
		board.setB_contents(multi.getParameter("b_contents"));
		board.setB_fname("");
		
		
		if(multi.getFilesystemName("b_fname")!= null) { 
			String b_fname = multi.getFilesystemName("b_fname"); 
			board.setB_fname(b_fname); 
			
			
			String pattern = b_fname.substring(b_fname.indexOf(".")+1); 
			String head = b_fname.substring(0,b_fname.indexOf("."));
			
			
			String imagePath = uploadPath + "\\" + b_fname;
			File src = new File(imagePath); 
			
			
			String thumPath = uploadPath + "\\" + head + "_small." + pattern;
			File dest = new File(thumPath); 
			
			if(pattern.equals("gif") || pattern.equals("jpg") || pattern.equals("png")) { 
				ImageUtil.resize(src, dest, 100, ImageUtil.RATIO);
			}
		}
		System.out.println(board);
		return dao.insertBoard(board);
	}
	
	public int insertReferenceroomService(HttpServletRequest request)throws Exception{ //자료실
		request.setCharacterEncoding("UTF-8");
		
		String uploadPath = request.getRealPath("upload");
		int size = 20 * 1024 * 1024;
		
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		
		Board board = new Board();
		board.setB_title(multi.getParameter("b_title"));
		board.setB_contents(multi.getParameter("b_contents"));
		board.setB_fname("");
		
		
		if(multi.getFilesystemName("b_fname")!= null) { 
			String b_fname = multi.getFilesystemName("b_fname"); 
			board.setB_fname(b_fname); 
			
			
			String pattern = b_fname.substring(b_fname.indexOf(".")+1); 
			String head = b_fname.substring(0,b_fname.indexOf("."));
			
			
			String imagePath = uploadPath + "\\" + b_fname;
			File src = new File(imagePath); 
			
			
			String thumPath = uploadPath + "\\" + head + "_small." + pattern;
			File dest = new File(thumPath); 
			
			if(pattern.equals("gif") || pattern.equals("jpg") || pattern.equals("png")) { 
				ImageUtil.resize(src, dest, 100, ImageUtil.RATIO);
			}
		}
		
		return dao.insertReferenceroom(board);
	}
	
	public ListModel listBoardService(HttpServletRequest request)throws Exception{ //공지사항서비스
		
				Search search = new Search();
				HttpSession session = request.getSession();
				
				
				if(request.getParameter("area") != null) {
					session.removeAttribute("search");
					search.setArea(request.getParameterValues("area"));
					search.setSearchKey("%"+ request.getParameter("searchKey")+ "%");
					session.setAttribute("search", search);
				}
				else if(request.getParameter("area") == null
						&& request.getParameter("pageNum") == null) {
					session.removeAttribute("search");
				}
				
			
				if(session.getAttribute("search") != null){
					search = (Search)session.getAttribute("search");
				}
				
							
				
				int totalCount = dao.countBoard(search);
				
				
				int totalPageCount = totalCount/PAGE_SIZE;
				if(totalCount%PAGE_SIZE > 0) {
					totalPageCount++;
				}
				
			
				String pageNum = request.getParameter("pageNum"); 
				if(pageNum == null) {
					pageNum = "1";
				}		
				
				int requestPage = Integer.parseInt(pageNum);
				
			
				int startPage = requestPage - (requestPage - 1) %5;
						
		
				int endPage = startPage + 4;
				if(endPage > totalPageCount) {
					endPage = totalPageCount;
				}
				
			
				int startRow = (requestPage - 1) * PAGE_SIZE;
				
				List<Board> list = dao.listBoard(startRow, search);
				
				ListModel listModel = new ListModel(list, requestPage, totalPageCount, startPage, endPage);
				
				return listModel;
	}
	
	public ListModel listReferenceroomService(HttpServletRequest request)throws Exception{ //자료실서비스
		
		Search search = new Search();
		HttpSession session = request.getSession();
		
		
		if(request.getParameter("area") != null) {
			session.removeAttribute("search");
			search.setArea(request.getParameterValues("area"));
			search.setSearchKey("%"+ request.getParameter("searchKey")+ "%");
			session.setAttribute("search", search);
		}
		else if(request.getParameter("area") == null
				&& request.getParameter("pageNum") == null) {
			session.removeAttribute("search");
		}
		
	
		if(session.getAttribute("search") != null){
			search = (Search)session.getAttribute("search");
		}
		
		
		
		
		
		
		
		int totalCount = dao.countBoard(search);
		
		
		int totalPageCount = totalCount/PAGE_SIZE;
		if(totalCount%PAGE_SIZE > 0) {
			totalPageCount++;
		}
		
	
		String pageNum = request.getParameter("pageNum"); 
		if(pageNum == null) {
			pageNum = "1";
		}		
		
		int requestPage = Integer.parseInt(pageNum);
		
	
		int startPage = requestPage - (requestPage - 1) %5;
				

		int endPage = startPage + 4;
		if(endPage > totalPageCount) {
			endPage = totalPageCount;
		}
		
	
		int startRow = (requestPage - 1) * PAGE_SIZE;
		
		List<Board> list = dao.listReferenceroom(startRow, search);
		
		ListModel listModel = new ListModel(list, requestPage, totalPageCount, startPage, endPage);
		
		return listModel;
}
	
	public Board detailBoardService(int b_no)throws Exception{
		return dao.detailBoard(b_no);
	}
	
	public int updateBoardService(HttpServletRequest request)throws Exception{
		
		request.setCharacterEncoding("utf-8");
		String uploadPath = request.getRealPath("upload");
		int size = 20 * 1024 * 1024;
		
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		
		Board board = new Board();
		board.setB_no(Integer.parseInt(multi.getParameter("b_no")));
		board.setB_title(multi.getParameter("b_title"));
		board.setB_contents(multi.getParameter("b_contents"));
		board.setB_fname(null);
		
		if(multi.getFilesystemName("b_fname")!= null) { 
			String b_fname = multi.getFilesystemName("b_fname"); 
			board.setB_fname(b_fname); 
			
			String pattern = b_fname.substring(b_fname.indexOf(".")+1); 
			String head = b_fname.substring(0,b_fname.indexOf("."));
			
			
			String imagePath = uploadPath + "\\" + b_fname;
			File src = new File(imagePath); 
			
			
			String thumPath = uploadPath + "\\" + head + "_small." + pattern;
			File dest = new File(thumPath); 
			
			if(pattern.equals("gif") || pattern.equals("jpg") || pattern.equals("png")) { 
				ImageUtil.resize(src, dest, 100, ImageUtil.RATIO);
			}
		}

		
		return dao.updateBoard(board);
	}
		
	
	public int deleteBoardService(int b_no)throws Exception{
		return dao.deleteBoard(b_no);
	}
	
	public int deleteReferenceroomService(int b_no)throws Exception{
		return dao.deleteReferenceroom(b_no);
	}
			
		
	
}
