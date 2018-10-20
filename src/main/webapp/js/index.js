$(function(){
	// 导航条排他样式显示
	$('.navigator li').eq(0).css({'background':'rgba(0,0,0,0.3)'});
	$('.navigator li').click(function(){
		$(this).css({'background':'rgba(0,0,0,0.3)'}).siblings().css({'background':''});
	});

	// 幻灯片播放
	var count=0;
	$('.arrow_left').click(function(){
		count--;
		count=count<0 ? $('.slider li').length-1 : count;
		$('.slider li').eq(count).fadeIn().siblings('li').fadeOut();
	});
	$('.arrow_right').click(function(){
		count++;
		count=count>$('.slider li').length-1 ? 0 : count; 
		$('.slider li').eq(count).fadeIn().siblings('li').fadeOut();
	});
	// 设置幻灯片自动播放
	setInterval(function(){
		count++;
		count=count>$('.slider li').length-1 ? 0 : count; 
		$('.slider li').eq(count).fadeIn().siblings('li').fadeOut();
	},3500);
	//注册
	$('.toRegister').on('click',function(){
		$("#register").show();
		$('.mask').show();
	});
	$('.close').on('click',function(){
		$("#register").hide();
		$('.mask').hide();
	});
	//注册页面去登录
	$('.toLogin').click(function(){
		$('#register').fadeOut();
		$('#login').fadeIn();
	})
	//登录页面去注册
	$('.toRegister').click(function(){
		$('#login').fadeOut();
		$('#register').fadeIn();
	})
	//进入我的购物车
	$('.shopcar').click(function(){
		if($('.membername').html()==""){
			alert("请先登录再查看您的购物车！");
			$('#login').show();
		}
		else{
			document.location.href="../ssm/shopCar.jsp";
		}
	})
	//进入订单
	$('.to_orders').click(function(){
		if($('.membername').html()==""){
			alert("请先登录再查看您的历史订单信息！");
			$('#login').show();
			return false;
		}
	})
	//点击搜索
	$('.to_search').click(function(){
		var typename=$('.search input[type=search]').val();
		$.get({
			url:'index1',
			data:{typename:typename},
			success:function(res){
				console.log(res)	
				$('.new').html("");
				$('.discount').html("");
				//最新上架商品渲染
				var newgoodsList=res.newgoodsList;
				//渲染前12条最新商品的数据
				newgoodsList.length = newgoodsList.length>12 ? 12 : newgoodsList.length;
				for(var i=0;i<newgoodsList.length;i++){
					//给每一个商品设置a链接跳转并添加cat属性传递到商品详情页面
					var a=$("<a href=details?id="+newgoodsList[i].id+"></a>").appendTo($('.new'));
					var div=$('<div></div>');
					div.appendTo(a).addClass("newpro").append("<img src="+newgoodsList[i].picture+">").append($('<div></div>'));
					div.children("div").addClass("newinfo").append("<h4><span>商品名：</span>"+newgoodsList[i].goodsname+"</h4>").append("<i>价格："+parseFloat(newgoodsList[i].price).toFixed(2)+"元</i>");
				}

				//折扣商品渲染
				var discountList=res.discountList;
				discountList.length = discountList.length>12 ? 12 : discountList.length;
				for(var i=0;i<discountList.length;i++){
					var a=$("<a href=details?id="+discountList[i].id+"></a>").appendTo($('.discount'));
					var div=$('<div></div>');
					div.appendTo(a).addClass("newpro").append("<img src="+discountList[i].picture+">").append($('<div></div>'));
					div.children("div").addClass("newinfo").append("<h4><span>商品名：</span>"+discountList[i].goodsname+"/</h4>").append("<h4><span>分类：</span>"+discountList[i].type.typename+"</h4>").append("<i>现价："+parseFloat(discountList[i].nowprice).toFixed(2)+"元</i>").append("<em>原价："+parseFloat(discountList[i].price).toFixed(2)+"元</em>");
				}
			}
		})
	})
	//首页商品渲染
	$.ajax({
		url:'index1',
		type:'get',
		dataType:'json',
		success:function(res){
//			console.log(res);
			//热门商品渲染
			var hotList=res.hotList;
			for(var i=0;i<hotList.length;i++){
				var a=$("<a href=details?id="+hotList[i].id+"></a>").appendTo($('.hot_bd'));
				var div=$('<div></div>');
				div.appendTo(a).addClass("hotpro").append("<img src="+hotList[i].picture+">").append($('<div></div>'));
				div.children("div").addClass("hotpro_rg rg").append("<h4>"+hotList[i].goodsname+"</h4>").append("<span>★★★★★</span>").append("<i>价格："+parseFloat(hotList[i].price).toFixed(2)+"</i>");
			}
			
			//最新上架商品渲染
			var newgoodsList=res.newgoodsList;
			//渲染前12条最新商品的数据
			newgoodsList.length = newgoodsList.length>12 ? 12 : newgoodsList.length;
			for(var i=0;i<newgoodsList.length;i++){
				//给每一个商品设置a链接跳转并添加cat属性传递到商品详情页面
				var a=$("<a href=details?id="+newgoodsList[i].id+"></a>").appendTo($('.new'));
				var div=$('<div></div>');
				div.appendTo(a).addClass("newpro").append("<img src="+newgoodsList[i].picture+">").append($('<div></div>'));
				div.children("div").addClass("newinfo").append("<h4><span>商品名：</span>"+newgoodsList[i].goodsname+"</h4>").append("<i>价格："+parseFloat(newgoodsList[i].price).toFixed(2)+"元</i>");
			}

			//折扣商品渲染
			var discountList=res.discountList;
			discountList.length = discountList.length>12 ? 12 : discountList.length;
			for(var i=0;i<discountList.length;i++){
				var a=$("<a href=details?id="+discountList[i].id+"></a>").appendTo($('.discount'));
				var div=$('<div></div>');
				div.appendTo(a).addClass("newpro").append("<img src="+discountList[i].picture+">").append($('<div></div>'));
				div.children("div").addClass("newinfo").append("<h4><span>商品名：</span>"+discountList[i].goodsname+"/</h4>").append("<h4><span>分类：</span>"+discountList[i].type.typename+"</h4>").append("<i>现价："+parseFloat(discountList[i].nowprice).toFixed(2)+"元</i>").append("<em>原价："+parseFloat(discountList[i].price).toFixed(2)+"元</em>");
			}
			
		}
	})
	
	//注册表单验证
	$('.auth').data({'s':0});
	$('.form_bd input[name=username]').bind('focus',focusFn);
	$('.form_bd input[name=password]').bind('focus',focusFn);
	$('.form_bd input[name=repassword]').bind('focus',focusFn);
	$('.form_bd input[name=phone]').bind('focus',focusFn);
	$('.form_bd input[name=email]').bind('focus',focusFn);
	function focusFn() {
		this.value="";
	}
	$('.form_bd input[name=username]').blur(function(){
		username=this.value.replace(/\s+/g, "");
		if(username.length<2){
			$(this).data({'s':0});
			$('.error').show().html('用户名不能少于两位字符！');
		}
		else{
			$(this).data({'s':1});
			$('.error').hide();
		}
	});
	$('.form_bd input[name=password]').blur(function(){
		password=this.value.replace(/\s+/g, "");
		if(password.length<6){
			$(this).data({'s':0});
			$('.error').show().html('密码长度不能少于六位字符！');
		}
		else{
			$(this).data({'s':1});
			$('.error').hide();
		}
	});
	$('.form_bd input[name=repassword]').blur(function(){
		repassword=this.value;
		if(repassword!=password){
			$(this).data({'s':0});
			$('.error').show().html('两次输入的密码不一致！');
		}
		else{
			$(this).data({'s':1});
			$('.error').hide();
		}
	});
	$('.form_bd input[name=tel]').blur(function(){
		tel=this.value;
		if(!/(^[1][359][0-9]{9})$/.test(tel)){
			$(this).data({'s':0});
			$('.error').show().html('电话号码格式不正确！');
		}
		else{
			$(this).data({'s':1});
			$('.error').hide();
		}
	});
	$('.form_bd input[name=email]').blur(function(){
		email=this.value;
		if(!/^[0-9a-zA-Z.-_]+[@][0-9a-zA-Z.-_]+([.][a-zA-Z]+){1,2}$/.test(email)){
			$(this).data({'s':0});
			$('.error').show().html('邮箱格式不正确！');
		}
		else{
			$(this).data({'s':1});
			$('.error').hide();
		}
	});
	//点击注册发送请求
	$('form [name=register_btn]').click(function(){
		$('.auth').blur();
		tot=0;
		$('.auth').each(function(){
			tot+=$(this).data('s');
		})
		if (tot!=5) {
			return false;
		}
		$.post({
			url:"member/register",
			data:{username:username,password:password,tel:tel,email:email},
			success:function(res){	
				console.log(res);
				if(res.registerMessage=="注册成功"){
					alert("恭喜您，注册成功！");
					$('.close').click();
				}
				else{
					alert("该用户名已存在，请重新注册");		
					$('.form_bd input[name=username]').val("");
					$('.form_bd input[name=password]').val("");
					$('.form_bd input[name=repassword]').val("");
				}
				
			}
		})
	});
	
	//登录
	$('.toLogin').on('click',function(){
		$("#login").show();
		$('.mask').show();
	})
	$('#login .close').on('click',function(){
		$("#login").hide();
		$('.mask').hide();
	})
	//登录表单验证
	$('.loginauth').data({'l':0});
	$('.loginform_bd input[name=username]').bind('focus',focusFn);
	$('.loginform_bd input[name=password]').bind('focus',focusFn);
	$('.loginform_bd input[name=username]').blur(function(){
		username=this.value.replace(/\s+/g, "");
		if(username.length<2){
			$(this).data({'l':0});
			$('.login_error').show().html('用户名不能少于两位字符！');	
		}
		else{
			$(this).data({'l':1});
			$('.login_error').hide();
		}
	});
	$('.loginform_bd input[name=password]').blur(function(){
		password=this.value.replace(/\s+/g, "");
		if(password.length<6){
			$(this).data({'l':0});
			$('.login_error').show().html('密码长度不能少于六位字符！');
		}
		else{
			$(this).data({'l':1});
			$('.error').hide();
			$('.login_error').hide();
		}
	});
	//点击登录发送请求
	$('form [name=login_btn]').click(function(){
		$('.loginauth').blur();
		count=0;
		$('.loginauth').each(function(){
			count+=$(this).data('l');
		})
		if (count!=2) {
			return false;
		}
		$.post({
			url:"member/login",
			data:{username:username,password:password},
			success:function(res){			
				console.log(res);
				if(res.loginMessage=="登录成功"){
					alert("恭喜您，登录成功！");
					$('#login .close').click();
					document.location.reload();
				}
				else{
					alert("登录失败，请重新登录！");		
					$('.loginform_bd input[name=username]').val("");
					$('.loginform_bd input[name=password]').val("");
				}			
			}
		})
	})

})