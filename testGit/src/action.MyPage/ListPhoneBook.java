package action.MyPage;

import resources.Action;
import resources.ActionForward;
import domain.MyPage_ListDB;
import service.MyPageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListPhoneBook implements Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        ActionForward actionForward = new ActionForward();
        MyPageService myPageService = MyPageService.getInstance();

        String userId = (String)request.getSession().getAttribute("userId");
        int userNo = (int) request.getSession().getAttribute("userNo");
        MyPage_ListDB listDB = myPageService.listDB("PhoneBook", userNo, request);

        request.setAttribute("listPhoneBook", listDB);

        actionForward.setPath("/views/MyPage/ListPhoneBook.jsp");

        return actionForward;
    }
}
