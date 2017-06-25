<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file = "../WEB-INF/view/header.jsp" %>
    <%@ include file = "../WEB-INF/view/left.jsp" %>
    <%@ include file = "../WEB-INF/view/footer.jsp" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>后台管理系统</title>
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	<script src="../js/jquery.js"></script>
	<script src="../js/jquery.mCustomScrollbar.concat.min.js"></script>
</head>
</head>
<body>
<section class="rt_wrap content mCustomScrollbar">
 <form action="${pageContext.request.contextPath}/update_customer" method = "post" enctype="multipart/form-data">
 <div class="rt_content">
      <div class="page_title">
       <h2 class="fl">会员信息</h2>
       <a class="fr top_rt_btn" href = "${pageContext.request.contextPath}/listCustomer?page=1">返回产品列表</a>
      </div>
      <c:if test="${msg!=0}">
      <input type="hidden" name="cusId" value="${customer.cusId}">
     <section>
      <ul class="ulColumn2">
       <li>
        <span class="item_name" style="width:120px;">会员名：</span>
        <input type="text" class="textbox textbox_295" placeholder="会员名... " value = "${customer.cusName}" name = "cusName"/>
       </li>
       <li>
        <span class="item_name" style="width:120px;">会员邮箱：</span>
        <input type="text" class="textbox" placeholder="会员邮箱... " value = "${customer.cusEmail}" name = "cusEmail"/>
       </li>
       <li>
        <span class="item_name" style="width:120px;">会员电话：</span>
        <input type="text" class="textbox" placeholder="会员电话..." value = "${customer.cusPhone}" name = "cusPhone"/>
       </li>
       <li>
        <span class="item_name" style="width:120px;">会员地址：</span>
        <input type="text" class="textbox" placeholder="会员地址..." value = "${customer.cusAddress}" name = "cusAddress"/>
       </li>
        <li>
        <span class="item_name" style="width:120px;">会员等级：</span>
        <input type="text" class="textbox" placeholder="会员等级..." value = "${customer.cusLevel}" name = "cusLevel"/>
       </li>
       <li>
        <span class="item_name" style="width:120px;"></span>
        <input type="submit" class="link_btn" value = "修改"/>
       </li>
      </ul>
     </section>
     </c:if>
 </div>
 </form>
</section>
</body>
</html>