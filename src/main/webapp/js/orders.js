$(function(){
	var cxf=$('#cxf').html();
	console.log(cxf);
	var allprice=0;
	var memberAddress="";
	$.post({
		url:'car/selectMemberPurchaseList',
		data:{addressid:cxf},
		success:function(res){
			console.log(res);
			var PurchaseList=res.memberPurchaseList;
			memberAddress=res.memberAddress;
			addressid=res.memberAddress.id;//获取对应的地址id
			for(var i=0;i<PurchaseList.length;i++){
				var tr=$('<tr></tr>');
				var goods_td=$('<td></td>');
				var price_td=$('<td></td>');
				var count_td=$('<td></td>');
				var subtotal_td=$('<td></td>');
				goods_td.addClass('goods').append("<img src="+PurchaseList[i].picture+">").append("<span>"+PurchaseList[i].goodsname+"</span>");
				price_td.addClass('price').html("￥ "+PurchaseList[i].price);
				count_td.addClass('count').append("<span>X "+PurchaseList[i].count+"</span>");
				subtotal_td.addClass('subtotal').html("￥"+parseFloat(PurchaseList[i].price*PurchaseList[i].count).toFixed(2));
				tr.appendTo('.tbody').append(goods_td).append(price_td).append(count_td).append(subtotal_td);
				//计算总价
				allprice+=parseInt(PurchaseList[i].price*PurchaseList[i].count);
				$('.all_price').html("总金额：￥ "+allprice);
			}
			if(memberAddress!=null){
				$('.addinfo em').html(memberAddress.address);
				$('.addinfo .name').html("姓名："+memberAddress.receviename);
				$('.addinfo .tel').html("联系方式："+memberAddress.tel);
			}
			else{
				$('.addinfo .name').css({'display':'none'});
				$('.addinfo .tel').css({'display':'none'});
				$('.addinfo em').html("暂无地址，点击右侧添加收货地址!");
			}
		}
	})
	//获取备注
	var bz="";
	$('.note input[type=text]').blur(function(){
		bz=this.value;
	})
	//点击确认付款按钮
	$('.pay').click(function(){
		console.log(bz+"*****"+allprice+"****"+addressid)
		if(memberAddress==null){
			alert("请您填写收货地址！");
			document.location.href="address.html";
		}
		else{
			//将bz和allprice穿到后台
			$.post({
				url:'car/purchaseListBalance',
				data:{addressid:addressid,bz:bz,allprice:allprice},
				success:function(res){
					if(res.message=="成功提交订单"){
						document.location.href="order_details.html";
					}
					else{
						alert("真不巧，您的网络走丢了，再试试！")
					}
				}
			})
		}
	})

})