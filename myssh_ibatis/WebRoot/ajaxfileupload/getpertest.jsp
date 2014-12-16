<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'othertest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${pageContext.request.contextPath}/ajaxfileupload/jquery.js"></script>
	<script type="text/javascript">
		var interval;
		function getPer(){
			//var per = $.ajax({url:"${pageContext.request.contextPath}/file/getPer.do",async:false});
			  $.ajax({
	            type: "GET",
	            async:false,
	                dateType:"html",
	                url: "${pageContext.request.contextPath}/file/getPer.do",
	                error: function(msg) { alert("error"); },
	                complete: function(msg) { 
	                	if(msg.responseText == 0){
	                		clearInterval(interval);
	                	}
	                	var per = Number(msg.responseText);
	                	changePer(per*2);
	                	$("#percentnum").html(per+"%");
	                 },
	                success: function(msg) { 
	                 }              
	            });
		}
		function getPerInterval(){
			interval = setInterval('getPer()',1000);	
		}
		function changePer(per){
			$("#percontent").css({"width":per+"px","height":"15px","background":"green"});
		}
	</script>
  </head>
  
  <body>
    This is my JSP page. <br>
    <button class="button" id="buttonUpload" onclick="getPerInterval();">Uadd</button>
    <div id ="percent" style="border:1px solid blue;width:200px;height:15px;" >
	    <div id="percontent">
	    </div>
    </div>
    <span id="percentnum">
    </span>
  </body>
</html>
