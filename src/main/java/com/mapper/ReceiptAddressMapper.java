package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.ReceiptAddress;

/**
 * 用户收货地址mapper
 * @author 陈小锋
 *
 */
public interface ReceiptAddressMapper {
   /**
    *插入新的地址
    */
   public void insertMemberAddress(@Param("address") ReceiptAddress address) ; 
   
   /**
    * 使用一次收货地址，该地址的使用次数+1
    */
   public void updateMemberAddressUsercount(@Param("id") Integer id);
   
   /**
    * 获取用户的全部收货地址（按照使用次数的降序排列）
    */
   public List<ReceiptAddress> selectMemberAddress(@Param("memberid") Integer memberid);
   
   /**
    * 查询用户使用次数最多的地址
    */
   public ReceiptAddress selectMaxMemberAddressUsecount(@Param("memberid") Integer memberid);
   
   /**
    * 删除收货地址
    */
   public void deleteMemberRecAddress(@Param("id") Integer id);
   /**
    * 根据id查询收货地址
    */
   public ReceiptAddress selectMemberRecAddressByID(@Param("id") Integer id);
}
