<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>确认订单</title>
	<link rel="stylesheet" type="text/css" href="css/orders.css">
	<link rel="stylesheet" type="text/css" href="css/base.css">
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/orders.js"></script>
</head>
<body>
<div id="cxf" style="display:none;"><%=request.getParameter("cxf") %></div>
<div class="confirm">
<p>确认订单</p><i class="triangle"></i>
<table id="order_tb">
	<thead>
		<th>商品</th>
		<th>单价</th>
		<th>数量</th>
		<th>小计</th>
	</thead>
	<tbody class="tbody">
		<!--
		 <tr>
			<td class="goods"><img src="images/1.jpg"><span>拍照最好看的相机</span></td>
			<td class="price">￥ 1000.00</td>
			<td class="count"><span>X</span>3</td>
			<td class="subtotal">￥ 3000.00</td>
		</tr>
		 -->
	</tbody>
</table>
<div class="note">
	<p>您的留言</p><i></i>
	<input type="text" name="note" placeholder="请输入您想备注的内容（选填）">
</div>
<div class="address">
	<p>收货地址</p><i></i>
	<div class="addinfo clearfix">
		<span class="name"></span><span class="tel"></span>
		<em class="fl"></em>
		<a class="to_add rg" href="address.html">></a>
	</div>
</div>
<div class="foot">
	<span class="all_price">总价：￥ 3400.00</span>
	<button type="button" class="pay">确认付款</button>
</div>
</div>
</body>
</html>