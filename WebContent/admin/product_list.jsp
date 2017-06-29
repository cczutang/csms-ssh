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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
	<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script type="text/javascript">
		$('a').click(function(){
		    $(this).addClass('active').siblings().removeClass('active');
		})
	</script>
</head>
<body>
<section class="rt_wrap content mCustomScrollbar">
 <div class="rt_content">
      <div class="page_title">
       <h2 class="fl">商品列表</h2>
       <a href="${pageContext.request.contextPath}/add_product_before" class="fr top_rt_btn add_icon">添加商品</a>
      </div>
       <form action = "${pageContext.request.contextPath}/findProduct" method = "post">
       <section class="mtb">
       <select class="select" name = "selectValue">
        <option value = "">下拉菜单</option>
        <option value = "id">产品ID</option>
        <option value = "company">产品公司</option>
        <option value = "type">产品类型</option>
        <option value = "name">产品名称</option>
       </select>
       <input type="hidden" name="page" value="1">
       <input type="text" class="textbox textbox_225" placeholder="输入产品关键词或产品货号..." name = "inputValue"/>
       <input type="button" value="查询" class="group_btn"/>
       </form>    
      </section>
      <table class="table">
       <tr>
        <th>缩略图</th>
        <th>产品名称</th>
        <th>货号</th>
        <th>单价</th>
        <th>上市时间</th>
        <th>种类</th>
        <th>新品</th>
        <th>热销</th>
        <th>库存</th>
        <th>操作</th>
       </tr>
       <c:forEach items="${requestScope.listProduct}" var="p">
       <tr>
        <td class="center"><img src="${p.productImage}" width="50" height="50"/></td>
        <td>${p.productName}</td>
        <td class="center">${p.productId}</td>
        <td class="center"><strong class="rmb_icon">${p.productPrice}</strong></td>
        <td class="center">${p.productDate}</td>
        <td class="center">${p.productType}</td>
        <td class="center"><a title="否" class="link_icon">&#88;</a></td>
        <td class="center"><a title="是" class="link_icon">&#89;</td>
        <td class="center">${p.productInventory}</td>
        <td class="center">
         <a href="${pageContext.request.contextPath}//findByPid?id=${p.productId}" title="预览" class="link_icon" target="_blank">&#118;</a>
         <a href="${pageContext.request.contextPath}/update_product_before?id=${p.productId}" title="编辑" class="link_icon">&#101;</a>
         <a href="${pageContext.request.contextPath}/delete_product/${p.productId}" title="删除" class="link_icon">&#100;</a>
        </td>
       </tr>
       </c:forEach>
      </table>
      <aside class="paging">
        第 <c:out value="${page}"/>/<c:out value="${count}"/>页
	   <!-- 首页 -->
	   <a class="firstPage" href="${pageContext.request.contextPath}/listProduct?page=1&type=<c:out value="${type}"/>">首页</a>
	      <!-- 上一页 -->
	      <c:if test="${page != 1}">
			<a class="previousPage" href="${pageContext.request.contextPath}/listProduct?page=<c:out value="${page-1}"/>&type=<c:out value="${type}"/>">上一页</a>
          </c:if>
          <c:forEach var="i" begin="1" end="${count }">
			<!-- 如果是当前页则不能够点击 --> 
			<c:if test="${i == page }">
           <a>${page }</a>
            </c:if> <c:if test="${i != page }">
			<a href="${pageContext.request.contextPath}/listProduct?page=<c:out value="${i}"/>&type=<c:out value="${type}"/>">
			<c:out value="${i}"/>
			</a>
            </c:if>
            </c:forEach>
             <!-- 下一页 -->
            <c:if test="${page !=count }">
			<a class="nextPage" href="${pageContext.request.contextPath}/listProduct?page=<c:out value="${page+1}"/>&type=<c:out value="${type}"/>">下一页</a>
            </c:if>
            <!-- 尾页 -->
            <a class="lastPage" href="${pageContext.request.contextPath}/listProduct?page=<c:out value="${count}"/>&type=<c:out value="${type}"/>">尾页</a>
      </aside>
 </div>
</section>
<script type="text/javascript">
	function addProduct() {
		window.location.href = "${pageContext.request.contextPath}/addProduct";
	}
	$(function(){
		$("#delete").click(function() {
			if(! confirm("你真的确定要删除?")){				
				return false;
			}
		});
	});
</script>
</body>
</html>