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
	 * �����û��������飬��������Ʒ������������
	 */
	public void insertOrder_detailMapper(Integer memberid,String orderid, List<Integer> goodsidList) {
		//��װ����Ʒ�����List
		List<Order_detail> list=new ArrayList<Order_detail>();
		Car c=null;
		Order_detail order_d=null;
		for (Integer integer : goodsidList) {
			//��ѯ����Ʒ����Ϣ
			c=cmapper.selectCarGoods(integer, memberid);
			//ʵ����һ����Ʒ��������
			order_d=new Order_detail();
			
			order_d.setOrderid(orderid);
			order_d.setGoodsname(c.getGoodsname());
			order_d.setNumber(c.getCount());
			order_d.setOrderid(orderid);
			order_d.setPicture(c.getPicture());
			order_d.setPrice(c.getPrice());	
			//��ӵ���Ʒ����ļ���
			list.add(order_d);
		}
		//����������Ʒ������
		odmapper.insertOrder_detailMapper(list);
	}

	/**
	 * ��ѯ��Ӧ������ŵ���Ʒ����
	 */
	
	 public List<Order_detail> selectOrder_detailByOrderid(String orderid){
		 return odmapper.selectOrder_detailByOrderid(orderid);
	 }
}
