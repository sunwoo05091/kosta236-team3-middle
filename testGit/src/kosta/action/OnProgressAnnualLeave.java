package kosta.action;

import kosta.domain.AnnualLeave;
import kosta.service.MyPageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OnProgressAnnualLeave implements Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward actionForward = new ActionForward();
        MyPageService myPageService = MyPageService.getInstance();

        AnnualLeave annualLeave = new AnnualLeave();
        annualLeave.setInnerData(request);
        annualLeave.setAn_acknowledge("처리중");
        myPageService.updateAnnualLeave(annualLeave);
        actionForward.setPath("annual-leave.do");

        return actionForward;
    }
}
