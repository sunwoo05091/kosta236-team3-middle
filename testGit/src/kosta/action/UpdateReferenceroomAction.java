package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.service.BoardService;

public class UpdateReferenceroomAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardService service = BoardService.getInstance();
		ActionForward forward = new ActionForward();
		
		service.updateBoardService(request);
		
		forward.setPath("listReferenceroomAction.do");
		forward.setRedirect(true);
		return forward;
	}

}
