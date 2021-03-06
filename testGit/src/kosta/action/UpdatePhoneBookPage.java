package kosta.action;

import kosta.domain.PhoneBook;
import kosta.service.MyPageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdatePhoneBookPage implements Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward actionForward = new ActionForward();
        MyPageService myPageService = MyPageService.getInstance();

        System.out.println(request.getParameter("pb_No"));

        int pb_No = Integer.parseInt(request.getParameter("pb_No"));

        PhoneBook phoneBook = myPageService.selectPhoneBook(pb_No);
        request.setAttribute("phoneBook", phoneBook);

        actionForward.setPath("/UpdatePhoneBook.jsp");

        return actionForward;
    }
}
