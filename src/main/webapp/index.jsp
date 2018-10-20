<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>51 shop city</title>
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<link rel="stylesheet" type="text/css" href="css/base.css">
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/index.js"></script>
</head>
<body>
<div class="membername" style="display:none;">${memberInfo.username }</div>
<!-- 顶部 -->
<div class="w top">
	<ul class="lf">
		<li>电话：15927537656</li>
		<li><a href="#" class="toLogin"><c:if test="${empty memberInfo.username}">登录</c:if>${memberInfo.username}</a><span>|</span></li>
		<li><a href="#" class="toRegister">注册</a><span>|</span></li>
		<li><a href="#" class="destroy">退出</a></li>
	</ul>
	<ul class="rg">
		<li><a href="order_details.html" class="to_orders">我的订单</a><span>|</span></li>
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
		<img class="to_search" src="images/index/search.png">
	</div>
	<div class="shopcar rg"></div>
</div>
<!-- 导航 -->
<div class="navigator w">
	<ul>
		<li><a href="first">首页</a></li>
		<li><a href="#">图书类</a></li>
		<li><a href="#">家电类</a></li>
		<li><a href="#">服装类</a></li>
		<li><a href="#">电子类</a></li>
	</ul>
</div>
<!-- 内容区 -->
<div class="content w">
	<!-- 幻灯片 -->
	<div class="slider">
		<ul>
			<li><a href="#"><img src="images/index/img1.png" alt=""></a></li>
			<li><a href="#"><img src="images/index/img2.png" alt=""></a></li>
			<li><a href="#"><img src="images/index/img3.png" alt=""></a></li>
		</ul>
		<div class="arrow">
			<div class="arrow_left">&lt;</div>
			<div class="arrow_right">&gt;</div>
		</div>
	</div>	
	<!-- 热门商品 -->
	<div class="hot">
		<div class="hot_hd">热门商品</div>
		<div class="hot_bd">
			<!-- <div class="hotpro">
				<img src="images/goods/51.jpg">
				<div class="hotpro_rg rg">
					<h4>JBLARENAx80/VSX</h4>
					<span>☆☆☆☆☆</span>
					<i>价格：1058.00元</i>
				</div>
			</div> -->
		</div>
	</div>
</div>
<!-- 最新上架 -->
<div class="line w"><span>最新上架</span></div>
<div class="new w clearfix">
<!--<a href="details/prodetails.html">
		<div class="newpro">
			<img src="images/goods/1.jpg">
			<div class="newinfo">
				<h4><span>商品名：</span>从0到1 ARENAx180ARENAx180</h4>
				<i>价格：1058.00元</i>
			</div>
		</div>
	</a>-->
</div>
<!-- 打折商品 -->
<div class="line w"><span>打折商品</span></div>
<div class="discount w clearfix">
<!-- 
	<div class="newpro">
		<img src="images/goods/56.jpg">
		<div class="newinfo">
			<h4 id="discountname"><span>商品名：</span>华硕ASUS/顽石4代</h4>
			<h4><span>分类：</span>笔记本</h4>
			<i>现价：5000.00元</i>
			<em>原价：5499.00元</em>
		</div>
	</div>
-->
</div>
<!-- 底部号航 -->
<div class="line w"></div>
<div class="foot_nav w clearfix">
	<dl>
		<dt>购物指南</dt>
		<dd><a href="#">购物流程</a></dd>
		<dd><a href="#">会员介绍</a></dd>
		<dd><a href="#">生活旅行团购</a></dd>
		<dd><a href="#">常见问题</a></dd>
		<dd><a href="#">大家电</a></dd>
		<dd><a href="#">联系客服</a></dd>	
	</dl>
	<dl>
		<dt>配送方式</dt>
		<dd><a href="#">上门自提</a></dd>
		<dd><a href="#">211限时达</a></dd>
		<dd><a href="#">配送服务查询</a></dd>
		<dd><a href="#">配送费收取标准</a></dd>
		<dd><a href="#">海外配送</a></dd>
	</dl>
	<dl>
		<dt>支付方式</dt>
		<dd><a href="#">货到付款</a></dd>
		<dd><a href="#">在线支付</a></dd>
		<dd><a href="#">分期付款</a></dd>
		<dd><a href="#">邮局汇款</a></dd>
		<dd><a href="#">公司转账</a></dd>	
	</dl>
	<dl>
		<dt>售后服务</dt>
		<dd><a href="#">售后政策</a></dd>
		<dd><a href="#">价格保护</a></dd>
		<dd><a href="#">退款说明</a></dd>
		<dd><a href="#">退换货</a></dd>
		<dd><a href="#">取消订单</a></dd>	
	</dl>
	<dl>
		<dt>特色服务</dt>
		<dd><a href="#">明日学院</a></dd>
		<dd><a href="#">明日图书</a></dd>
		<dd><a href="#">明日编程词典</a></dd>
		<dd><a href="#">明日淘宝店铺</a></dd>
	</dl>
	<div class="focus_our rg">
	<h3>关注我们</h3>
	<img src="images/index/qrcode.png">
	<p>微信公众号</p>
	</div>
</div>
<!-- 底部 -->
<div class="foot w">@小可爱</div>
<!-- 注册 -->
<div class="mask"></div>
<div id="register">
	<div class="form_hd">
		<img src="images/index/51logo.png">
		<a href="javascript:;" title="关闭" class="close">x</a>
	</div>
	<h3>会员注册</h3>
	<div class="error">错误提示信息！</div>
	<form>
		<div class="form_bd">
			<label class="form_label">用户名:</label>
			<input class="form_input auth" type="text" name="username" placeholder="请输入用户名">
		</div>
		<div class="form_bd">
			<label class="form_label">密码:</label>
			<input class="form_input auth" type="password" name="password" placeholder="请输入密码">
		</div>
		<div class="form_bd">
			<label class="form_label">确认密码:</label>
			<input class="form_input auth" type="password" name="repassword" placeholder="请再次输入密码">
		</div>
		<div class="form_bd">
			<label class="form_label">联系电话:</label>
			<input class="form_input auth" type="text" name="tel" placeholder="请输入联系电话" maxlength="11">
		</div>
		<div class="form_bd">
			<label class="form_label">邮箱:</label>
			<input class="form_input auth" type="text" name="email" placeholder="请输入邮箱">
		</div>
		<p>51商城<i>《使用条款》</i></p>
		<button type="button" name="register_btn">同意协议并注册</button>
	</form>
	<span>已有账号？<a href="#" class="toLogin">去登录</a></span>
</div>

<!-- 登录 -->
<div class="mask"></div>
<div id="login">
	<div class="form_hd">
		<img src="images/index/51logo.png">
		<a href="javascript:;" title="关闭" class="close">x</a>
	</div>
	<h3>会员登录</h3>
	<div class="login_error">错误提示信息！</div>
	<form>
		<div class="loginform_bd">
			<label class="form_label">用户名:</label>
			<input class="form_input loginauth" type="text" name="username" placeholder="请输入用户名">
		</div>
		<div class="loginform_bd">
			<label class="form_label">密码:</label>
			<input class="form_input loginauth" type="password" name="password" placeholder="请输入密码">
		</div>
		<p>51商城<i>《使用条款》</i></p>
		<button type="button" name="login_btn">立即登录</button>
	</form>
	<span>没有账号？<a href="#" class="toRegister">立即注册</a></span>
</div>

</body>
</html>