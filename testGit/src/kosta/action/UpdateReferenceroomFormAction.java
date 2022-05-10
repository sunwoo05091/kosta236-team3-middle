package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.Board;
import kosta.service.BoardService;

public class UpdateReferenceroomFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		BoardService service = BoardService.getInstance();
		
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		Board board = service.detailBoardService(b_no);
		request.setAttribute("board", board);
		
		forward.setRedirect(false);
		forward.setPath("/updatereferenceroomform.jsp");
		
		return forward;
	}

}
