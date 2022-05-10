package action.MyPage;

import resources.Action;
import resources.ActionForward;
import domain.MyPage_AnnualLeave;
import service.MyPageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReferAnnualLeave implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward actionForward = new ActionForward();
        MyPageService myPageService = MyPageService.getInstance();

        MyPage_AnnualLeave annualLeave = new MyPage_AnnualLeave();
        annualLeave.setInnerData(request);
        annualLeave.setAn_acknowledge("반려");
        myPageService.updateAnnualLeave(annualLeave);

        actionForward.setPath("/mypage/annual-leave");

        return actionForward;
    }
}
