package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Goods;
import com.mapper.GoodsMapper;

@Service
public class GoodsService {
	@Autowired
   private GoodsMapper mapper;
	/**
	 * 查询新商品
	 * @return
	 */
	public List<Goods> selectNewGoods(String typename){
		return mapper.selectNewGoods(typename);
	}
	/**
	 * 查询折扣商品
	 */
	public List<Goods> selectDiscountGoods(String typename){
		
		return mapper.selectDiscountGoods(typename);
	}
	/**
	 * 热卖商品
	 */
	public List<Goods> selectHotGoods(){
		return mapper.selectHotGoods();
	}
	/**
	 * 商品详情
	 */
	public Goods selectDetailsByID(Integer id) {
		return mapper.selectDetailsByID(id);
	}
	/**
	 * 查询该商品的同类商品
	 */
	public List<Goods> selectSimilar(Integer id){
		return mapper.selectSimilar(id);
	}
	/**
	 * 点击商品详情，点击次数+1
	 */
	public void updateGoodsHit(Integer id) {
		mapper.updateGoodsHit(id);
	}
}
