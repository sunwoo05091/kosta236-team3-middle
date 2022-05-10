package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.domain.ListModel;
import kosta.service.BoardService;

public class ListReferenceroomAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardService service = BoardService.getInstance();
		ActionForward forward = new ActionForward();
		/* String b_category = request.getParameter("b_category"); */
		ListModel listModel = service.listReferenceroomService(request);
		/* System.out.println("b_category"+ b_category); */
		request.setAttribute("listModel", listModel);
		
		forward.setPath("/referenceroomlist.jsp"); //?b_category="+ b_category
		forward.setRedirect(false);
		
		
		return forward;
	}

}
