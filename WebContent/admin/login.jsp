<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>后台登录</title>
	<meta name="author" content="DeathGhost" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
	<style>
	body{height:100%;background:#16a085;overflow:hidden;}
	canvas{z-index:-1;position:absolute;}
	</style>
	<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/verificationNumbers.js"></script>
	<script src="${pageContext.request.contextPath}/js/Particleground.js"></script>
	<script>
		$(document).ready(function() {
		  //粒子背景特效
		  $('body').particleground({
		    dotColor: '#5cbdaa',
		    lineColor: '#5cbdaa'
		  });
		  //验证码
		  createCode();
		});
	</script>
</head>
<body >
<form action = "${pageContext.request.contextPath}/adminLogin" method = "post">
<dl class="admin_login">
 <dt>
  <strong>站点后台管理系统</strong>
  <em>Computer Sales Manager System</em>
 </dt>
 <dd class="user_icon">
  <input type="text" placeholder="账号" class="login_txtbx" name = "managerName" required="required"/>
 </dd>
 <dd class="pwd_icon">
  <input type="password" placeholder="密码" class="login_txtbx" name = "managerPwd"/>
 </dd>
 <dd class="val_icon">
  <div class="checkcode">
    <input type="text" id="J_codetext" placeholder="验证码" maxlength="4" class="login_txtbx">
    <canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
  </div>
  <input type="submit" value="验证码核验" class="ver_btn" name = "submit">
 </dd>
 <dd>
  <input type="submit" value="立即登录" class="submit_btn" name = "submit"/>
 </dd>
</dl>
</form>
</body>
</html>