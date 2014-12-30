<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
    <div class="p">
            <%
                int pagesize = 10;//每页显示记录数
                int liststep = 20;//最多显示分页页数
                int pages = 1;//默认显示第一页
                if (request.getParameter("pages") != null) {
                    pages = Integer.parseInt(request.getParameter("pages"));//分页页码变量
                }
                //sql="select count(*) from table";//取出记录总数,把*换成记录名性能更加
                int count = 305;//假设取出记录总数
                int pagescount = (int) Math.ceil((double) count / pagesize);//求总页数，ceil（num）取整不小于num
                if (pagescount < pages) {
                    pages = pagescount;//如果分页变量大总页数，则将分页变量设计为总页数
                }
                if (pages < 1) {
                    pages = 1;//如果分页变量小于１,则将分页变量设为１
                }
                int listbegin = (pages - (int) Math.ceil((double) liststep / 2));//从第几页开始显示分页信息
                if (listbegin < 1) {
                    listbegin = 1;
                }
                int listend = pages + liststep/2;//分页信息显示到第几页
                if (listend > pagescount) {
                    listend = pagescount + 1;
                }

                //显示数据部分
                int recordbegin = (pages - 1) * pagesize;//起始记录
                int recordend = 0;
                recordend = recordbegin + pagesize;
                //最后一页记录显示处理
                // if (pages == pagescount) {
                  //  recordend = (int) (recordbegin + pagesize * (count % pagesize) * 0.1);
               //  }
                  if (pages == pagescount && count % pagesize != 0) {//感谢shixiangkun在博客中提出问题
                       recordend = (int) (recordbegin + (count % pagesize) );
                  }
                //Connection conn = null;//要测试显示数据请自己链接数据库
                //PreparedStatement stmt = null;
                //String strSql = "select * from usertable limit recordbegin,pagesize";//取出分页记录,SQL因数据库而异！
                //stmt = conn.prepareStatement(strSql);
                //ResultSet rs = stmt.executeQuery();
                //while(rs.next())){
                //    response.getWriter().println(""+rs.getString("userId")+"<br>");//显示取出的数据
                //}
                for (int i = recordbegin; i < recordend; i++) {
                    response.getWriter().println("record " + i + "<br>");
                }

                //显示数据部分

                //<显示分页信息
                //<显示上一页
                if (pages > 1) {
                    response.getWriter().println(
                    "<a href=?pages=" + (pages - 1) + ">上一页</a>");
                }//>显示上一页
                //<显示分页码
                for (int i = listbegin; i < listend; i++) {
                    if (i != pages) {//如果i不等于当前页
                        response.getWriter().println(
                        "<a href=?pages=" + i + ">[" + i + "]</a>");
                    } else {
                        response.getWriter().println("[" + i + "]");
                    }
                }//显示分页码>
                //<显示下一页
                if (pages != pagescount) {
                    response.getWriter().println(
                    "<a href=?pages=" + (pages + 1) + ">下一页</a>");
                }//>显示下一页
                //>显示分页信息
            %>
        </div>

  </body>
</html>
