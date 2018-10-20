package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Order_detail;

/**
 * 订单详情的mapper
 * @author 陈小锋
 *
 */
public interface Order_detailMapper {
   /**
    * 插入用户订单详情，购买多个商品就是批量插入
    */
	public void insertOrder_detailMapper(@Param("Order_detailList") List<Order_detail> Order_detailList );
	
	/**
	 * 查询对应订单编号的商品详情
	 */
	
	 public List<Order_detail> selectOrder_detailByOrderid(@Param("orderid") String orderid);
}
