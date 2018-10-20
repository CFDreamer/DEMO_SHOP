$(function(){
	$.get({
		url:'order/selectOrders',
		async:false,
		success:function(res){
			var orderList=res.ordersList;
			//创建订单基本信息
			for(var i=orderList.length-1;i>=0;i--){
				var allorders=$('<div></div>').addClass('allorders').appendTo($('.container'));
				var ordernum=$('<div></div>').addClass('ordernum').html("订单编号：<span>"+orderList[i].orderid+"</span>");
				
				var address=$('<div></div>').addClass('address');
				var address_hd=$('<div></div>').addClass('address_hd').append("<span class='name fl'>收货人："+orderList[i].receviename+"</span>").append("<span class='tel rg'>联系方式："+orderList[i].tel+"</span>");
				var address_bd=$('<div></div>').addClass('address_bd').html("收货地址："+orderList[i].address);
				var note=$('<div></div>').addClass('note').append('<p>买家备注：</p>').append("<span>"+orderList[i].bz+"</span>");
				address.append(address_hd).append(address_bd).append(note);

				var orderinfo=$('<div></div>').addClass('orderinfo').append("<span class='time'>订单时间："+orderList[i].orderdate+"</span>").append("<span class='allprice'>订单总价："+orderList[i].allprice+"</span>").append("<span class='to_details'>显示详情</span>");
				var line=$('<div></div>').addClass('line');
				allorders.append(ordernum).append(orderinfo).append(address).append(line);
			}
		}
	})
	

	//点击查看详情
	$('.to_details').on('click',function(){
		var orderid=$(this).parent().prev().children('span').html();
		console.log(orderid)
		$(".details").show();
		$('.mask').show();
		$('.tbody').html("");//清空之前显示的商品详情
		$.get({
			url:'orderdetails/details',
			data:{orderid:orderid},
			success:function(res){
				var list=res.list;
				console.log(list)
				for(var i=0;i<list.length;i++){
					var tr=$('<tr></tr>');
					var goods_td=$('<td></td>');
					var price_td=$('<td></td>');
					var count_td=$('<td></td>');
					var subtotal_td=$('<td></td>');
					goods_td.addClass('goods').append("<img src="+list[i].picture+">").append("<span>"+list[i].goodsname+"</span>");
					price_td.addClass('price').html(list[i].price);
					count_td.addClass('count').append("<span>X "+list[i].number+"</span>");
					subtotal_td.addClass('subtotal').html("￥ "+(list[i].price*list[i].number));
					tr.appendTo('.tbody').append(goods_td).append(price_td).append(count_td).append(subtotal_td);
				}
			}
		})
		
	})
	$('.close').on('click',function(){
		$(".details").hide();
		$('.mask').hide();
	})

})