package com.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Order;
import com.entity.ReceiptAddress;
import com.mapper.OrderMapper;
import com.mapper.ReceiptAddressMapper;

/**
 * 订单表的服务层
 * @author 陈小锋
 *
 */
@Service
public class OrderService {
	@Autowired
	private OrderMapper omapper;
	@Autowired
	private ReceiptAddressMapper rmapper;
	/**
	 * 查询订单编号是否存在
	 */
	public boolean selectOrderidIsExist(String orderid) {
		String receviename="";
		receviename=omapper.selectOrderidIsExist(orderid);
		if(null==(receviename))
			return false;
		return true;
	}
	  /**
	   * 插入订单信息
	   */
	   public void insertOrder(String username,String orderid,Integer addressid,double allprice,String bz,Integer bnumber){
		   //查询该用户的收货地址
		   ReceiptAddress address=rmapper.selectMemberRecAddressByID(addressid);
		   SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd hh:mm");
		   Order order=new Order();
		   order.setOrderid(orderid);
		   order.setAddress(address.getAddress());
		   order.setAllprice(allprice);
		   order.setBnumber(bnumber);
		   order.setBz(bz);
		   order.setOrderdate(f.format(new Date()));
		   order.setReceviename(address.getReceviename());
		   order.setTel(address.getTel());
		   order.setUsername(username);
		   //插入订单
		   omapper.insertOrder(order);
	}
	   /**
	    * 查询一个用户的订单
	    */
	   public List<Order> selectOrdersByMemberUsername(String username){
		   return omapper.selectOrdersByMemberUsername(username);
	   }

}
