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
import kosta.action.DeleteDocumentAction;
import kosta.action.DetailDocumentAction;
import kosta.action.InsertDocumentAction;
import kosta.action.InsertDocumentFormAction;
import kosta.action.InsertSignEmpAction;
import kosta.action.ListDocumentAction;
import kosta.action.ListDocumentSignCompanionAction;
import kosta.action.ListDocumentSignCompleteAction;
import kosta.action.ListDocumentSignCompleteDepartmentAction;
import kosta.action.ListDocumentSignProgressAction;
import kosta.action.UpdateDocumentAction;
import kosta.action.UpdateDocumentFormAction;

@WebServlet("/document/*")
public class DocumentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DocumentController() {
        super();

    }
    
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String command = requestURI.substring(contextPath.length()+10);
    	System.out.println(command);		
    	
    	// 액션
    	Action action = null;
    	ActionForward forward = null;
    	
    	
    	// 문서 작성폼
    	if (command.equals("insertForm.do")) {		// 홈페이지로 가고 싶다.
    		action = new InsertDocumentFormAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	
    	// 값 넘기기
		}else if (command.equals("insertAction.do")) {
			action = new InsertDocumentAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
       // 목록
    	}else if (command.equals("listAction.do")) {
    		action = new ListDocumentAction();
        	try {
    			forward = action.execute(request, response);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
        
        // 상세보기
    	}else if(command.equals("detailAction.do")) {
    		action = new DetailDocumentAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	
    	// 문서 수정폼
    	}else if(command.equals("updateForm.do")) {
    		action = new UpdateDocumentFormAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	
    	// 문서 수정 후 넘기기
    	}else if(command.equals("updateAction.do")) {
    		action = new UpdateDocumentAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    	// 문서 삭제
    	}else if(command.equals("deleteAction.do")) {
    		action = new DeleteDocumentAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    	// 결재 진행 문서함
    	}else if (command.equals("listDocumentSignProgressAction.do")) {
    	    action = new ListDocumentSignProgressAction();
    	    try {
    	    	forward = action.execute(request, response);
    	    } catch (Exception e) {
    	    	e.printStackTrace();
    	    }
    	        	
    	// 결재 완료 문서함
    	}else if (command.equals("listDocumentSignCompleteAction.do")) {
    	    action = new ListDocumentSignCompleteAction();
    	    try {
    	    	forward = action.execute(request, response);
    	    } catch (Exception e) {
    	    	e.printStackTrace();
    	    }
    	        	
    	 // 반려 문서함
    	 }else if (command.equals("listDocumentSignCompanionAction.do")) {
    	    	action = new ListDocumentSignCompanionAction();
    	    try {
    	    		forward = action.execute(request, response);
    	    } catch (Exception e) {
    	    	e.printStackTrace();
    	    }
    	    
       	 // 부서 문서함
       	 }else if (command.equals("listDocumentSignCompleteDepartmentAction.do")) {
       	    	action = new ListDocumentSignCompleteDepartmentAction();
       	    try {
       	    		forward = action.execute(request, response);
       	    } catch (Exception e) {
       	    	e.printStackTrace();
       	    }
       	    
        // 결재선 추가
        if (command.equals("insertSignEmpAction.do")) {
        	action = new InsertSignEmpAction();
        try {
    			forward = action.execute(request, response);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
             		
        }
        		
		}
    	

    	
    	
    	
     // 전체적인 이동에 관한 코드
    	if (forward != null) {
			if (forward.isRedirect()) {		// redirect
				response.sendRedirect(forward.getPath());
				
			}else{		// Dispatcher
				RequestDispatcher dispatcher =
								request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
    	
	}
    	
    
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		doProcess(request, response);	// 메서드 호출
    		
    	}


    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		doProcess(request, response);	// 메서드 호출
    		
    	}

    }
    	
