## 博客 web 平台

项目地址 [ServletWeb](https://github.com/zzzz76/ServletWeb) ，小而全的 Java web 项目，仅作学习使用。

* 实现博客管理的基本功能，用户可以对个人博客进行管理，并访问他人博客主页
* 采用 MVC/Model2 架构模式，仅依赖 Servlet/JSP 库。
* 存储采用 DAO 工厂设计模式，可实现 I/O 存储切换数据库存储。

## 启动

```
待续...
```

## 业务流程

* 用户操作：注册/登入/登出，发布/删除/查询。
* 视图响应：注册页面、登入页面、用户页面、访客页面。

这里将提供其中四个 Servlet 的业务流程图，分别用来处理注册请求、登入请求、发布请求以及删除请求。其中 ./message.do 不仅处理了发布请求，还用以接收来自登入和删除的重定向请求

<img src="web/images/flow.png" width="55%" height="55%">

## 时序图

我们从容器启动到用户发起一次请求建立项目时序图。简单的描述了 web 容器中对象的生命周期管理，以及各个对象之间的动态协作。

<img src="web/images/sequence.png" width="75%" height="75%">
