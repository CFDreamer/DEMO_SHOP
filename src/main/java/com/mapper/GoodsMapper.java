package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Goods;

public interface GoodsMapper {
	/**
	 * ��ѯȫ����Ʒ����Ϣ
	 * 
	 * @return
	 */
	public List<Goods> selectAllGoods();

	/**
	 * ��ѯ������Ʒ
	 */
	public List<Goods> selectNewGoods(@Param("typename") String typename);

	/**
	 * ��ѯ�ۿ���Ʒ
	 */
	public List<Goods> selectDiscountGoods(@Param("typename") String typename);

	/**
	 * ������Ʒ
	 */
	public List<Goods> selectHotGoods();
	/**
	 * ��Ʒ������
	 */
	public Goods selectDetailsByID(Integer id);
	/**
	 * ��ѯ����Ʒ��ͬ����Ʒ
	 */
	public List<Goods> selectSimilar(Integer id);
	/**
	 * ����ĳ����Ʒ�ĵ����
	 */
	public void updateGoodsHit(Integer id);

}
