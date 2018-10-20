package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.entity.Member;
import com.entity.ReceiptAddress;
import com.service.ReceiptAddressService;

/**
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/receiptAddress")
@SessionAttributes(types={Member.class})
public class ReceiptAddressController {
	@Autowired
	private ReceiptAddressService rService;
   /**
    * 渲染地址页面
    */
	@RequestMapping("memberAddress")
	public ModelAndView memberAddress(@ModelAttribute("memberInfo") Member mb){
		ModelAndView m = new ModelAndView();
		List<ReceiptAddress> receiptAddressList=rService.selectMemberAddress(mb.getId());
		m.addObject("receiptAddressList", receiptAddressList);
		m.setView(new MappingJackson2JsonView());
		return m;

	}
	/**
	 * 新增用户地址
	 */
	@RequestMapping("addMemberAddress")
	public ModelAndView addMemberAddress(@ModelAttribute("memberInfo") Member mb,ReceiptAddress address) {
		System.out.println(address);
		ReceiptAddress add=new ReceiptAddress();
		ModelAndView m=new ModelAndView();
		add.setAddress(address.getAddress());
		add.setMemberid(mb.getId());
		add.setReceviename(address.getReceviename());
		add.setTel(address.getTel());
		rService.insertMemberAddress(add);
		m.addObject("message", "新增成功");
		m.setView(new MappingJackson2JsonView());
		return m;	
	}
	/**
	 * 删除用户地址
	 */
	@RequestMapping("deleteMemberRecAddress")
	public ModelAndView deleteMemberRecAddress(Integer id) {
		ModelAndView m=new ModelAndView();
		rService.deleteMemberRecAddress(id);
		m.addObject("message","成功");
		m.setView(new MappingJackson2JsonView());
		return m;
	}
	
}
