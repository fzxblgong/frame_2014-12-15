struts2.3+spring3.0+mybatis-3.2.8 项目开发框架


一.spring配置数据源文件：/src/beans.xml

1.测试数据库可执行/docs/mybatis.sql。
2.可根据情况修改自己测试的数据库ip和连接方式。


二.版本

ssm version v1.3 功能

新增：
+8.框架在支持mybatis-3.2.8基础上又整合进hibernate4，并支持注释。
+9.使用注释ssh方式实现JqueryMiniUi多选树。实例路径：/organization/organization_tree.jsp

1.action,service,dao,支持spring业务类注释方式依赖注入。 
2.mybatis支持接口注释开发，支持sql mapper的xml配置开发。 
3.集成log4j配置输出文件。 
4.集成常用异步上传ajaxFileupload测试实例。 测试路径：/ajaxfileupload/ajaxupload.jsp
5.集成上传进度百分比进度测试实例。（ajax异步sessionkey计算）
6.集成JqueryMiniUi前端框架。
7.集成用户列表展示功能。（包括分页查询，分页排序，条件查询，按列排序）测试路径：/user/userlist.jsp


计划(未发布)：
version 2.x
1.加入登录过滤器。
2.集成spring安全框架。

version 3.x
1.集成hibernate。

version 4.x
1.加入maven管理。

三：运行环境

1.JDK "1.6.0_10-rc2";
2.MyEclipse6.5;
3.Tomcat6.0;
4.MySql5.0;
5.Windows7 32bit.

注：因为jqueryminiui分Eclipse和Myeclipse版本，我集成的是Meclipse版本，虽然我没试过eclipse是否正常，但为了测试稳定最好用Myeclipse试下，谢谢。
