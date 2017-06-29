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
<form action="${pageContext.request.contextPath}/update_product" method = "post" enctype="multipart/form-data">
 <div class="rt_content">
      <div class="page_title">
       <h2 class="fl">商品详情</h2>
       <a class="fr top_rt_btn" href = "${pageContext.request.contextPath}/listProduct?page=1">返回产品列表</a>
      </div>
      <c:if test="${msg!=0}">
      <input type="hidden" name="productId" value="${product.productId}">
     <section>
      <ul class="ulColumn2">
       <li>
        <span class="item_name" style="width:120px;">商品名称：</span>
        <input type="text" class="textbox textbox_295" placeholder="商品名称... " value = "${product.productName}" name = "productName"/>
       </li>
       <li>
        <span class="item_name" style="width:120px;">商品库存：</span>
        <input type="text" class="textbox" placeholder="商品库存... " value = "${product.productInventory}" name = "productInventory"/>
       </li>
       <li>
        <span class="item_name" style="width:120px;">商品价格：</span>
        <input type="text" class="textbox" placeholder="商品价格..." value = "${product.productPrice}" name = "productPrice"/>
       </li>
       <li>
        <span class="item_name" style="width:120px;">商品商城价格：</span>
        <input type="text" class="textbox" placeholder="商品商城价格..." value = "${product.productShopPrice}" name = "productShopPrice"/>
       </li>
        <li>
        <span class="item_name" style="width:120px;">上市时间：</span>
        <input type="text" class="textbox" placeholder="商品上市时间..." value = "${product.productDate}" name = "productDate"/>
       </li>
       <li>
        <span class="item_name" style="width:120px;" >品牌：</span>
        <select class="select" name = "catesId">
        <option value = "">---选择品牌---</option>
         <c:forEach var = "pc" items = "${clist}">
         	<option value = "${pc.catesId}">${pc.catesName}</option>
         </c:forEach>
        </select>
       </li>
       <li>
        <span class="item_name" style="width:120px;">分类：</span>
        <select class="select" name = "productType">
        <option value = "">---选择种类---</option>
        <c:forEach var = "tc" items = "${tlist}">
         	<option value = "${tc.cateName}">${tc.cateName}</option>
         </c:forEach>
        </select>
       </li>
       <li>
        <span class="item_name" style="width:120px;">上传图片：</span>
        <label class="uploadImg" >
         <input type="file" name = "upload"/>
         <span>上传图片</span>
        </label>
       </li>
       <li>
        <span class="item_name" style="width:120px;">产品详情：</span>
        <textarea rows = "5" cols = "100" class="textarea" placeholder="产品详情..." name = "productDesc" value = "${product.productDesc}">${product.productDesc}</textarea>
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