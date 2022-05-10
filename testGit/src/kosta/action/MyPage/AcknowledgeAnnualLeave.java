package kosta.action.MyPage;

import kosta.domain.MyPage.AnnualLeave;
import kosta.service.MyPageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AcknowledgeAnnualLeave implements Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward actionForward = new ActionForward();
        MyPageService myPageService = MyPageService.getInstance();

        AnnualLeave annualLeave = new AnnualLeave();
        annualLeave.setInnerData(request);
        annualLeave.setAn_acknowledge("승인");
        myPageService.updateAnnualLeave(annualLeave);
        actionForward.setPath("annual-leave");

        return actionForward;
    }
}
