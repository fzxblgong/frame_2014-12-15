<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'page.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.7.js"></script>

		<script language="javascript" type="text/javascript">
		function nextPage(){
			var totalCount = $("#totalCount").val();
						var pageLine = $("#pageLine").val();
									var currentPage = Number($("#currentPage").val()) + 1;
			var url = "<%=basePath%>user/pageAction.action?totalCount="+totalCount;
			url += "&pageLine="+pageLine;
			url += "&currentPage="+currentPage;
			window.location.href=url;
		}
		function prePage(){
			var totalCount = $("#totalCount").val();
						var pageLine = $("#pageLine").val();
									var currentPage = Number($("#currentPage").val()) - 1;
			var url = "<%=basePath%>user/pageAction.action?totalCount="+totalCount;
			url += "&pageLine="+pageLine;
			url += "&currentPage="+currentPage;
			window.location.href=url;
		}
		function turnPage(currentPage){
			var totalCount = $("#totalCount").val();
						var pageLine = $("#pageLine").val();
			var url = "<%=basePath%>user/pageAction.action?totalCount="+totalCount;
			url += "&pageLine="+pageLine;
			url += "&currentPage="+currentPage;
			window.location.href=url;
		}
	</script>
	</head>

	<body>
		page
		<div class="pageTool">
			<s:set name="list" value="userCondition.pageBean.list"></s:set>
			<s:iterator var="obj" value="#request.list" status="statu">
				<s:if test="%{#statu.odd}">
					<font color="red">name: <s:property value="#obj.userName" />--age:<s:property
							value="#obj.age" /> </font>
				</s:if>
				<s:else>
					name:<s:property value="#obj.userName" />--age:<s:property
						value="#obj.age" />
				</s:else>
				<br />
			</s:iterator>
			<br />
			<a href="javascrip:void(0);" onclick="turnPage(1);return false;">首页</a>
			<a href="javascrip:void(0);" onclick="prePage();return false;">上页</a>
			<s:set name="pageNumerList"
				value="userCondition.pageBean.pageNumerList"></s:set>
			<s:iterator var="obj" value="#request.pageNumerList" status="statu">
				<s:if test="#obj == userCondition.pageBean.currentPage">
					<a href="javascrip:void(0);"
						onclick='turnPage(<s:property value="#obj" />);return false;'><font
						color="red"> <s:property value="#obj" />
					</font>
					</a>
				</s:if>
				<s:else>
					<a href="javascrip:void(0);"
						onclick='turnPage(<s:property value="#obj" />);return false;'><s:property
							value="#obj" />
					</a>
				</s:else>
				|
			</s:iterator>
			<a href="javascrip:void(0);" onclick="nextPage();return false;">下页</a>
			<a href="javascrip:void(0);" onclick='turnPage(<s:property value="userCondition.pageBean.pageNum" />);return false;'>末页</a>
			<br />
			总记录数:
			<s:property value="userCondition.pageBean.totalCount" />
			<input type="text" id="totalCount"
				value='<s:property value="userCondition.pageBean.totalCount" />'>
			<br />
			每页查询记录数:
			<s:property value="userCondition.pageBean.pageLine" />
			<input type="text" id="pageLine"
				value='<s:property value="userCondition.pageBean.pageLine" />'>
			<br />
			当前页码:
			<s:property value="userCondition.pageBean.currentPage" />
			<input type="text" id="currentPage"
				value='<s:property value="userCondition.pageBean.currentPage" />'>
			<br />
			总页数:
			<s:property value="userCondition.pageBean.pageNum" />
		</div>
		<s:debug></s:debug>
	</body>
</html>
