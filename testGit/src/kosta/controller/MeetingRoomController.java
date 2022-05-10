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
import kosta.action.DeleteReserveAction;
import kosta.action.DetailReserveAction;
import kosta.action.InsertMeetingRoomAction;
import kosta.action.InsertMeetingRoomFormAction;
import kosta.action.ListReserveAction;
import kosta.action.UpdateReserveAction;
import kosta.action.UpdateReserveFormAction;

@WebServlet("/Meetingroom/*")
public class MeetingRoomController extends HttpServlet {
	
		private static final long serialVersionUID = 1L;

		public MeetingRoomController() {
			super();

		}
	
		
		public void doProcess(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String requestURI = request.getRequestURI().trim();
			String contextPath = request.getContextPath();
			String command = requestURI.substring(contextPath.length() + 13);


			System.out.println(command);

			Action action = null;
			ActionForward forward = null;
			
		
		if (command.equals("insertMeetingRoomAction.do")) {
			action = new InsertMeetingRoomAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace(); 
			}

		} else if (command.equals("insertMeetingRoomForm.do")) { 
			System.out.println("qwer");
			action = new InsertMeetingRoomFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		} else if (command.equals("listReserveAction.do")) { 
			action = new ListReserveAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		} else if (command.equals("updateReserveAction.do")) { 
			action = new UpdateReserveAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}  
		} else if (command.equals("updateReserveForm.do")) { 
			action = new UpdateReserveFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}  
		} else if (command.equals("detailReserveAction.do")) { 
			action = new DetailReserveAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}  
		} else if (command.equals("deleteReserveAction.do")) {
			action = new DeleteReserveAction();
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
	}
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doProcess(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doProcess(request, response);
		}
		
}//end class
