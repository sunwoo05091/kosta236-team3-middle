<%@page import="java.net.URLEncoder"%>
<%@page import="kosta.util.FileDownloadHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
	request.setCharacterEncoding("utf-8");
	response.reset();
	String fileName = request.getParameter("filename");
	
	System.out.println(fileName);
	
	String uploadPath = request.getRealPath("upload");
	String path = uploadPath.trim() + "\\" + fileName.trim();
	
	String fileName2 = URLEncoder.encode(fileName, "UTF-8");
	
	 response.setContentType("application/x-msdownload");
	response.setHeader("Content-Disposition",
						"attachment; filename=\""+ fileName2 + "\"");
	response.setHeader("Content-Transfer-Encoding", "binary");
	response.setHeader("Pragma", "no-cache;");
	response.setHeader("Expires", "-1;");
	
	out.clear();
	out=pageContext.pushBody();
	
	try{
		FileDownloadHelper.copy(path, response.getOutputStream());	
		response.getOutputStream().close();
	}catch(Exception e){
		System.out.println("ok");
		e.printStackTrace();
	}
%>    
    