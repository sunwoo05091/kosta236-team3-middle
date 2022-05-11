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
import kosta.action.DeleteCommunityTradeAction;
import kosta.action.DetailCommunityCarfullAction;
import kosta.action.DetailCommunityClubAction;
import kosta.action.InsertCommunityCarfull;
import kosta.action.InsertCommunityCarfullFormAction;
import kosta.action.InsertCommunityClub;
import kosta.action.InsertCommunityClubFormAction;
import kosta.action.InsertCommunityTrade;
import kosta.action.InsertCommunityTradeFormAction;
import kosta.action.InsertNoticeTrade;
import kosta.action.InsertNoticeTradeFormAction;
import kosta.action.InsertReplyAction;
import kosta.action.ListCommunityAction;
import kosta.action.ListCommunityCarfullAction;
import kosta.action.ListCommunityClubAction;
import kosta.action.UpdateCommunityCarfullAction;
import kosta.action.UpdateCommunityCarfullFormAction;
import kosta.action.UpdateCommunityClubAction;
import kosta.action.UpdateCommunityClubFormAction;
import kosta.action.UpdateCommunityTradeAction;
import kosta.action.UpdateCommunityTradeFormAction;
import kosta.action.DetailCommunityTradeAction;

@WebServlet("/community/*")
public class CommunityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CommunityController() {
        super();
    }
    
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
    	//url 식별
    	String requestURI = request.getRequestURI();  // /MVC/board/list.do
    	String contextPath = request.getContextPath(); 
    	String command = requestURI.substring(contextPath.length()+11);
    	System.out.println(command);
    	
    	
    	Action action = null;
    	ActionForward forward = null;
    	
    	
    	if(command.equals("listCommunityAction.do")) {
    		action = new ListCommunityAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	
    	}else if(command.equals("insertCommunityTradeFormAction.do")) {
    		action = new InsertCommunityTradeFormAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    	}else if(command.equals("insertCommunityAction.do")) {
    		action = new InsertCommunityTrade();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    	}else if(command.equals("detailTradeAction.do")) {
    		action = new DetailCommunityTradeAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    	}else if(command.equals("detailClubAction.do")) {
    		action = new DetailCommunityClubAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    	}else if(command.equals("detailCarfullAction.do")) {
    		action = new DetailCommunityCarfullAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    	}else if(command.equals("updateTradeForm.do")) {
    		action = new UpdateCommunityTradeFormAction();
	    	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
    	}else if(command.equals("updateClubForm.do")) {
    		action = new UpdateCommunityClubFormAction();
	    	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
    	}else if(command.equals("updateCarfullForm.do")) {
    		action = new UpdateCommunityCarfullFormAction();
	    	try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
    	}else if(command.equals("updateTradeAction.do")) {
    		action = new UpdateCommunityTradeAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    	}else if(command.equals("updateClubAction.do")) {
    		action = new UpdateCommunityClubAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    	}else if(command.equals("updateCarfullAction.do")) {
    		action = new UpdateCommunityCarfullAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    	}else if(command.equals("deleteTrade.do")) {
    		action = new DeleteCommunityTradeAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("insertReplyAction.do")) {
    		action = new InsertReplyAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    	}else if(command.equals("listCommunityClubAction.do")) {
    		action = new ListCommunityClubAction();
    		try {
    			forward = action.execute(request, response);
    		} catch (Exception e) {
				e.printStackTrace();
			}
    		
    	}else if(command.equals("insertCommunityClubFormAction.do")) {
    		action = new InsertCommunityClubFormAction();
    		try {
    			forward = action.execute(request, response);
    		} catch (Exception e) {
				e.printStackTrace();
			}
    		
    	}else if(command.equals("insertCommunityClubAction.do")) {
    		action = new InsertCommunityClub();
    		try {
    			forward = action.execute(request, response);
    		} catch (Exception e) {
				e.printStackTrace();
			}
    		
    	}else if(command.equals("listCommunityCarfullAction.do")) {
    		action = new ListCommunityCarfullAction();
    		try {
    			forward = action.execute(request, response);
    		} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("insertCommunityCarfullFormAction.do")) {
    		action = new InsertCommunityCarfullFormAction();
    		try {
    			forward = action.execute(request, response);
    		} catch (Exception e) {
				e.printStackTrace();
			}
    		
    	}else if(command.equals("insertCommunityCarfullAction.do")) {
    		action = new InsertCommunityCarfull();
    		try {
    			forward = action.execute(request, response);
    		} catch (Exception e) {
				e.printStackTrace();
			}
    		
    	}else if(command.equals("insertNoticeTradeAction.do")) {
    		action = new InsertNoticeTrade();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("insertNoticeTradeFormAction.do")) {
    		action = new InsertNoticeTradeFormAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	
    	
    	
    		
    	
    		
    		
    	
    	
    	if(forward != null) {
    		if(forward.isRedirect()) { //redirect
    			response.sendRedirect(forward.getPath());
    		}else { //Dispatcher
    			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
    			dispatcher.forward(request, response);
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
