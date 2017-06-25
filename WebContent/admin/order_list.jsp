<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
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
	<script>
		(function($){
			$(window).load(function(){			
				$("a[rel='load-content']").click(function(e){
					e.preventDefault();
					var url=$(this).attr("href");
					$.get(url,function(data){
						$(".content .mCSB_container").append(data); //load new content inside .mCSB_container
						//scroll-to appended content 
						$(".content").mCustomScrollbar("scrollTo","h2:last");
					});
				});
				
				$(".content").delegate("a[href='top']","click",function(e){
					e.preventDefault();
					$(".content").mCustomScrollbar("scrollTo",$(this).attr("href"));
				});
			});
		})(jQuery);
	</script>
</head>
<body>
<section class="rt_wrap content mCustomScrollbar">
	 <div class="rt_content">
	      <div class="page_title">
	       <h2 class="fl">订单列表</h2>
	       <a class="fr top_rt_btn add_icon">添加商品</a>
	      </div>
	      <section class="mtb">
	       <select class="select">
	        <option>订单状态</option>
	        <option>待付款</option>
	        <option>待发货</option>
	        <option>待评价</option>
	       </select>
	       <input type="text" class="textbox textbox_225" placeholder="输入订单编号..." id = "s_order"/>
	       <input type="button" value="查询" class="group_btn" onclick="search(id)"/>
	      </section>
	      <table class="table">
	       <tr>
	        <th>订单编号</th>
	        <th>收件人</th>
	        <th>联系电话</th>
	        <th>收件人地址</th>
	        <th>订单金额</th>
	        <th>配送方式</th>
	        <th>操作</th>
	       </tr>
	       
	       <c:forEach items="${requestScope.orders}" var="o">
	       <tr>
	        <td class="center"> ${o.orderId }</td>
	        <td> ${o.orderName }</td>
	        <td>18300000000</td>
	        <td>
	         <address> ${o.orderAddr }</address>
	        </td>
	        <td class="center"><strong class="rmb_icon"> ${o.orderTotal }</strong></td>
	        <td class="center"> ${o.orderEMS}</td>
	        <td class="center">
	         <a href="${pageContext.request.contextPath}/order_details?id=${o.orderId}" title="查看订单" class="link_icon" target="_blank">&#118;</a>
	         <a href="${pageContext.request.contextPath}/order_delete?id=${o.orderId}" title="删除" class="link_icon" >&#100;</a>
	        </td>
	       </tr>
	       </c:forEach>
	      </table>
	     
	      <aside class="paging">
	      	 第 <c:out value="${page}"/>/<c:out value="${count}"/>页
	      		<!-- 首页 -->
	     	  <a class="firstPage" href="${pageContext.request.contextPath}/showOrder?page=1">首页</a>
	      
	      <!-- 上一页 -->
	      <c:if test="${page != 1}">
			<a class="previousPage" href="${pageContext.request.contextPath}/showOrder?page=<c:out value="${page-1}"/>">上一页</a>
          </c:if>
          <c:forEach var="i" begin="1" end="${count }">
			<!-- 如果是当前页则不能够点击 --> 
			<c:if test="${i == page }">
           <a>${page }</a>
            </c:if> <c:if test="${i != page }">
			<a href="${pageContext.request.contextPath}/showOrder?page=<c:out value="${i}"/>">
			<c:out value="${i}"/>
			</a>
            </c:if>
            </c:forEach>
             <!-- 下一页 -->
            <c:if test="${page !=count }">
			<a class="nextPage" href="${pageContext.request.contextPath}/showOrder?page=<c:out value="${page+1}"/>">下一页</a>
            </c:if>
            <!-- 尾页 -->
            <a class="lastPage" href="${pageContext.request.contextPath}/showOrder?page=<c:out value="${count}"/>">尾页</a>
	      </aside>
	 </div>
	</section>
	<script type="text/javascript">
	function search(id){
		var s_order = document.getElementById("s_order").value;
		window.location.href = '${pageContext.request.contextPath}/order_details?id='+s_order;
	}
	
	</script>
</body>
</html>