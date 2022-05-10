package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertBoardFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		/* String b_category = request.getParameter("b_category"); */
		/* System.out.println("b_category"+ b_category); */
		forward.setRedirect(false);
		forward.setPath("/insert_boardform.jsp");
		return forward;
	}

}
