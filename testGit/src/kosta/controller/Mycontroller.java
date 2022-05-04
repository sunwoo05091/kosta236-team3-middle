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
import kosta.action.InsertEmpAction;
import kosta.action.InsertEmpFormAction;
import kosta.action.LoginAction;
import kosta.action.LoginFormAction;
import kosta.action.MainAction;

@WebServlet("/Login/*")
public class Mycontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Mycontroller() {
        super();
    }

    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//url식별 => 요청판별
    	String requestURI = request.getRequestURI(); // =>/MVC/board/list.do
    	String command2 = requestURI.substring(requestURI.lastIndexOf("/")+1);
    	
    	Action action = null;
    	ActionForward forward = null;
    	System.out.println(command2);
    	
    	if(command2.equals("loginFormAction.do")) {
    		action = new LoginFormAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command2.equals("insertEmpAction.do")) {
    		action = new InsertEmpAction();
    		try {
    			forward = action.execute(request, response);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}else if(command2.equals("insertEmpFormAction.do")) {
    		action = new InsertEmpFormAction();
    		try {
    			forward = action.execute(request, response);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		
	    }else if(command2.equals("mainAction.do")) {
	    	action = new MainAction();
	    	try {
	    		forward = action.execute(request, response);
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    }else if(command2.equals("loginAction.do")) {
	    	action = new LoginAction();
	    	try {
	    		forward = action.execute(request, response);
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	
//	    }else if(command2.equals("updateAction.do")) {
//	    	action = new UpdateAction();
//	    	try {
//	    		forward = action.execute(request, response);
//	    	} catch (Exception e) {
//	    		e.printStackTrace();
//	    	}
//	    	
//	    }else if(command2.equals("deleteAction.do")) {
//	    	action = new DeleteAction();
//	    	try {
//	    		forward = action.execute(request, response);
//	    	} catch (Exception e) {
//	    		e.printStackTrace();
//	    	}
//	    	
//	    }else if(command2.equals("insertReplyAction.do")) {
//	    	action = new insertReplyAction();
//	    	try {
//	    		forward = action.execute(request, response);
//	    	} catch (Exception e) {
//	    		e.printStackTrace();
//	    	}
	    }
    	if (forward != null) {
    		if(forward.isRedirect()) {//rediect
    			response.sendRedirect(forward.getPath());
    		}else {//Dispatcher
    			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
    			dispatcher.forward(request, response);
    		}
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
