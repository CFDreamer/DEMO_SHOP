package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.ReceiptAddress;

/**
 * �û��ջ���ַmapper
 * @author ��С��
 *
 */
public interface ReceiptAddressMapper {
   /**
    *�����µĵ�ַ
    */
   public void insertMemberAddress(@Param("address") ReceiptAddress address) ; 
   
   /**
    * ʹ��һ���ջ���ַ���õ�ַ��ʹ�ô���+1
    */
   public void updateMemberAddressUsercount(@Param("id") Integer id);
   
   /**
    * ��ȡ�û���ȫ���ջ���ַ������ʹ�ô����Ľ������У�
    */
   public List<ReceiptAddress> selectMemberAddress(@Param("memberid") Integer memberid);
   
   /**
    * ��ѯ�û�ʹ�ô������ĵ�ַ
    */
   public ReceiptAddress selectMaxMemberAddressUsecount(@Param("memberid") Integer memberid);
   
   /**
    * ɾ���ջ���ַ
    */
   public void deleteMemberRecAddress(@Param("id") Integer id);
   /**
    * ����id��ѯ�ջ���ַ
    */
   public ReceiptAddress selectMemberRecAddressByID(@Param("id") Integer id);
}
