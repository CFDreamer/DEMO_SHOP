package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.ReceiptAddress;
import com.mapper.ReceiptAddressMapper;

/**
 * �û��ջ���ַservice
 * 
 * @author ��С��
 *
 */
@Service
public class ReceiptAddressService {
	@Autowired
	private ReceiptAddressMapper mapper;

	/**
	 * ��ѯ�û�ʹ�ô������ĵ�ַ
	 */
	public ReceiptAddress selectMaxMemberAddressUsecount(Integer memberid) {
		ReceiptAddress r = null;
		try {
			r = mapper.selectMaxMemberAddressUsecount(memberid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// û�ó��õ�ַ���ؿ�
		return r;
	}

	/**
	 * ��ȡ�û���ȫ���ջ���ַ������ʹ�ô����Ľ������У�
	 */
	public List<ReceiptAddress> selectMemberAddress(Integer memberid) {
		List<ReceiptAddress> list = null;
		try {
			list = mapper.selectMemberAddress(memberid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	/**
	 * �����µĵ�ַ
	 */
	public void insertMemberAddress(ReceiptAddress address) {
		mapper.insertMemberAddress(address);
	}

	/**
	 * ɾ���û��ջ���ַ
	 */
	public void deleteMemberRecAddress(Integer id) {
		mapper.deleteMemberRecAddress(id);
	}
	
	/**
	 * ����id��ѯ�ջ���ַ
	 */
	public ReceiptAddress selectMemberRecAddressByID(Integer id) {
		return mapper.selectMemberRecAddressByID(id);
	}
}
