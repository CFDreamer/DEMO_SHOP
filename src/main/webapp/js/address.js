$(function(){
	//发送请求获取用户添加过的地址
	$.post({
		url:'receiptAddress/memberAddress',
		async:false,
		success:function(res){
			console.log(res);
			var receiptAddressList=res.receiptAddressList;
			if(receiptAddressList.length==0){
				$('.noaddress').css({'display':'block'});
				$('.default_address').css({'display':'none'});
				return false;
			}
			for(var i=0;i<receiptAddressList.length;i++){
				var address=$('<div></div>').addClass('address').appendTo($('.addressList')).attr("addressid",receiptAddressList[i].id);
				var address_hd=$('<div></div>').addClass('address_hd').append("<span class='name fl'>"+receiptAddressList[i].receviename+"</span>").append("<span class='tel rg'>"+receiptAddressList[i].tel+"</span>");
				var address_bd=$('<div></div>').addClass('address_bd').html(receiptAddressList[i].address);
				var line=$('<div></div>').addClass('line');
				var delete_obj=$('<div></div>').addClass('delete').append("<img src='images/delete.png'>").append("删除");
				address.append(address_hd).append(address_bd).append(line).append(delete_obj);
			}
		}
	})
	//选择地址
	$('.address').on('click',function(){
		var cxf=$(this).attr("addressid");
		document.location.href="orders.jsp?cxf="+cxf;
	})
	//新增地址
	$('.to_address').on('click',function(){
		$("#address_form").show();
		$('.mask').show();
	})
	$('#address_form .close').on('click',function(){
		$("#address_form").hide();
		$('.mask').hide();
	})
	//删除地址
	$('.delete').click(function(){
		var msg=confirm("您确定要删除吗？");
			if(msg){
				var id=$(this).parent().attr("addressid");
				$.post({
					url:'receiptAddress/deleteMemberRecAddress',
					data:{id:id},
					success:function(res){
						console.log(res);
					}
				})
				$(this).parent().remove();
			}
	})

	//选择地区省市区
	var address=$("#select_area option:selected").text();
	$("#select_area").change(function(){
		address=$("#select_area option:selected").text();
	})
	
	//新增地址表单验证
	$('.auth').data({'s':0});
	$('.form_bd input[name=receviename]').bind('focus',focusFn);
	$('.form_bd input[name=tel]').bind('focus',focusFn);
	$('.form_bd input[name=address]').bind('focus',focusFn);
	function focusFn() {
		this.value="";
	}
	$('.form_bd input[name=receviename]').blur(function(){
		receviename=this.value.replace(/\s+/g, "");
		if(receviename.length<2){
			$(this).data({'s':0});
			$('.error').show().html('收货人姓名不能少于两位字符！');	
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
	$('.form_bd input[name=address]').blur(function(){
		address_detail=this.value;
		if(address_detail.length<1){
			$(this).data({'s':0});
			$('.error').show().html('请输入详细收货地址！');
		}
		else{
			$(this).data({'s':1});
			$('.error').hide();
		}
	});
	$('form [type=button]').click(function(){
		$('.auth').blur();
		tot=0;
		$('.auth').each(function(){
			tot+=$(this).data('s');
		})
		if (tot!=3) {
			return false;
		}
		address+=address_detail;
		console.log(receviename+"*****"+tel+"*****"+"*****"+address);
		$.post({
			url:'receiptAddress/addMemberAddress',
			data:{receviename:receviename,tel:tel,address:address},
			success:function(res){
				if(res.message=="新增成功"){
					alert("恭喜您，新增地址成功");
					document.location.reload();
				}
				else{
					alert("真不巧，您的网络走丢了，再试试！")
				}
			}
		})
	});
})