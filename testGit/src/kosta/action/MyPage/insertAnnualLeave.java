package kosta.action.MyPage;

import kosta.domain.MyPage.AnnualLeave;
import kosta.service.MyPageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class insertAnnualLeave implements Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward actionForward = new ActionForward();
        MyPageService myPageService = MyPageService.getInstance();

        AnnualLeave annualLeave = new AnnualLeave();
        annualLeave.setInnerData(request);
        int result =  myPageService.insertAnnualLeave(annualLeave);
        System.out.println("inserannual-leave result : " + result);
        actionForward.setPath("/mypage/annual-leave");

        return actionForward;
    }
}
