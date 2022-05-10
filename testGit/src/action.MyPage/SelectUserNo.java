package action.MyPage;

import resources.Action;
import resources.ActionForward;
import domain.MyPage_PrivateInfo;
import service.MyPageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectUserNo implements Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        ActionForward actionForward = new ActionForward();
        MyPageService myPageService = MyPageService.getInstance();

        String userId = (String)request.getSession().getAttribute("userId");
        MyPage_PrivateInfo myPagePrivateInfo = myPageService.getUserInfo(userId);

        request.getSession().setAttribute("userNo", myPagePrivateInfo.getE_No());
        request.getSession().setAttribute("trial", true);

        request.getSession().setAttribute("d_no", myPagePrivateInfo.getD_No());

//        actionForward.setRedirect(false);
        actionForward.setPath((String)request.getSession().getAttribute("exPageURI"));

        return actionForward;
    }
}
