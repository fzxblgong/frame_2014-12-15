<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajaxupload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${pageContext.request.contextPath}/uploadify/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/uploadify/jquery.uploadify.min.js"></script>
	<link href="${pageContext.request.contextPath}/uploadify/uploadify.css" type="text/css" rel="stylesheet">
	<style type="text/css">
body {
	font: 13px Arial, Helvetica, Sans-serif;
}
</style>
	
	<script type="text/javascript">
	$(function() {
			$('#file_upload').uploadify({
				'height'        : 30,
				'width'        : 120,
				'swf'      : '${pageContext.request.contextPath}/uploadify/uploadify.swf',
				'uploader' : '${pageContext.request.contextPath}/file/fileAction.do'
			});
		});
	</script>	
  </head>
  
  <body>
    This is my JSP page. <br>
    ${pageContext.request.contextPath} --
   ${pageContext.request.contextPath}/uploadify/uploadify.swf
    <form name="form">
   		 <div id="queue"></div>
		<input id="file_upload" name="file_upload" type="file" multiple="true"/>
    </form>
  </body>
</html>
