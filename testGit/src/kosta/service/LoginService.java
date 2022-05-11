package kosta.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kosta.domain.Emp;
import kosta.domain.Login;
import kosta.domain.LoginDao;

public class LoginService {
	private static LoginService service = new LoginService();
	private static LoginDao dao;
	
	public static LoginService getInstance() {
		dao = LoginDao.getInstance();
		return service;
	}
	
	public Emp loginService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		Login login = new Login();
		login.setId(request.getParameter("id"));
		login.setPass(request.getParameter("pass"));
		session.setAttribute("log", login);
		
		return dao.loginEmp(login);
	}
	
	public int insertEmpService(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		Emp emp = new Emp();
		
		int check = dao.checkId(request.getParameter("id"));
		if(check > 0) {
			return 0;
		}else {
			
			emp.setId(request.getParameter("id"));
			emp.setPass(request.getParameter("pass"));
			emp.setName(request.getParameter("name"));
			emp.setE_no(Integer.parseInt(request.getParameter("e_no")));
			emp.setPhone_number(request.getParameter("phone_number"));
			
			return dao.insertEmp(emp);
		}
	}

	public Emp mainService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("log"));
		return null;
	}

	public List<Emp> listSignUpApproveAction() {
		return dao.listSignUpApprove();
	}

	public int updateEmpService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		Emp emp = new Emp();
		System.out.println(request.getParameter("e_no"));
		emp.setE_no(Integer.parseInt(request.getParameter("e_no")));
		emp.setHiredate(request.getParameter("hiredate"));
		int d_no = 0;
		switch (request.getParameter("dep")) {
		case "인사":
			d_no = 1;
			break;
		case "영업":
			d_no = 2;
			break;
		case "개발":
			d_no = 3;
			break;
		case "입원":
			d_no = 4;
			break;
		case "총무":
			d_no = 5;
			break;
		}
		emp.setD_no(d_no);
		emp.setGrade(request.getParameter("grade"));
		emp.setSignupcheck(1);
		
		return dao.updateEmp(emp);
	}

	public int checkInService(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		int e_no = Integer.parseInt(request.getParameter("e_no")); 
		return dao.checkIn(e_no);
	}

	public int checkOutService(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		int e_no = Integer.parseInt(request.getParameter("e_no"));
		return dao.checkOut(e_no);
	}

	public List<Emp> listEmpService(int d_no) {
		return dao.listEmp(d_no);
	}
	

}
