package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Car;

/**
 * ���ﳵ��mapper
 * @author ��С��
 *
 */
public interface CarMapper {
   /**
    * �����¼�����ﳵ
    */
	public void addCar(@Param("car") Car c);
	
	/**
	 * ��ѯ���û����ﳵ���Ƿ����ĳ����Ʒ
	 */
	public Car selectCarGoods(@Param("goodsid")Integer goodsid,@Param("memberid") Integer memberid);
	/**
	 * �����û����ﳵ�е���Ʒ����
	 */
	public void updateGoodsCount(@Param("goodsid") Integer goodsid,@Param("count") Integer count,@Param("memberid") Integer memberid);
	/**
	 * ��ȡĳ�û��Ĺ��ﳵ
	 */
	public List<Car> selectMemberCar(Integer memberid);
	/**
	 * ����û��Ĺ��ﳵ������ɾ������ĳһ����Ʒ
	 */
	public void deleteMemberCarOrSomeGoods(@Param("memberid") Integer memberid,@Param("goodsidList") List<Integer> goodsidList);
	
	/**
	 * ��ѯ�û���Ԥ���嵥
	 */
	public List<Car> selectMemberPurchaseList(@Param("memberid") Integer memberid,@Param("goodsidList") List<Integer> goodsidList);
}
