struts2.3+spring3.0+mybatis-3.2.8 项目开发框架

mybatis 

一.spring配置数据源文件：/src/beans.xml

1.测试数据库可执行/docs/mybatis.sql。
2.可根据情况修改自己测试的数据库ip和连接方式。


二.版本

ssm version v1.2 功能：
1.action,service,dao,支持spring业务类注释方式依赖注入。 
2.mybatis支持接口注释开发，支持sql mapper的xml配置开发。 
3.集成log4j配置输出文件。 
4.集成常用异步上传ajaxFileupload测试实例。 测试路径：/ajaxfileupload/ajaxupload.jsp
5.集成上传进度百分比进度测试实例。（ajax异步sessionkey计算）
+6.集成jqueryminiui前端框架。
+7.集成用户列表展示功能。（包括分页查询，分页排序，条件查询等）测试路径：/user/userlist.jsp


计划(未发布)：
version 2.x
1.加入登录过滤器。
2.集成spring安全框架。

version 3.x
1.集成hibernate。

version 4.x
1.加入maven管理。
