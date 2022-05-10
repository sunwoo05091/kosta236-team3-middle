package kosta.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kosta.domain.Emp;
import kosta.domain.Login;
import kosta.domain.LoginDao;

public class LoginService {
	private static LoginService service = new LoginService();
	private static LoginDao dao;
	
	public static LoginService getInstance() {
		dao = LoginDao.getInstance();
		return service;
	}
	
	public Emp loginService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		Login login = new Login();
		login.setId(request.getParameter("id"));
		login.setPass(request.getParameter("pass"));
		session.setAttribute("log", login);
		
		return dao.loginEmp(login);
	}
	
	public int insertEmpService(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		Emp emp = new Emp();
		
		int check = dao.checkId(request.getParameter("id"));
		if(check > 0) {
			return 0;
		}else {
			
			emp.setId(request.getParameter("id"));
			emp.setPass(request.getParameter("pass"));
			emp.setName(request.getParameter("name"));
			emp.setE_no(Integer.parseInt(request.getParameter("e_no")));
			emp.setPhone_number(request.getParameter("phone_number"));
			
			return dao.insertEmp(emp);
		}
	}

	public Emp mainService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("log"));
		return null;
	}

	public List<Emp> listSignUpApproveAction() {
		return dao.listSignUpApprove();
	}

	public int updateEmpService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		Emp emp = new Emp();
		System.out.println(request.getParameter("e_no"));
		emp.setE_no(Integer.parseInt(request.getParameter("e_no")));
		emp.setHiredate(request.getParameter("hiredate"));
		emp.setBasepay(Integer.parseInt(request.getParameter("basepay")));
		int d_no = 0;
		switch (request.getParameter("dep")) {
		case "인사":
			d_no = 1;
			break;
		case "영업":
			d_no = 2;
			break;
		case "개발":
			d_no = 3;
			break;
		case "입원":
			d_no = 4;
			break;
		case "총무":
			d_no = 5;
			break;
		}
		emp.setD_no(d_no);
		emp.setGrade(request.getParameter("grade"));
		emp.setSignupcheck(1);
		
		return dao.updateEmp(emp);
	}

	public int checkInService(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		int e_no = Integer.parseInt(request.getParameter("e_no")); 
		return dao.checkIn(e_no);
	}

	public int checkOutService(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		int e_no = Integer.parseInt(request.getParameter("e_no"));
		return dao.checkOut(e_no);
	}

	public List<Emp> listEmpService(int d_no) {
		return dao.listEmp(d_no);
	}
	
//	public int insertBoardService(HttpServletRequest request) throws Exception{
//		request.setCharacterEncoding("utf-8");
//		
//		//파일업로드 로직
//		//업로드경로, 파일크기, 인코딩방식, 파일이름중첩에대한 정책
//		String uploadPath = request.getRealPath("upload");
//		int size = 20 * 1024 * 1024; // 20MB
//		
//		//파일 업로드가 완료
//		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy()); //파일업로드의 역할
//		
//		Board board = new Board();
//		board.setTitle(multi.getParameter("title"));
//		board.setWriter(multi.getParameter("writer"));
//		board.setContents(multi.getParameter("contents"));
//		board.setFname("");
//		
//		//파일 업로드 했을때
//		if(multi.getFilesystemName("fname") != null) {
//			String fname = multi.getFilesystemName("fname");
//			board.setFname(fname);
//			
//			//썸네일 이미지(gif, jpg, png) aa.jpg => aa_small.jpg
//			String pattern = fname.substring(fname.indexOf(".")+1);
//			String head = fname.substring(0,fname.indexOf("."));
//			
//			//원본파일 객체
//			String imagePath = uploadPath+"\\"+fname;
//			File src = new File(imagePath);
//			
//			//썸네일 파일 객체
//			String thumPath = uploadPath + "\\" +head+"_small."+pattern;
//			File dest = new File(thumPath);
//			
//			if(pattern.equals("gif")||pattern.equals("jpg")||pattern.equals("png")) {
//				ImageUtil.resize(src, dest, 100, ImageUtil.RATIO);
//			}
//		}
//		
//		return dao.insertBoard(board);
//	}
//	
//	public ListModel listBoardService(HttpServletRequest request) throws Exception {
//		
//		//검색 관련 내용
//		Search search = new Search();
//		HttpSession session = request.getSession();
//		
//		//새로운 검색을 할 경우
//		if(request.getParameterValues("area") != null) {
//			session.removeAttribute("search");
//			search.setArea(request.getParameterValues("area"));
//			search.setSearchKey("%" + request.getParameter("searchKey") + "%");
//			session.setAttribute("search", search);
//		}//체크해제 후 검색 버튼만 클릭
//		else if(request.getParameterValues("area") == null && request.getParameter("pageNum") == null) {
//			session.removeAttribute("search");
//		}
//		
//		//세션에 검색 정보가 있는 경우
//		if(session.getAttribute("search") != null) {
//			search = (Search) session.getAttribute("search");
//		}
//		
//		//페이징 처리시 필요한 사항
//		//페이지당 글개수, 총 글개수, 총페이지
//		//startPage, endPage, startRow, endRow
//		
//		//총 글개수
//		int totalCount = dao.countBoard(search);
//		
//		//총페이지수
//		int totalPageCount = totalCount/PAGE_SIZE;
//		if (totalCount % PAGE_SIZE > 0) {
//			totalPageCount++;
//		}
//		
//		//현재페이지
//		String pageNum = request.getParameter("pageNum");
//		if(pageNum == null) {
//			pageNum = "1";
//		}
//		int requestPage = Integer.parseInt(pageNum);
//		
//		//startPage = 현재페이지 - (현재페이지 - 1) % 5
//		int startPage = requestPage - (requestPage - 1) % 5;
//		
//		//endPage
//		int endPage = startPage + 4;
//		if(endPage > totalPageCount) {
//			endPage = totalPageCount;
//		}
//		
//		//startRow = (현재페이지 - 1) * 페이지당 글개수
//		int startRow = (requestPage - 1) * PAGE_SIZE;
//		
//		List<Board> list = dao.listBoard(startRow, search);
//		
//		ListModel listModel = new ListModel(list, requestPage, totalPageCount, startPage, endPage);
//		
//		return listModel;
//	}
//	
//	public Board detailBoardService(int seq) throws Exception{
//		return dao.detailBoard(seq);
//	}
//	
//	public int updateBoardService(HttpServletRequest request) throws Exception{
//		request.setCharacterEncoding("utf-8");
//		Board board = new Board();
//		board.setSeq(Integer.parseInt(request.getParameter("seq")));
//		board.setTitle(request.getParameter("title"));
//		board.setContents(request.getParameter("contents"));
//		
//		return dao.updateBoard(board);
//	}
//	
//	public int deleteBoardService(int seq) throws Exception{
//		return dao.deleteBoard(seq);
//	}
//	
//	public int insertReplyService(HttpServletRequest request) throws Exception{
//		request.setCharacterEncoding("utf-8");
//		Reply reply = new Reply();
//		reply.setR_title(request.getParameter("r_title"));
//		reply.setR_writer(request.getParameter("r_writer"));
//		reply.setR_contents(request.getParameter("r_contents"));
//		reply.setSeq(Integer.parseInt(request.getParameter("seq")));
//		
//		return dao.insertReply(reply);
//	}
//
//	public List<Reply> listReplyService(int seq) {
//		List<Reply> replyList = dao.listReply(seq);
//		return replyList;
//	}

}
