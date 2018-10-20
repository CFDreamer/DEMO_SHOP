<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<title>商品详情</title>
	<link rel="stylesheet" type="text/css" href="css/prodetails.css">
	<link rel="stylesheet" type="text/css" href="css/base.css">
	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript"  src="js/prodetails.js"></script>
</head>
<body>
<div class="membername" style="display:none;">${memberInfo.username }</div>
	<!-- 顶部 -->
<div class="w top">
	<ul class="lf">
		<li>电话：15927537656</li>
		<li><a href="#" class="toLogin"><c:if test="${empty memberInfo.username}"></c:if>${memberInfo.username}</a><span></span></li>
		
	</ul>
	<ul class="rg">
		<li><a href="#">我的订单</a><span>|</span></li>
		<li><a href="#">我的收藏</a></li>
	</ul>
</div>
<!-- 头部 -->
<div class="w header">
	<!-- logo部分 -->
	<div class="logo lf">
		<h1>
			<a href="#" title="51商城">51商城</a>
		</h1>
	</div>
	<!-- 搜索框 -->
	<div class="search">
		<input type="search" name="search" placeholder="请输入内容">
		<img src="images/index/search.png">
	</div>
	<div class="shopcar rg"></div>
</div>
<!-- 导航 -->
<div class="navigator w">
	<ul>
		<li><a href="#">首页</a></li>
		<li><a href="#">图书类</a></li>
		<li><a href="#">家电类</a></li>
		<li><a href="#">服装类</a></li>
		<li><a href="#">电子类</a></li>
	</ul>
</div>
<div class="content w">
	<div class="product clearfix" proid="${goods.id}">
		<img src="${goods.picture}">
		<div class="proinfo">
			<h1>${goods.goodsname}</h1>
			<span>${goods.price}</span>
			<i>商场活动：全场满99包邮</i>
			<div class="number">
				数量:
				<input type="number" name="" value="1">
			</div>
			<a href="#" class="to_car">添加到购物车</a>
		</div>		
	</div>
	<div class="introduce">
		<div class="intro_hd">商品概述</div>
		<div class="intro_bd">${goods.introduce}</div>
	</div>
</div>
<div class="bottom w clearfix">
	<c:forEach items="${similarGoodsList}" var="list">
		<a href="details?id=${list.id}">
			<div class="newpro">
				<img src="${list.picture}">
				<div class="newinfo">
					<h4><span>商品名：</span>${list.goodsname}</h4>
					<i>价格：${list.price}</i>
				</div>
			</div>
		</a>
	</c:forEach>
</div>

</body>
</html>