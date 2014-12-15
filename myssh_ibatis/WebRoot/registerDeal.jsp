<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="GB18030"%>
<%@page import="com.ssh.model.User"%>
<%@page import="com.ssh.service.UserManager"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String username=request.getParameter("username");
String pwd=request.getParameter("password");
String pwd2=request.getParameter("password2");


User user =new User();
user.setUserName(username);
user.setPassword(pwd);

UserManager um = new UserManager();
boolean flag = um.userExists(user);
if(flag){
	response.sendRedirect("registerFail.jsp");
	return ;
}
um.addUser(user);
response.sendRedirect("registerSuccess.jsp");
%>

