<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>电脑销售管理系统</title>
	<meta name="author" content="DeathGhost" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
	<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.mCustomScrollbar.concat.min.js"></script>
</head>
<body>
	<header>
	 <h1><img src="${pageContext.request.contextPath}/images/admin_logo.png"/></h1>
	 <ul class="rt_nav">
	  <li><a href="${pageContext.request.contextPath}/admin/index.jsp" class="website_icon">站点首页</a></li>
	  <li><a href="#" class="clear_icon">清除缓存</a></li>
	  <li><a href="#" class="admin_icon">${admin.managerName}</a></li>
	  <li><a href="${pageContext.request.contextPath}/admin_info?id=${admin.managerId}" class="set_icon">账号设置</a></li>
	  <li><a href="${pageContext.request.contextPath}/admin/login.jsp" class="quit_icon">安全退出</a></li>
	 </ul>
	</header>
</body>
</html>