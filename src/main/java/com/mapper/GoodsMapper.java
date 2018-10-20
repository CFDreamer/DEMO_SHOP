package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Goods;

public interface GoodsMapper {
	/**
	 * 查询全部商品的信息
	 * 
	 * @return
	 */
	public List<Goods> selectAllGoods();

	/**
	 * 查询是新商品
	 */
	public List<Goods> selectNewGoods(@Param("typename") String typename);

	/**
	 * 查询折扣商品
	 */
	public List<Goods> selectDiscountGoods(@Param("typename") String typename);

	/**
	 * 热门商品
	 */
	public List<Goods> selectHotGoods();
	/**
	 * 商品的详情
	 */
	public Goods selectDetailsByID(Integer id);
	/**
	 * 查询该商品的同类商品
	 */
	public List<Goods> selectSimilar(Integer id);
	/**
	 * 增加某件商品的点击数
	 */
	public void updateGoodsHit(Integer id);

}
