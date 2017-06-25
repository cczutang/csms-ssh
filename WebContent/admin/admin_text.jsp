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
 <div class="rt_content">
       <div class="page_title">
       <h2 class="fl">管理员信息</h2>
      </div>
      <table class="table">
       
       <tr>      
       	<td class="center">ID号</td> 
        <td class="center">${admin.managerId}</td> 
       </tr>
       
       <tr>
       <td class="center">名称</td> 
        <td class="center">${admin.managerName}</td>
       </tr>
       
       <tr>
       <td class="center">类型</td> 
       <td class="center">${admin.managerType}</td>
       </tr>
       
       <tr>
       <td class="center">联系方式</td> 
       <td class="center">${admin.managerPhone}</td>
       </tr>
       
       <tr>
       <td class="center">联系地址</td> 
       <td class="center">${admin.managerAddress}</td>
       </tr>
      </table> 
 </div>
</section>
</body>
</html>