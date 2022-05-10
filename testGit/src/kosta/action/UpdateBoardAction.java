package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.Board;
import kosta.service.BoardService;

public class UpdateBoardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardService service = BoardService.getInstance();
		ActionForward forward = new ActionForward();
		
		service.updateBoardService(request);
		
		forward.setPath("listNoticeAction.do");
		forward.setRedirect(true);
		return forward;
	}

}
