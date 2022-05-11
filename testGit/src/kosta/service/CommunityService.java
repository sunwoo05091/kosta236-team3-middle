package kosta.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.domain.Community;
import kosta.domain.CommunityDao;
import kosta.domain.CommunityListModel;
import kosta.domain.Reply;
import kosta.domain.Search;
import kosta.util.ImageUtil;

public class CommunityService {
	private static CommunityService service = new CommunityService();
	private static CommunityDao dao;
	private static final int PAGE_SIZE = 10;
	
	public static CommunityService getInstance() {
		dao = CommunityDao.getInstance();
		return service;
	}

	public CommunityListModel listCommunityService(HttpServletRequest request)throws Exception{
		Search search = new Search();
		HttpSession session = request.getSession();
		
		if(request.getParameter("area") != null) {
			session.removeAttribute("search");
			search.setArea(request.getParameterValues("area"));
			search.setSearchKey("%" + request.getParameter("searchKey") + "%");
			session.setAttribute("search", search);
			
		}
		//체크해제 후 검색버튼만 클릭
		else if(request.getParameterValues("area") != null
				&& request.getParameter("pageNum") == null) {
			session.removeAttribute("search");
		}
		
		//세션에서 검색 정보가 있는 경우
		if(session.getAttribute("search") != null) {
			search = (Search)session.getAttribute("search");
		}
		
		//총 글 갯수
		int totalCount = dao.countTrade(search);
		System.out.println("중고거래 갯수 : " + totalCount);
		
		//총 페이지수
		int totalPageCount = totalCount/PAGE_SIZE;
		
		//나머지 처리
		if(totalCount%PAGE_SIZE > 0) {
			totalPageCount++;
		}
		
		//현재 페이지
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}

		int requestPage = Integer.parseInt(pageNum);
		
		//startPage = 현재페이지 - (현재페이지 - 1) % 5
		int startPage = requestPage - (requestPage - 1) % 5;
		
		//endPage 
		int endPage = startPage + 4;
		if(endPage > totalPageCount) {
			endPage = totalPageCount;
		}
		
		//startRow = (현재페이지 - 1) * 페이지당 글 갯수
		int startRow = (requestPage - 1) * PAGE_SIZE;
		
		List<Community> list = dao.listCommunity(startRow, search);
		CommunityListModel listModel = new CommunityListModel(list, requestPage, totalPageCount, startPage, endPage);
		
		return listModel;
		
	}
	public CommunityListModel listCommunityClubService(HttpServletRequest request)throws Exception{
		Search search = new Search();
		HttpSession session = request.getSession();
		
		if(request.getParameter("area") != null) {
			session.removeAttribute("search");
			search.setArea(request.getParameterValues("area"));
			search.setSearchKey("%" + request.getParameter("searchKey") + "%");
			session.setAttribute("search", search);
			
		}
		//체크해제 후 검색버튼만 클릭
		else if(request.getParameterValues("area") != null
				&& request.getParameter("pageNum") == null) {
			session.removeAttribute("search");
		}
		
		//세션에서 검색 정보가 있는 경우
		if(session.getAttribute("search") != null) {
			search = (Search)session.getAttribute("search");
		}
		
		//총 글 갯수
		int totalCount = dao.countClub(search);
		System.out.println("동아리 갯수 : " + totalCount);
		
		//총 페이지수
		int totalPageCount = totalCount/PAGE_SIZE;
		System.out.println("페이지 갯수 : " + PAGE_SIZE);
		
		//나머지 처리
		if(totalCount%PAGE_SIZE > 0) {
			totalPageCount++;
		}
		
		//현재 페이지
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}

		int requestPage = Integer.parseInt(pageNum);
		
		//startPage = 현재페이지 - (현재페이지 - 1) % 5
		int startPage = requestPage - (requestPage - 1) % 5;
		
		//endPage 
		int endPage = startPage + 4;
		if(endPage > totalPageCount) {
			endPage = totalPageCount;
		}
		
		//startRow = (현재페이지 - 1) * 페이지당 글 갯수
		int startRow = (requestPage - 1) * PAGE_SIZE;
		
		List<Community> list = dao.listCommunityClub(startRow, search);
		CommunityListModel listModel = new CommunityListModel(list, requestPage, totalPageCount, startPage, endPage);
		
		return listModel;
	}
	
	public CommunityListModel listCommunityCarfullService(HttpServletRequest request)throws Exception{
		Search search = new Search();
		HttpSession session = request.getSession();
		
		if(request.getParameter("area") != null) {
			session.removeAttribute("search");
			search.setArea(request.getParameterValues("area"));
			search.setSearchKey("%" + request.getParameter("searchKey") + "%");
			session.setAttribute("search", search);
			
		}
		//체크해제 후 검색버튼만 클릭
		else if(request.getParameterValues("area") != null
				&& request.getParameter("pageNum") == null) {
			session.removeAttribute("search");
		}
		
		//세션에서 검색 정보가 있는 경우
		if(session.getAttribute("search") != null) {
			search = (Search)session.getAttribute("search");
		}
		
		//총 글 갯수
		int totalCount = dao.countCarfull(search);
		System.out.println(totalCount);
		
		//총 페이지수
		int totalPageCount = totalCount/PAGE_SIZE;
		
		//나머지 처리
		if(totalCount%PAGE_SIZE > 0) {
			totalPageCount++;
		}
		
		//현재 페이지
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}

		int requestPage = Integer.parseInt(pageNum);
		
		//startPage = 현재페이지 - (현재페이지 - 1) % 5
		int startPage = requestPage - (requestPage - 1) % 5;
		
		//endPage 
		int endPage = startPage + 4;
		if(endPage > totalPageCount) {
			endPage = totalPageCount;
		}
		
		//startRow = (현재페이지 - 1) * 페이지당 글 갯수
		int startRow = (requestPage - 1) * PAGE_SIZE;
		
		List<Community> list = dao.listCommunityCarfull(startRow, search);
		CommunityListModel listModel = new CommunityListModel(list, requestPage, totalPageCount, startPage, endPage);
		
		return listModel;
	}
	
	public int insertCommunityTradeService(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		
		String uploadPath = request.getRealPath("upload");
		int size = 20 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		
		Community community = new Community();
		community.setCm_title(multi.getParameter("cm_title"));
		community.setCm_price(multi.getParameter("cm_price"));
		community.setCm_contents(multi.getParameter("cm_contents"));
		community.setCm_fname("");
		
		if(multi.getFilesystemName("cm_fname") != null) {
			String cm_fname = (String)multi.getFilesystemName("cm_fname");
			community.setCm_fname(cm_fname);
			
			//썸네일 이미지(gif,jpg,png) aa.jpg => aa_small.jpg
			String pattern = cm_fname.substring(cm_fname.indexOf(".")+1);//gif, jpg, png
			String head = cm_fname.substring(0, cm_fname.indexOf("."));//aa
			
			//원본 파일 객체
			String imagePath = uploadPath + "\\" + cm_fname;
			File src = new File(imagePath);
			
			//썸네일 파일 객체
			String thumPath = uploadPath + "\\" + head + "_small." + pattern;
			File dest = new File(thumPath);
			
			if(pattern.equals("gif") || pattern.equals("jpg") || pattern.equals("png")) {
				ImageUtil.resize(src, dest, 100, ImageUtil.RATIO);
			}
		}
		
		return dao.insertCommunityTrade(community);
	}
	
	public int insertCommunityClubService(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		
		String uploadPath = request.getRealPath("upload");
		int size = 20 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		
		Community community = new Community();
		community.setCm_title(multi.getParameter("cm_title"));
		community.setCm_contents(multi.getParameter("cm_contents"));
		community.setCm_fname("");
		System.out.println(community);
		
		if(multi.getFilesystemName("cm_fname") != null) {
			String cm_fname = (String)multi.getFilesystemName("cm_fname");
			community.setCm_fname(cm_fname);
			
			//썸네일 이미지(gif,jpg,png) aa.jpg => aa_small.jpg
			String pattern = cm_fname.substring(cm_fname.indexOf(".")+1);//gif, jpg, png
			String head = cm_fname.substring(0, cm_fname.indexOf("."));//aa
			
			//원본 파일 객체
			String imagePath = uploadPath + "\\" + cm_fname;
			File src = new File(imagePath);
			
			//썸네일 파일 객체
			String thumPath = uploadPath + "\\" + head + "_small." + pattern;
			File dest = new File(thumPath);
			
			if(pattern.equals("gif") || pattern.equals("jpg") || pattern.equals("png")) {
				ImageUtil.resize(src, dest, 100, ImageUtil.RATIO);
			}
		}
		
		return dao.insertCommunityClub(community);
	}
	
	public int insertNoticeTradeService(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		
		
		Community community = new Community();
		community.setCm_title(request.getParameter("cm_title"));
		community.setCm_contents(request.getParameter("cm_contents"));
		
		return dao.insertNoticeTrade(community);
	}
	
	public int insertNoticeClubService(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		
		String uploadPath = request.getRealPath("upload");
		int size = 20 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		
		Community community = new Community();
		community.setCm_title(multi.getParameter("cm_title"));
		community.setCm_contents(multi.getParameter("cm_contents"));
		community.setCm_fname("");
		System.out.println(community);
		
		if(multi.getFilesystemName("cm_fname") != null) {
			String cm_fname = (String)multi.getFilesystemName("cm_fname");
			community.setCm_fname(cm_fname);
			
			//썸네일 이미지(gif,jpg,png) aa.jpg => aa_small.jpg
			String pattern = cm_fname.substring(cm_fname.indexOf(".")+1);//gif, jpg, png
			String head = cm_fname.substring(0, cm_fname.indexOf("."));//aa
			
			//원본 파일 객체
			String imagePath = uploadPath + "\\" + cm_fname;
			File src = new File(imagePath);
			
			//썸네일 파일 객체
			String thumPath = uploadPath + "\\" + head + "_small." + pattern;
			File dest = new File(thumPath);
			
			if(pattern.equals("gif") || pattern.equals("jpg") || pattern.equals("png")) {
				ImageUtil.resize(src, dest, 100, ImageUtil.RATIO);
			}
		}
		
		return dao.insertNoticeClub(community);
	}
	
	public int insertNoticeCarfullService(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		
		String uploadPath = request.getRealPath("upload");
		int size = 20 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		
		Community community = new Community();
		community.setCm_title(multi.getParameter("cm_title"));
		community.setCm_contents(multi.getParameter("cm_contents"));
		community.setCm_fname("");
		System.out.println(community);
		
		if(multi.getFilesystemName("cm_fname") != null) {
			String cm_fname = (String)multi.getFilesystemName("cm_fname");
			community.setCm_fname(cm_fname);
			
			//썸네일 이미지(gif,jpg,png) aa.jpg => aa_small.jpg
			String pattern = cm_fname.substring(cm_fname.indexOf(".")+1);//gif, jpg, png
			String head = cm_fname.substring(0, cm_fname.indexOf("."));//aa
			
			//원본 파일 객체
			String imagePath = uploadPath + "\\" + cm_fname;
			File src = new File(imagePath);
			
			//썸네일 파일 객체
			String thumPath = uploadPath + "\\" + head + "_small." + pattern;
			File dest = new File(thumPath);
			
			if(pattern.equals("gif") || pattern.equals("jpg") || pattern.equals("png")) {
				ImageUtil.resize(src, dest, 100, ImageUtil.RATIO);
			}
		}
		
		return dao.insertNoticeCarfull(community);
	}
	
	public int insertCommunityCarfullService(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		
		Community community = new Community();
		community.setCm_title(request.getParameter("cm_title"));
		community.setCm_contents(request.getParameter("cm_contents"));
		
		
		return dao.insertCommunityCarfull(community);
	}
	
	public Community detailCommunityTradeService(int cm_no)throws Exception {
		return dao.detailCommunityTrade(cm_no);
	}
	
	public int updateCommunityTradeService(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		String uploadPath = request.getRealPath("upload");
		int size = 20 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		Community community = new Community();
		community.setCm_no(Integer.parseInt(multi.getParameter("cm_no")));
		System.out.println("test");
		System.out.println(multi.getParameter("cm_no"));
		community.setCm_title(multi.getParameter("cm_title"));
		community.setCm_price(multi.getParameter("cm_price"));
		community.setCm_contents(multi.getParameter("cm_contents"));
		community.setCm_state(multi.getParameter("cm_state"));
		community.setCm_fname(null);
		
		if(multi.getFilesystemName("cm_fname") != null) {
			community.setCm_fname(multi.getFilesystemName("cm_fname"));
		}
		
		System.out.println(community.getCm_fname());
		
		
		
		
		return dao.updateCommunityTrade(community);
	}
	
	public int updateCommunityClubService(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		String uploadPath = request.getRealPath("upload");
		int size = 20 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		Community community = new Community();
		community.setCm_no(Integer.parseInt(multi.getParameter("cm_no")));
		community.setCm_title(multi.getParameter("cm_title"));
		community.setCm_contents(multi.getParameter("cm_contents"));
		community.setCm_state(multi.getParameter("cm_state"));
		community.setCm_fname(null);
		
		if(multi.getFilesystemName("cm_fname") != null) {
			community.setCm_fname(multi.getFilesystemName("cm_fname"));
		}
		
		System.out.println(community.getCm_fname());
		
		
		
		
		return dao.updateCommunityClub(community);
	}
	
	public int updateCommunityCarfullService(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		
		Community community = new Community();
		community.setCm_no(Integer.parseInt(request.getParameter("cm_no")));
		community.setCm_title(request.getParameter("cm_title"));
		community.setCm_contents(request.getParameter("cm_contents"));
		community.setCm_state(request.getParameter("cm_state"));
		
		
		return dao.updateCommunityCarfull(community);
	}
	public int deleteCommunityTradeService(HttpServletRequest request)throws Exception{
		
		Community community = new Community();
		community.setCm_no(Integer.parseInt(request.getParameter("cm_no")));
		
		return dao.deleteCommunityTrade(community);
	}
	
	public int insertReplyService(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		Reply reply = new Reply();
		reply.setCm_r_contents(request.getParameter("cm_r_contents"));
		reply.setCm_no(Integer.parseInt(request.getParameter("cm_no")));
		
		return dao.insertReply(reply);
	}
	
	public List<Reply> listReplyService(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		int cm_no = Integer.parseInt(request.getParameter("cm_no"));
		
		List<Reply> list = dao.listReply(cm_no);
		
		return list;
	}
	
	public List<Community> noticeCommunityService(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		List<Community> notice = dao.noticeCommunity();
		
		return notice;
	}
	
}
