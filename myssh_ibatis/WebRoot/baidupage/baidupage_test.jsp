<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'baidupage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <style>
        <!--
            body{
                .p{
                    PADDING-LEFT: 18px; FONT-SIZE: 14px; WORD-SPACING: 4px
                }
            }
        -->
        </style>

  </head>
  
  <body>
  
  <table>
  <c:forEach items="${userMapList}" var="row">         
	<tr class="">  
	<td align="center"><span><c:out value="${row.ID}"/></span></td>  
	  
	<td align="center"><span ><c:out value="${row.NAME}"/></span> </td>  
	  
	<td align="center"><span > <c:out value="${row.PASSWORD}"/></span></td>  
	</tr>  
</c:forEach>
</table>  
<br/>
    <div class="p">
${pageInfo }
        </div>

  </body>
</html>
