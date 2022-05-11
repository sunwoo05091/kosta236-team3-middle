package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.service.BoardService;

public class DeleteReferenceroomAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		BoardService service = BoardService.getInstance();
		ActionForward forward = new ActionForward();
		
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		
		service.deleteReferenceroomService(b_no); 
		forward.setPath("listReferenceroomAction.do");
		forward.setRedirect(true);
		
		
		return forward;
	}

}
