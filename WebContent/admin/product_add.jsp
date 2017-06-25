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
	<meta name="author" content="DeathGhost" />
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
<form action="${pageContext.request.contextPath}/add_product" method = "post" enctype="multipart/form-data">
 <div class="rt_content">
      <div class="page_title">
       <h2 class="fl">添加的商品信息</h2>
       <a class="fr top_rt_btn" href = "${pageContext.request.contextPath}/listProduct?page=1">返回产品列表</a>
      </div>
     <section>
     
      <ul class="ulColumn2">
       <li>
        <span class="item_name" style="width:120px;">商品名称：</span>
        <input type="text" class="textbox textbox_295" placeholder="商品名称... " name = "productName"/>
       </li>
       
        <li>
        <span class="item_name" style="width:120px;">商品市场价格：</span>
        <input type="text" class="textbox" placeholder="商品市场价格..." name = "productPrice"/>
       </li>
       
       <li>
        <span class="item_name" style="width:120px;">商品商城价格：</span>
        <input type="text" class="textbox" placeholder="商品商城价格..." name= "productShopPrice"/>
       </li>
       
       <li>
        <span class="item_name" style="width:120px;">商品库存：</span>
        <input type="text" class="textbox" placeholder="商品库存... " name = "productInventory"/>
       </li>
      
        <li>
        <span class="item_name" style="width:120px;">上市时间：</span>
       <!--  <input type="date" class="textbox" placeholder="商品上市时间..." name = "productDate"/> -->
      <input type="text" class="textbox" placeholder="商品上市时间..." name = "productDate"/>
       </li>
       
       <li>
        <span class="item_name" style="width:120px;" >品牌：</span>
        <select class="select" name = "productCompany">
         <option value = "">---选择品牌---</option>
         <option value = "联想">联想</option>
         <option value = "戴尔">戴尔</option>
         <option value = "惠普">惠普</option>
         <option value = "苹果">苹果</option>
         <option value = "华硕">华硕</option>
         <option value = "神舟">神舟</option>
         <option value = "Acer弘基">Acer弘基</option>
         <option value = "机械革命">机械革命</option>
         <option value = "MSI微星">MSI微星</option>
         <option value = "三星">三星</option>
         <option value = "雷神">雷神</option>
         <option value = "微软">微软</option>
         <option value = "华为">华为</option>
         <option value = "小米">小米</option>
         <option value = "雷神">雷神</option>
         <option value = "东芝">东芝</option>
         <option value = "清华同方">清华同方</option>
         <option value = "索尼">索尼</option>
        </select>
       </li>
       
       <li>
        <span class="item_name" style="width:120px;">分类：</span>
        <select class="select" name = "productType">
        <option value = "">---选择种类---</option>
         <option value = "笔记本电脑">笔记本电脑</option>
         <option value = "平板电脑">平板电脑</option>
         <option value = "台式机">台式机</option>
         <option value = "一体机">一体机</option>
         <option value = "其他配件">其他配件</option>
        </select>
       </li>
       
       <li>
        <span class="item_name" style="width:120px;">上传图片：</span>
        <label class="uploadImg">
         <input type="file" name = "upload"/>
         <span>上传图片</span>
        </label>
       </li>  
       <li>
        <span class="item_name" style="width:120px;">产品详情：</span>
        <textarea rows = "5" cols = "100" class="textarea" placeholder="产品详情..." name = "productDesc">${product.productDesc}</textarea>
       </li>
       
       <li>
        <span class="item_name" style="width:120px;"></span>
        <input type="submit" class="link_btn" value = "确认添加"/>
       </li>
      </ul>
     </section>
 </div>
 </form>
</section>
</body>
</html>