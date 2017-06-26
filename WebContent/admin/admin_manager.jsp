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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
	<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.mCustomScrollbar.concat.min.js"></script>
</head>
</head>
<body>
<section class="rt_wrap content mCustomScrollbar">
 <div class="rt_content">
      <div class="page_title">
       <h2 class="fl">会员列表</h2>
      </div>
      <section class="mtb">
       <select class="select" name = "cusLevel">
        <option value = "">会员等级</option>
        <option value = "青铜会员">青铜会员</option>
        <option value = "白银会员">白银会员</option>
        <option value = "黄金会员">黄金会员</option>
        <option value = "铂金会员">铂金会员</option>
        <option value = "钻石会员">钻石会员</option>
        <option value = "荣誉会员">荣誉会员</option>
       </select>
       <input type="text" class="textbox textbox_225" placeholder="输入会员号/手机/电子邮件查询..."/>
       <input type="button" value="查询" class="group_btn"/>
      </section>
      <table class="table">
       <tr>
        <th>Id</th>
        <th>会员头像</th>
        <th>会员账号</th>
        <th>手机号码</th>
        <th colspan="2">电子邮件</th>
        <th>会员等级</th>
        <th>账户余额</th>
        <th>冻结资金</th>
        <th>操作</th>
       </tr>
       <c:forEach items="${requestScope.listCustomer}" var="c">
       <tr>
        <td class="center">${c.cusId}</td>
        <td class="center"><img src="${c.cusImage}" width="50" height="50"/></td>
        <td>${c.cusName}</td>
        <td class="center">${c.cusPhone}</td>
        <td class="center" colspan="2">${c.cusEmail}</td>
        <td class="center">${c.cusLevel}</td>
        <td class="center">
         <strong class="rmb_icon">5559.00</strong>
        </td>
        <td class="center">
         <strong class="rmb_icon">59.00</strong>
        </td>
        <td class="center">      
         <a href="${pageContext.request.contextPath}/admin_edit?id=${c.cusId}" title="编辑" class="link_icon">&#101;</a>
        </td>
       </tr>
       </c:forEach>
      </table>
      <aside class="paging">
       第 <c:out value="${page}"/>/<c:out value="${count}"/>页
	      		<!-- 首页 -->
	     	  <a class="firstPage" href="${pageContext.request.contextPath}/listCustomer?page=1">首页</a>
	      
	      <!-- 上一页 -->
	      <c:if test="${page != 1}">
			<a class="previousPage" href="${pageContext.request.contextPath}/listCustomer?page=<c:out value="${page-1}"/>">上一页</a>
          </c:if>
          <c:forEach var="i" begin="1" end="${count }">
			<!-- 如果是当前页则不能够点击 --> 
			<c:if test="${i == page }">
           <a>${page }</a>
            </c:if> <c:if test="${i != page }">
			<a href="${pageContext.request.contextPath}/listCustomer?page=<c:out value="${i}"/>">
			<c:out value="${i}"/>
			</a>
            </c:if>
            </c:forEach>
             <!-- 下一页 -->
            <c:if test="${page !=count }">
			<a class="nextPage" href="${pageContext.request.contextPath}/listCustomer?page=<c:out value="${page+1}"/>">下一页</a>
            </c:if>
            <!-- 尾页 -->
            <a class="lastPage" href="${pageContext.request.contextPath}/listCustomer?page=<c:out value="${count}"/>">尾页</a>
	
      </aside>
 </div>
</section>
</body>
</html>