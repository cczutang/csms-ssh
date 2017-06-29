<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
<aside class="lt_aside_nav content mCustomScrollbar">
 <h2><a href="${pageContext.request.contextPath}/admin/index.jsp">起始页</a></h2>
 <ul>
  <li>
   <dl>
    <dt>商品管理</dt>
    <!--当前链接则添加class:active-->
    <dd>
    	<a href="${pageContext.request.contextPath}/listProduct?page=1&type=1">商品列表
    	</a>
    </dd>
    <dd><a href="${pageContext.request.contextPath}/product_edit?id=0">商品详情</a></dd>
    <dd>
    	<a href="${pageContext.request.contextPath}/listProduct?page=1&type=0">商品回收站
    	</a>
    </dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>订单信息</dt>
    <dd><a href="${pageContext.request.contextPath}/showOrder?page=1">订单列表</a></dd>
    <dd><a href="${pageContext.request.contextPath}/admin/order_details.jsp">订单详情</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>会员管理</dt>
    <dd><a href="${pageContext.request.contextPath}/listCustomer?page=1">会员列表</a></dd>
    <dd><a href="${pageContext.request.contextPath}/admin/user_level.jsp">会员等级管理</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>报表统计</dt>
    <dd><a href="discharge_statistic.html">销售统计报表</a></dd>
    <dd><a href="sales_volume.html">订单统计</a></dd>
    <dd><a href="sales_volume.html">商品统计</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>售后管理</dt>
    <dd><a href="setting.html">退货</a></dd>
    <dd><a href="setting.html">换货</a></dd>
    <dd><a href="setting.html">维修</a></dd>
    <dd><a href="setting.html">其他服务</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>基础设置</dt>
    <dd><a href="setting.html">站点基础设置</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>配送与支付设置</dt>
    <dd><a href="express_list.html">配送方式</a></dd>
    <dd><a href="pay_list.html">支付方式</a></dd>
   </dl>
  </li>
  <li>
   <p class="btm_infor">© www.zaysx.cn 版权所有</p>
  </li>
 </ul>
</aside>
<style>
	.dataStatistic{width:400px;
		height:200px;
		border:1px solid #ccc;
		margin:0 auto;
		margin:10px;
		overflow:hidden
	}
	#cylindrical{
		width:400px;
		height:200px;
		margin-top:-15px
	}
	#line{
		width:400px;
		height:200px;
		margin-top:-15px
	}
	#pie{
		width:400px;
		height:200px;
		margin-top:-15px
	}
</style>
</body>
</html>