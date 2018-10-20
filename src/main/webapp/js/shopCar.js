$(function(){
	$.ajax({
		url:'car/selectMemberCar',
		type:'post',
		async:false,//同步
		success:function(res){
			var memberCarList=res.memberCarList;
			if(memberCarList==""){
				$('thead').css({'display':'none'});
				$('.no_goods').css({"display":"block"});
				$('#foot').css({'display':'none'});
				return false;
			}
			//动态创建每一行元素
			for(var i=0;i<memberCarList.length;i++){
				var tr=$('<tr></tr>');
				var checkbox_td=$('<td></td>');
				var goods_td=$('<td></td>');
				var price_td=$('<td></td>');
				var count_td=$('<td></td>');
				var subtotal_td=$('<td></td>');
				var operation_td=$('<td></td>');
				checkbox_td.addClass('.checkbox').append('<input class="cehck-one check" type="checkbox">')
				goods_td.addClass('goods').attr("goodsid",memberCarList[i].goodsid).append("<img src="+memberCarList[i].picture+">").append("<span>"+memberCarList[i].goodsname+"</span>");
				price_td.addClass('price').html(memberCarList[i].price);
				count_td.addClass('count').append('<span class="reduce">-</span>').append("<input class='count-input' value="+memberCarList[i].count+" type='text' >").append('<span class="add">+</span>');
				subtotal_td.addClass('subtotal').html(memberCarList[i].price*memberCarList[i].count);
				operation_td.addClass('operation').append('<span class="delete">删除</span>');
				tr.appendTo('.tbody').append(checkbox_td).append(goods_td).append(price_td).append(count_td).append(subtotal_td).append(operation_td);
			}
		}
	})

var obj_checkbox=$('input[type=checkbox]');//获取所有的checkbox对象
var obj_checkall=$('.check-all');//获取checkbox中的全选对象
var obj_checkone=$('.check-one');//获取checkbox中的单选对象`
//商品全选与取消
for(var i=0;i<obj_checkbox.length;i++){
	obj_checkbox[i].onclick=function(){
		if(this.className.indexOf('check-all')>=0){//判断选中的checkbox是否为全选复选框
			for(var j=0;j<obj_checkbox.length;j++){
				obj_checkbox[j].checked=this.checked;//将每一个checkbox变为选中状态
			}
		}
		if(!this.checked){//如果有一个复选框没有选中
			for(var i=0;i<obj_checkall.length;i++){
				obj_checkall[i].checked=false;//更改全选复选框的状态
			}
		}

		calculate();//更新商品的总价与数量信息
	}
}
var cartTable = $('#cartTable')[0];//将jQuery转换为原生对象才能使用children[]属性
var tr = cartTable.children[1].rows;//获取tbody中的每一行
var selected = document.getElementById('selected');
var foot = document.getElementById('foot'); 	
//计算商品总价与数量
function calculate(){
	var count=0;
	var price=0;
	for(var i=0;i<tr.length;i++){//对商品的每一行信息逐行遍历
		if(tr[i].getElementsByTagName('input')[0].checked){//如果复选框为checked
			count+=parseInt(tr[i].getElementsByTagName('input')[1].value);
			price+=parseFloat(tr[i].cells[4].innerHTML);//cells表示td，其索引从0开始计算	
		}
	}
	$('#selectedTotal').html(count);
	$('#priceTotal')[0].innerHTML=price.toFixed(2);//toFixed(2),保留两位小数
}
//计算单行商品的价格
function getSubtotal(tr){
	var cells=tr.cells;
	var price=parseFloat(cells[2].innerHTML);
	var subtotal=cells[4];
	var num=parseInt(tr.getElementsByTagName('input')[1].value);
	subtotal.innerHTML=parseFloat(price*num).toFixed(2);
}

//增减商品的数量（使用事件代理，对每一行tr添加点击事件）
for(var i=0;i<tr.length;i++){
	tr[i].onclick=function(e){
		e=e || window.event;
		el=e.target || e.srcElement;
		var cls=el.className;
		var num=this.getElementsByTagName('input')[1];
		var number=parseInt(num.value);
		var reduce=this.getElementsByTagName('span')[1];//获取到当前的reduce按钮对象
		goodsid=this.children[1].getAttribute("goodsid");//获取当前商品的id
		switch(cls){
			case 'add':
			num.value=number+1;
			reduce.innerHTML='-';		
			//将添加的数量发送给后台
			count=num.value;
			$.post({
				url:'car/addCar',
				data:{goodsid:goodsid,count:count},
				success:function(res){
					console.log(res);
				}
			})
			getSubtotal(this);//更新单行小计
			break;
			case 'reduce':
			if(number>1){
				num.value=number-1;
			}
			else{
				reduce.innerHTML='';
			}
			//将减少的数量发送给后台
			count=num.value;
			$.post({
				url:'car/addCar',
				data:{goodsid:goodsid,count:count},
				success:function(res){
					console.log(res);
				}
			})
			getSubtotal(this);//更新单行小计
			break;
			case 'delete':
			var msg=confirm("您确定要删除吗？");
			if(msg){
				this.remove();
			}
			var goodsid=parseInt(goodsid);
			var goodsidList=[goodsid];
			$.post({
				url:'car/deleteMemberCarOrSomeGoods',
				data:JSON.stringify(goodsidList),
				contentType:"application/json",
				success:function(res){
					console.log(res);
				}
			})
			break;
			default:break;
		}
		calculate();//更新商品总价与数量
	}
	//手动输入数量
	tr[i].getElementsByTagName('input')[1].onkeyup=function(){
		var reduce = (this.parentNode.parentNode).getElementsByTagName('span')[1];//通过访问span的父节点后访问td的父节点得到tr
		var val=parseInt(this.value);//获取输入的数量
		 if (isNaN(val) || val <= 0) {//判断用户输入的数量是否小于0或为非数字
                val = 1;
           }
		  this.value = val;
        if(val>1){
        	reduce.innerHTML='-';
        }
        else
        	reduce.innerHTML='';
		//将手动输入的数量发送给后台
		count=this.value;
		$.post({
				url:'car/addCar',
				data:{goodsid:goodsid,count:count},
				success:function(res){
					console.log(res);
				}
			})
		getSubtotal(this.parentNode.parentNode);//更新小计
		calculate();//更新总计
	}
}
//删除多行商品信息
$('#deleteAll').click(function(){
	var goodsidList=[];
	var msg=confirm("您确定要删除吗？");
		if(msg){
			for(var i=0;i<tr.length;i++){
				if(tr[i].getElementsByTagName('input')[0].checked){
					var goodsid=parseInt(tr[i].children[1].getAttribute("goodsid"));
					goodsidList.push(goodsid);
					tr[i].remove();//当删除一行信息后后一行信息的索引向前移动一位
					i--;//当前索引减一定位到第二个需要删除的元素上
				}		
			}
			$.post({
				url:'car/deleteMemberCarOrSomeGoods',
				data:JSON.stringify(goodsidList),
				contentType:"application/json",
				success:function(res){
					console.log(res);
				}
			})
		}	
})
//默认状态下为全选
obj_checkall[0].checked=true;//让第一个全选框的默认状态为选中
obj_checkall[0].onclick();//调用全选框的click事件更新商品总计数量价格状态

//点击结算按钮
$('.closing').click(function(){
	var goodsidList=[];
	for(var i=0;i<tr.length;i++){
		if(tr[i].getElementsByTagName('input')[0].checked){
			var goodsid=parseInt(tr[i].children[1].getAttribute("goodsid"));
			goodsidList.push(goodsid);
		}		
	}
	console.log(goodsidList);
	$.post({
		url:'car/saveMemberPurchaseList',
		data:JSON.stringify(goodsidList),
		async:false,//同步
		contentType:"application/json",
		success:function(res){
			console.log(res);
		}
	})
	document.location.href="orders.jsp?cxf=0";
})

})
