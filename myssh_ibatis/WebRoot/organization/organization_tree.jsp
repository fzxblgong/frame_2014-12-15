<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'authority_tree.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="${pageContext.request.contextPath}/jqueryminiui/scripts/boot.js" type="text/javascript"></script>

  </head>
  
  <body>
    <ul id="tree2" class="mini-tree" url="${pageContext.request.contextPath}/organization/getTreeDataList.do" style="width:300px;height:250px;padding:5px;" 
        showTreeIcon="true" textField="name" idField="id" parentField="p_id" resultAsTree="false"  
        allowSelect="false" enableHotTrack="false" expandOnLoad="true"
        showCheckBox="true" checkRecursive="false" autoCheckParent="true"
        >
    </ul>
    
    
    <br />
    <input type="button" value="setCheckedNodes" onclick="setCheckedNodes()"/>
    <input type="button" value="getCheckedNodes" onclick="getCheckedNodes()"/>
    <input type="button" value="checkAll" onclick="checkAll()"/>
    <input type="button" value="uncheckAll" onclick="uncheckAll()"/>

    <br />        
    <script type="text/javascript">

        function setCheckedNodes() {
            var tree = mini.get("tree2");
            //tree.setValue("ajax,json,date,control,forms");
            tree.setValue("forms");
        }
        function getCheckedNodes() {
            var tree = mini.get("tree2");

            var value = tree.getValue();
            alert(value);

        }
        function checkAll() {
            var tree = mini.get("tree2");
            var nodes = tree.getAllChildNodes(tree.getRootNode());
            tree.checkNodes(nodes);
        }
        function uncheckAll() {
            var tree = mini.get("tree2");
            var nodes = tree.getAllChildNodes(tree.getRootNode());
            tree.uncheckNodes(nodes);
        }
    </script>

  </body>
</html>
