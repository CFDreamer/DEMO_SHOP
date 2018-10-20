package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Car;
import com.entity.Order_detail;
import com.mapper.CarMapper;
import com.mapper.Order_detailMapper;

@Service
public class Order_detailService {
	@Autowired
	private Order_detailMapper odmapper;
	@Autowired
	private CarMapper cmapper;

	/**
	 * 插入用户订单详情，购买多个商品就是批量插入
	 */
	public void insertOrder_detailMapper(Integer memberid,String orderid, List<Integer> goodsidList) {
		//封装该商品详情的List
		List<Order_detail> list=new ArrayList<Order_detail>();
		Car c=null;
		Order_detail order_d=null;
		for (Integer integer : goodsidList) {
			//查询该商品的信息
			c=cmapper.selectCarGoods(integer, memberid);
			//实例化一个商品订单详情
			order_d=new Order_detail();
			
			order_d.setOrderid(orderid);
			order_d.setGoodsname(c.getGoodsname());
			order_d.setNumber(c.getCount());
			order_d.setOrderid(orderid);
			order_d.setPicture(c.getPicture());
			order_d.setPrice(c.getPrice());	
			//添加到商品详情的集合
			list.add(order_d);
		}
		//批量插入商品的详情
		odmapper.insertOrder_detailMapper(list);
	}

	/**
	 * 查询对应订单编号的商品详情
	 */
	
	 public List<Order_detail> selectOrder_detailByOrderid(String orderid){
		 return odmapper.selectOrder_detailByOrderid(orderid);
	 }
}
