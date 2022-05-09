package action.MyPage;

import resources.Action;
import resources.ActionForward;
import domain.MyPage_ListDB;
import domain.MyPage_PhoneBook;
import service.MyPageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdatePhoneBook implements Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward actionForward = new ActionForward();
        MyPageService myPageService = MyPageService.getInstance();

        int pb_No = Integer.parseInt(request.getParameter("pb_No"));

        MyPage_PhoneBook phoneBook = new MyPage_PhoneBook();
        phoneBook.setInnerData(request);
        phoneBook.setPb_No(pb_No);

        int result = myPageService.updatePhoneBook(phoneBook);
        MyPage_ListDB listDB = myPageService.listDB("PhoneBook", phoneBook.getE_No(), request);

        request.setAttribute("listPhoneBook", listDB);
        actionForward.setPath("/views/MyPage/ListPhoneBook.jsp");

        return actionForward;
    }
}
