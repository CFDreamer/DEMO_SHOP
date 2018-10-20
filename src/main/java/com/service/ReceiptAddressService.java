package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.ReceiptAddress;
import com.mapper.ReceiptAddressMapper;

/**
 * 用户收货地址service
 * 
 * @author 陈小锋
 *
 */
@Service
public class ReceiptAddressService {
	@Autowired
	private ReceiptAddressMapper mapper;

	/**
	 * 查询用户使用次数最多的地址
	 */
	public ReceiptAddress selectMaxMemberAddressUsecount(Integer memberid) {
		ReceiptAddress r = null;
		try {
			r = mapper.selectMaxMemberAddressUsecount(memberid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// 没用常用地址返回空
		return r;
	}

	/**
	 * 获取用户的全部收货地址（按照使用次数的降序排列）
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
	 * 插入新的地址
	 */
	public void insertMemberAddress(ReceiptAddress address) {
		mapper.insertMemberAddress(address);
	}

	/**
	 * 删除用户收货地址
	 */
	public void deleteMemberRecAddress(Integer id) {
		mapper.deleteMemberRecAddress(id);
	}
	
	/**
	 * 根据id查询收货地址
	 */
	public ReceiptAddress selectMemberRecAddressByID(Integer id) {
		return mapper.selectMemberRecAddressByID(id);
	}
}
