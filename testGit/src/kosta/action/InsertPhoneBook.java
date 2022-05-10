package kosta.action;

import kosta.domain.PhoneBook;
import kosta.service.MyPageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertPhoneBook implements Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward actionForward = new ActionForward();
        MyPageService myPageService = MyPageService.getInstance();

        request.setCharacterEncoding("UTF-8");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.setInnerData(request);
        System.out.println("update : " + request.getParameter("pb_Email"));


        int result =  myPageService.insertPhoneBook(phoneBook);
        System.out.println("inserPhoneBook result : " + result);
        actionForward.setPath("phonebook.do");

        return actionForward;
    }
}
