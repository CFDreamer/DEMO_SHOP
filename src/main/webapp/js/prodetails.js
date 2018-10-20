$(function(){
	// 导航条排他样式显示
	$('.navigator li').eq(0).css({'background':'rgba(0,0,0,0.3)'});
	$('.navigator li').click(function(){
		$(this).css({'background':'rgba(0,0,0,0.3)'}).siblings().css({'background':''});
	});
	//获取用户名是否为空
	var membername=$(".membername").html();
	//获取商品id
	var goodsid=$('.product').attr("proid");
	//获取商品数量
	var count=$('.number input[type=number]').val();
	$('.number input[type=number]').change(function(){
		count=this.value;
		if(count<=1){
			count=1;
			$(this).val("1");
		}
	});
	//进入我的购物车
	$('.shopcar').click(function(){
		if(membername=""){
			alert("请先登录再查看您的购物车！");
			document.location.href="../ssm/index.jsp";
		}
		else{
			document.location.href="../ssm/shopCar.jsp";
		}
	})
	//点击加入购物车时先判断用户是否已登录
	$('.to_car').click(function(){
		if(membername!=""){
			console.log(goodsid+"-------"+count);
			//发送请求
			$.post({
				url:"car/addCar",	
				data:{goodsid:goodsid,count:count},
				success:function(res){
					if(res.addCarMessage=="成功"){
						alert("该宝贝已成功加入购物车，请继续挑选您喜爱的商品！");
//						document.location.href="../ssm/shopCar.html";
					}else{
						alert("真不巧，您的网络走丢了，请稍后再试！")
					}
				}
			})
		}
		else{
			//判断用户是否登录
			alert("您尚未登录，请登录后再试!");
			window.location.href='../ssm/index.jsp';
		}
	})
	
	

	
})