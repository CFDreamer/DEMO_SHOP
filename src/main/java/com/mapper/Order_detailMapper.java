package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Order_detail;

/**
 * ���������mapper
 * @author ��С��
 *
 */
public interface Order_detailMapper {
   /**
    * �����û��������飬��������Ʒ������������
    */
	public void insertOrder_detailMapper(@Param("Order_detailList") List<Order_detail> Order_detailList );
	
	/**
	 * ��ѯ��Ӧ������ŵ���Ʒ����
	 */
	
	 public List<Order_detail> selectOrder_detailByOrderid(@Param("orderid") String orderid);
}
