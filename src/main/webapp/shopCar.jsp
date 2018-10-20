<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>shopCart</title>
		<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
		<link rel="stylesheet" href="css/shopCar.css"/>
    	<script type="text/javascript" src="js/shopCar.js"></script>
	</head>
	<body>
	<div id="to_first"><a href="first">返回首页继续挑选</a></div>
		<table id="cartTable">
			<thead>
				<tr>
					<th><label><input type="checkbox" class="check-all check" />&nbsp;全选</label></th>
					<th>商品</th>
					<th>单价</th>
					<th>数量</th>
					<th>小计</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody class="tbody">
        	<!-- <tr>
        		<td class="checkbox"><input type="checkbox" class="check-one check"></td>
        		<td class="goods"><img src="images/2.jpg"><span>Canon/佳能 PowerShot SX50 HS</span></td>
        		<td class="price">3888.50</td>
        		<td class="count"><span class="reduce"></span><input type="text" value="1"><span class="add">+</span></td>
        		<td class="subtotal">3888.50</td>
        		<td class="operation"><span class="delete">删除</span></td>
        	</tr> -->
			</tbody>
		</table>
		<div class="foot" id="foot">
			<label class="select-all fl"><input type="checkbox" class="check-all check">&nbsp;全选</label>
			<a href="javascript:;" class="fl delete" id="deleteAll">删除</a>
			<div class="closing fr">结算</div>
			<div class="total fr">合计：￥<span id="priceTotal">0.00</span></div>
			<div class="selected fr" id="selected">已选商品<span id="selectedTotal">0</span>件</div>	
		</div>
		<div class="no_goods">
			<img src="images/cart.png">
			<p>您的购物车空空如也！</p>
			<a href="first">点击返回首页挑选您喜爱的宝贝！</a>
		</div>	
	</body>
</html>
