package kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.action.DeleteNoticeAction;
import kosta.action.DeleteReferenceroomAction;
import kosta.action.DetailBoardAction;
import kosta.action.DetailReferenceroomAction;
import kosta.action.InsertBoardAction;
import kosta.action.InsertBoardFormAction;
import kosta.action.InsertMeetingRoomAction;
import kosta.action.InsertMeetingRoomFormAction;
import kosta.action.InsertReferenceroomAction;
import kosta.action.InsertReferenceroomFormAction;
import kosta.action.ListNoticeAction;
import kosta.action.ListReferenceroomAction;
import kosta.action.UpdateBoardAction;
import kosta.action.UpdateBoardFormAction;
import kosta.action.UpdateReferenceroomAction;
import kosta.action.UpdateReferenceroomFormAction;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardController() {
		super();

	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI().trim();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 7);

		System.out.println(requestURI);
		System.out.println(contextPath);

		System.out.println(command);

		Action action = null;
		ActionForward forward = null;

		if (command.equals("insertForm.do")) { //공지사항
			action = new InsertBoardFormAction();
			System.out.println("rqljkrqw");
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("insertAction.do")) { //공지사항
			action = new InsertBoardAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("listNoticeAction.do")) {
			action = new ListNoticeAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("detailBoardAction.do")) {
			action = new DetailBoardAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("updateBoardForm.do")) {
			action = new UpdateBoardFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("updateBoardAction.do")) {
			action = new UpdateBoardAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("deleteNoticeAction.do")) {
			action = new DeleteNoticeAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("listReferenceroomAction.do")) {
			action = new ListReferenceroomAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("insertReferenceroomAction.do")) { //자료실
			action = new InsertReferenceroomAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} 	if (command.equals("insertReferenceroomForm.do")) { //자료실
			action = new InsertReferenceroomFormAction();		
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("deleteReferenceroomAction.do")) {
			action = new DeleteReferenceroomAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		} else if (command.equals("detailReferenceroomAction.do")) {
			action = new DetailReferenceroomAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		} else if (command.equals("updateReferenceroomAction.do")) {
			action = new UpdateReferenceroomAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		} else if (command.equals("updateReferenceroomForm.do")) {
			action = new UpdateReferenceroomFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 

		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}

	}// end doProcess

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
