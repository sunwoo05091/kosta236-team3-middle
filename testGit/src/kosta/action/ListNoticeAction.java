package kosta.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.Board;
import kosta.domain.ListModel;
import kosta.service.BoardService;

public class ListNoticeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardService service = BoardService.getInstance();
		ActionForward forward = new ActionForward();
		/* String b_category = request.getParameter("b_category"); */
		ListModel listModel = service.listBoardService(request);
		System.out.println("listModel Action :"+listModel.toString());
		/* System.out.println("b_category"+ b_category); */
		request.setAttribute("listModel", listModel);
		
		forward.setPath("/boardlist.jsp"); //?b_category="+ b_category
		forward.setRedirect(false);
		
		
		return forward;
	}

}
