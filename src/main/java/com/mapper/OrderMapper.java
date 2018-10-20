package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Order;

/**
 * �������mapper
 * @author ��С��
 *
 */
public interface OrderMapper {
   /**
    * ��ѯ��������Ƿ����
    */
   public String selectOrderidIsExist(@Param("orderid") String orderid) ;
   
   /**
    * ���붩����Ϣ
    */
   public void insertOrder(@Param("order") Order order);
   /**
    * ��ѯĳ�û���ȫ������
    */
   public List<Order> selectOrdersByMemberUsername(@Param("username") String username);

}
