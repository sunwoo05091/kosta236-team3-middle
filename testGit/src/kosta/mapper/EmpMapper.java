package kosta.mapper;

import java.util.List;

import kosta.domain.Emp;
import kosta.domain.Login;

public interface EmpMapper {
	//List<Board> listBoard(Map map);  
//	List<Board> listBoard(Search search, RowBounds row);  
//	int insertBoard(Board board); 
//	Board detailBoard(int seq);
//	int updateBoard(Board board);
//	int deleteBoard(int seq);
//	int countBoard(Search search);
//	int insertReply(Reply reply);
//	List<Reply> listReply(int seq);
	Emp loginEmp(Login login);

	int insertEmp(Emp emp);

	int checkId(String id);

	List<Emp> listSignUpApprove();

	int updateEmp(Emp emp);

	int checkIn(int e_no);
	
	int checkOut(int e_no);

	List<Emp> listEmp(int d_no);
}
