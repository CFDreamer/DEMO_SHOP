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
	 * �������Ʒ�ڹ��ﳵ�����ڣ��������һ����¼ �����ﳵ�����Ʒ ����������count�������¸�ֵ
	 * 
	 */
	public void addCar(Integer memberid, Integer goodsid, Integer count) {
		Goods g = null;
		Car car = null;
		System.out.println("bug!");
		car = cmapper.selectCarGoods(goodsid,memberid);
		System.out.println("bug2");
		// ���goodsname="",˵�������ڸ���Ʒ��������¼
		if (null == car) {
			System.out.println("������Ʒ");
			// ��ȡ��goodid��������Ϣ

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
		// �������Ʒ���ڵĻ������޸�����count
		else {
			System.out.println("�޸�Count");
			cmapper.updateGoodsCount(goodsid, count,memberid);
		}
	}

	/**
	 * ��ȡ�û��Ĺ��ﳵ��Ϣ
	 */
	public List<Car> selectMemberCar(Integer memberid) {
		return cmapper.selectMemberCar(memberid);
	}

	/**
	 * ����û��Ĺ��ﳵ������ɾ������ĳһ����Ʒ
	 */
	public void deleteMemberCarOrSomeGoods(Integer memberid,List<Integer> goodsidList) {
		cmapper.deleteMemberCarOrSomeGoods(memberid, goodsidList);
	}
	/**
	 * ��ȡ�û���Ԥ���嵥
	 */
	public List<Car> selectMemberPurchaseList(Integer memberid,List<Integer> goodsidList){
		return cmapper.selectMemberPurchaseList(memberid, goodsidList);
	}
	/**
	 * ����Ԥ���嵥
	 */
	@Transactional(propagation=Propagation.REQUIRED,
			isolation=Isolation.READ_COMMITTED)
	public void PurchaseListBalance(Member mb,String bz,List<Integer> goodsidList,Integer addressid,double allprice) {
		//���ɲ��ظ��Ķ������
		String orderid="";
		for(;;) {
			orderid=OrderTool.getOrderid();
			if(oService.selectOrderidIsExist(orderid)) 
				orderid=OrderTool.getOrderid();
			else
				break;	
		}
		//���붩����
		oService.insertOrder(mb.getUsername(), orderid, addressid, allprice, bz, goodsidList.size());
		//���붩�������
		odService.insertOrder_detailMapper(mb.getId(), orderid, goodsidList);
		//ɾ��ԭ�й��ﳵ������
		cmapper.deleteMemberCarOrSomeGoods(mb.getId(), goodsidList);
	}
}
