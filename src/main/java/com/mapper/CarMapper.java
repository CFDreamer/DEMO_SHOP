package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Car;

/**
 * 购物车的mapper
 * @author 陈小锋
 *
 */
public interface CarMapper {
   /**
    * 插入记录到购物车
    */
	public void addCar(@Param("car") Car c);
	
	/**
	 * 查询该用户购物车中是否存在某件商品
	 */
	public Car selectCarGoods(@Param("goodsid")Integer goodsid,@Param("memberid") Integer memberid);
	/**
	 * 更新用户购物车中的商品数量
	 */
	public void updateGoodsCount(@Param("goodsid") Integer goodsid,@Param("count") Integer count,@Param("memberid") Integer memberid);
	/**
	 * 获取某用户的购物车
	 */
	public List<Car> selectMemberCar(Integer memberid);
	/**
	 * 清空用户的购物车，或者删除他的某一件商品
	 */
	public void deleteMemberCarOrSomeGoods(@Param("memberid") Integer memberid,@Param("goodsidList") List<Integer> goodsidList);
	
	/**
	 * 查询用户的预购清单
	 */
	public List<Car> selectMemberPurchaseList(@Param("memberid") Integer memberid,@Param("goodsidList") List<Integer> goodsidList);
}
