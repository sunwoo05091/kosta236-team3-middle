package kosta.action;

import kosta.domain.ListDB;
import kosta.service.MyPageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListAttendance implements Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        ActionForward actionForward = new ActionForward();
        MyPageService myPageService = MyPageService.getInstance();

        int userNo = (int) request.getSession().getAttribute("userNo");

        ListDB listDB = myPageService.listDB("Attendance", userNo, request);

        request.setAttribute("listAttendance", listDB);

        actionForward.setRedirect(false);
        actionForward.setPath("/ListAttendance.jsp");

        return actionForward;
    }
}
