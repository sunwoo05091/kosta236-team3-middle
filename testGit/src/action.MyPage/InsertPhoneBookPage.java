package action.MyPage;

import resources.Action;
import resources.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertPhoneBookPage implements Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward actionForward = new ActionForward();

        actionForward.setPath("/views/MyPage/InsertPhoneBook.jsp");

        return actionForward;
    }
}
