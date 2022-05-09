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
import kosta.action.DeleteScheduleAction;
import kosta.action.MainScheduleAction;
import kosta.action.MoveUpdateAction;
import kosta.action.UpdateScheduleAction;
import kosta.action.InsertScheduleAction;
import kosta.action.DetailScheduleAction;
import kosta.action.InsertScheduleFormAction;
import kosta.action.ListScheduleAction;


@WebServlet("/schedule/*")
public class ScheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ScheduleController() {
        super(); 
    }
    
    public void doProcess(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	String path = request.getRequestURI().trim();
    	String contextPath = request.getContextPath(); // /testGit/schedule/
    	String command = path.substring(contextPath.length()+10);
    	System.out.println(command);
    	
    	Action action = null;
    	ActionForward forward = null;
    	
    	
    	if(command.equals("insertAction.do")) {
    		action = new InsertScheduleAction();
    		System.out.println("컨트롤러");
    		try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("insertForm.do")){
    		action = new InsertScheduleFormAction();
    		try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("moveSchedule.do")) {
    		action = new MainScheduleAction();
    		try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("listAction.do")) {
    		action = new ListScheduleAction();
    		try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("scheduleDetailAction.do")) {
    		action = new DetailScheduleAction();
    		try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("deleteScheduleAction.do")) {
    		action = new DeleteScheduleAction();
    		try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("moveUpdateScheduleAction.do")) {
    		action = new MoveUpdateAction();
    		try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("updateAction.do")) {
    		action = new UpdateScheduleAction();
    		try {
				forward = action.excute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	
    	if(forward != null) {
    		if(forward.isRedirect()) {
    			response.sendRedirect(forward.getPath());
    		}else {
    			RequestDispatcher di =
    					request.getRequestDispatcher(forward.getPath());
    			di.forward(request, response);
    		}
    	}
    }
    


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
