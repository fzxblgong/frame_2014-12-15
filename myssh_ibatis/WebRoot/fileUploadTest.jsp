<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<%
String cp = request.getContextPath();
System.out.println("======="+cp);
 %>
		<h3>文件上传：</h3>
		请选择要上传的文件：<br />
		<form action="<%=cp %>/UploadServlet/fileUpload" method="post"
		                        enctype="multipart/form-data">
		<input type="file" name="file" size="50" />
		<br />
		<input type="submit" value="上传文件" />
		</form>
</body>
</html>