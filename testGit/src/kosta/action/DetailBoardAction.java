package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.Board;
import kosta.service.BoardService;

public class DetailBoardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardService service = BoardService.getInstance();
		ActionForward forward = new ActionForward();
		
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		Board board = service.detailBoardService(b_no);
		
		request.setAttribute("board", board);
		
		forward.setRedirect(false);
		forward.setPath("/detailboard.jsp");
		
		return forward;
	}

}
