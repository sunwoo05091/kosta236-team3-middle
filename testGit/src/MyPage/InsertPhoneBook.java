package action.MyPage;

import resources.Action;
import resources.ActionForward;
import domain.MyPage_PhoneBook;
import service.MyPageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertPhoneBook implements Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward actionForward = new ActionForward();
        MyPageService myPageService = MyPageService.getInstance();


        MyPage_PhoneBook phoneBook = new MyPage_PhoneBook();
        phoneBook.setInnerData(request);

        int result =  myPageService.insertPhoneBook(phoneBook);
        System.out.println("inserPhoneBook result : " + result);
        actionForward.setPath("/mypage/phonebook");

        return actionForward;
    }
}
