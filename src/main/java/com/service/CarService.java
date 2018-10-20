package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Car;
import com.entity.Goods;
import com.entity.Member;
import com.mapper.CarMapper;
import com.mapper.GoodsMapper;
import com.tools.OrderTool;

@Service
public class CarService {
	@Autowired
	private GoodsMapper gmapper;
	@Autowired
	private CarMapper cmapper;
	@Autowired
	private OrderService oService;
	@Autowired
	private Order_detailService odService;

	/**
	 * 如果该商品在购物车不存在，则新添加一条记录 往购物车添加商品 如果存在则给count属性重新赋值
	 * 
	 */
	public void addCar(Integer memberid, Integer goodsid, Integer count) {
		Goods g = null;
		Car car = null;
		System.out.println("bug!");
		car = cmapper.selectCarGoods(goodsid,memberid);
		System.out.println("bug2");
		// 如果goodsname="",说明不存在该商品，新增记录
		if (null == car) {
			System.out.println("新增商品");
			// 获取该goodid的其他信息

			g = gmapper.selectDetailsByID(goodsid);

			Car c = new Car();
			c.setCount(count);
			c.setGoodid(goodsid);
			c.setGoodsname(g.getGoodsname());
			c.setMemberid(memberid);
			c.setPicture(g.getPicture());
			c.setPrice(g.getPrice());
			cmapper.addCar(c);
		}
		// 如果该商品存在的话，则修改他的count
		else {
			System.out.println("修改Count");
			cmapper.updateGoodsCount(goodsid, count,memberid);
		}
	}

	/**
	 * 获取用户的购物车信息
	 */
	public List<Car> selectMemberCar(Integer memberid) {
		return cmapper.selectMemberCar(memberid);
	}

	/**
	 * 清空用户的购物车，或者删除他的某一件商品
	 */
	public void deleteMemberCarOrSomeGoods(Integer memberid,List<Integer> goodsidList) {
		cmapper.deleteMemberCarOrSomeGoods(memberid, goodsidList);
	}
	/**
	 * 获取用户的预购清单
	 */
	public List<Car> selectMemberPurchaseList(Integer memberid,List<Integer> goodsidList){
		return cmapper.selectMemberPurchaseList(memberid, goodsidList);
	}
	/**
	 * 结算预购清单
	 */
	@Transactional(propagation=Propagation.REQUIRED,
			isolation=Isolation.READ_COMMITTED)
	public void PurchaseListBalance(Member mb,String bz,List<Integer> goodsidList,Integer addressid,double allprice) {
		//生成不重复的订单编号
		String orderid="";
		for(;;) {
			orderid=OrderTool.getOrderid();
			if(oService.selectOrderidIsExist(orderid)) 
				orderid=OrderTool.getOrderid();
			else
				break;	
		}
		//插入订单表
		oService.insertOrder(mb.getUsername(), orderid, addressid, allprice, bz, goodsidList.size());
		//插入订单详情表
		odService.insertOrder_detailMapper(mb.getId(), orderid, goodsidList);
		//删除原有购物车的数据
		cmapper.deleteMemberCarOrSomeGoods(mb.getId(), goodsidList);
	}
}
