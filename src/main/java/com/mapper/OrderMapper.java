package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Order;

/**
 * 订单表的mapper
 * @author 陈小锋
 *
 */
public interface OrderMapper {
   /**
    * 查询订单编号是否存在
    */
   public String selectOrderidIsExist(@Param("orderid") String orderid) ;
   
   /**
    * 插入订单信息
    */
   public void insertOrder(@Param("order") Order order);
   /**
    * 查询某用户的全部订单
    */
   public List<Order> selectOrdersByMemberUsername(@Param("username") String username);

}
