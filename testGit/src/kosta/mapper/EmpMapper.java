package kosta.mapper;

import java.util.List;

import kosta.domain.Emp;
import kosta.domain.Login;

public interface EmpMapper {
	Emp loginEmp(Login login);

	int insertEmp(Emp emp);

	int checkId(String id);

	List<Emp> listSignUpApprove();

	int updateEmp(Emp emp);

	int checkIn(int e_no);
	
	int checkOut(int e_no);

	List<Emp> listEmp(int d_no);
}
