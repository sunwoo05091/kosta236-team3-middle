package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.Board;
import kosta.domain.BoardDao;
import kosta.service.BoardService;

public class DeleteNoticeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		BoardService service = BoardService.getInstance();
		ActionForward forward = new ActionForward();
		
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		
		service.deleteBoardService(b_no); 
		forward.setPath("listNoticeAction.do");
		forward.setRedirect(true);
		
		
		return forward;
	}

}
