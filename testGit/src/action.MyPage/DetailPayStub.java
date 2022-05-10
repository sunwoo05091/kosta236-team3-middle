package action.MyPage;

import resources.Action;
import resources.ActionForward;
import domain.MyPage_PayStub;
import domain.MyPage_PrivateInfo;
import service.MyPageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetailPayStub implements Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        ActionForward actionForward = new ActionForward();
        MyPageService myPageService = MyPageService.getInstance();

        String userId = (String)request.getSession().getAttribute("userId");

        MyPage_PrivateInfo privateInfo = myPageService.getUserInfo(userId);

        int p_No = Integer.parseInt(request.getParameter("p_No"));

        MyPage_PayStub detailPayStub = myPageService.detailPayStub(p_No);
        System.out.println(detailPayStub.toString());
        detailPayStub.makeDetail();

        request.setAttribute("privateInfo", privateInfo);
        request.setAttribute("detailPayStub", detailPayStub);
        actionForward.setPath("/views/MyPage/DetailPayStub.jsp");

        System.out.println(detailPayStub.getIncomeTax());

        return actionForward;
    }


}
