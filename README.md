## 博客管理 web 平台

项目地址 [ServletWeb](https://github.com/zzzz76/ServletWeb) ，小而全的 Java web 项目，仅作学习使用。

* 实现博客管理的基本功能，用户可以对个人博客进行管理，并访问他人博客主页
* 采用 MVC/Model2 架构模式，仅依赖 Servlet/JSP 库。
* 存储采用 DAO 工厂设计模式，可实现 I/O 存储切换数据库存储。

## 启动

```
1、将项目导入IDEA/Eclipse，修改./web/WEB-INF/web.xml文件里的存储配置    

2、放在tomcat等容器下运行。访问 localhost:8080即可（默认配置已去掉项目名称）
```

## 业务流程

从用户发出请求到获得响应，经过的逻辑处理，为一个业务流程。

* 用户操作：注册/登入/登出，发布/删除/查询。
* 视图响应：注册页面、登入页面、用户页面、访客页面。

这里提供了其中四个 Servlet 的业务流程图，分别用来处理注册请求、登入请求、发布请求以及删除请求。其中 ./message.do 不仅处理了发布请求，还用以接收来自登入和删除的重定向请求

<a href="https://www.cnblogs.com/zzzz76/p/12802614.html"><img src="https://img2020.cnblogs.com/blog/1039974/202004/1039974-20200429154241190-188616150.png" width="55%" height="55%"></a>

## 时序图

我们从容器启动到完成一次http请求的处理，建立项目时序图。简单的描述了 web 容器中对象的生命周期管理，以及各个对象之间的动态协作。

<a href="https://www.cnblogs.com/zzzz76/p/12802614.html"><img src="https://img2020.cnblogs.com/blog/1039974/202004/1039974-20200429154306630-1314815313.png" width="75%" height="75%"></a>