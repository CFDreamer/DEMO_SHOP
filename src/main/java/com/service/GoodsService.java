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
	 * ��ѯ����Ʒ
	 * @return
	 */
	public List<Goods> selectNewGoods(String typename){
		return mapper.selectNewGoods(typename);
	}
	/**
	 * ��ѯ�ۿ���Ʒ
	 */
	public List<Goods> selectDiscountGoods(String typename){
		
		return mapper.selectDiscountGoods(typename);
	}
	/**
	 * ������Ʒ
	 */
	public List<Goods> selectHotGoods(){
		return mapper.selectHotGoods();
	}
	/**
	 * ��Ʒ����
	 */
	public Goods selectDetailsByID(Integer id) {
		return mapper.selectDetailsByID(id);
	}
	/**
	 * ��ѯ����Ʒ��ͬ����Ʒ
	 */
	public List<Goods> selectSimilar(Integer id){
		return mapper.selectSimilar(id);
	}
	/**
	 * �����Ʒ���飬�������+1
	 */
	public void updateGoodsHit(Integer id) {
		mapper.updateGoodsHit(id);
	}
}
