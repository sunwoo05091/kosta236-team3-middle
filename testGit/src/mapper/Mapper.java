package mapper;

import domain.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface Mapper {
    List<MyPage_Attendance> listAttendance(int e_no, RowBounds rowBounds);

    MyPage_PrivateInfo getUserInfo(String userId);

    List<MyPage_PayStub> listPayStub(int e_no, RowBounds rowBounds);

    int insertPayStub(MyPage_PayStub myPagePayStub);

    MyPage_PayStub detailPayStub(int p_no);

    List<MyPage_PhoneBook> listPhoneBook(int e_no, RowBounds rowBounds);

    int insertPhoneBook(MyPage_PhoneBook phoneBook);

    int maxPb_No();

    MyPage_PhoneBook selectPhoneBook(int pb_no);

    int updatePhoneBook(MyPage_PhoneBook phoneBook);

    int countRow(int e_no, String tableName);

    int updatePrivateInfo(MyPage_PrivateInfo privateInfo);

    int deletePhoneBook(int pb_no);

    List<MyPage_AnnualLeave> listAnnualLeave(int e_no, RowBounds rowBounds);

    int maxAn_no();

    int insertAnnualLeave(MyPage_AnnualLeave annualLeave);

    List<MyPage_AnnualLeave> listAnnualLeaveByAdmin(RowBounds rowBounds);

    int updateAnnualLeave(MyPage_AnnualLeave annualLeave);

    int countRowByAdmin(String tableName);
}
