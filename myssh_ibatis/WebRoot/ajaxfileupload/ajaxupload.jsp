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
<link href="${pageContext.request.contextPath}/ajaxfileupload/ajaxfileupload.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${pageContext.request.contextPath}/ajaxfileupload/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/ajaxfileupload/ajaxfileupload.js"></script>
	<script type="text/javascript">
	var interval;
	function ajaxFileUpload()
	{
		$("#loading").ajaxStart(function(){
			
		}).ajaxComplete(function(){
			clearInterval(interval);
		});
		$.ajaxFileUpload
		(
			{
				url:'${pageContext.request.contextPath}/file/uploadFile.do',
				secureuri:false,
				fileElementId:'fileToUpload',
				dataType: 'json',
				data:{name:'logan', id:'id'},
				success: function (data, status)
				{
					if(typeof(data.error) != 'undefined')
					{
						if(data.error != '')
						{
							alert(data.error);
						}else
						{
							alert(data.msg);
						}
					}
					$("#percentnum").html("100%");
				},
				error: function (data, status, e)
				{
					alert(data+" "+status+" "+e);
				}
			}
		)
		return false;
	}
	//进度条比例
	function getPerInterval(){
			interval = setInterval('getPer()',1000);	
		}
		function getPer(){
			//var per = $.ajax({url:"${pageContext.request.contextPath}/file/getPer.do",async:false});
			  $.ajax({
	            type: "GET",
	            async:false,
	                dateType:"html",
	                url: "${pageContext.request.contextPath}/fileper/getPer.do",
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
		function changePer(per){
			$("#percontent").css({"width":per+"px","height":"15px","background":"green"});
		}
	</script>	
  </head>
  
  <body>
  <%
  //session.setAttribute("per",1);
  %>
    This is my JSP page. <br>
    ${pageContext.request.contextPath} --
    ${pageContext.request.contextPath}/file/fileAction.do-
    <img id="loading" src="${pageContext.request.contextPath}/ajaxfileupload/loading.gif" style="display:none;">
    <form name="form" action="" method="POST" enctype="multipart/form-data">
    <input id="fileToUpload" type="file" size="45" name="fileToUpload" class="input"/>
    <button class="button" id="buttonUpload" onclick="getPerInterval();return ajaxFileUpload();">Upload</button>
    <div id ="percent" style="border:1px solid blue;width:200px;height:15px;" >
	    <div id="percontent">
	    </div>
    </div>
    <span id="percentnum">
    </span>
    </form>
  </body>
</html>
