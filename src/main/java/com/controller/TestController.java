package com.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Member;
import com.entity.Order;
import com.entity.Order_detail;
import com.entity.ReceiptAddress;
import com.mapper.GoodsMapper;
import com.mapper.OrderMapper;
import com.mapper.Order_detailMapper;
import com.mapper.ReceiptAddressMapper;


@Controller
@RequestMapping("")
@SessionAttributes(types={Member.class})
public class TestController {

	
	@Autowired
	private GoodsMapper gmapper;
	@Autowired
	private OrderMapper omapper;
	@Autowired
	private Order_detailMapper odmapper;
	@Autowired
	private ReceiptAddressMapper rmapper;
//	@RequestMapping("test")
//	public ModelAndView test() {
//		ModelAndView m = new ModelAndView();
//		Order o=new Order(); 
	
//		o.setUsername("张三");
//		o.setAddress("湖北武汉");
//		o.setAllprice(1500);
//		o.setBnumber(2);
//		o.setBz("");
//		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd hh:mm");          
//		o.setOrderdate(f.format(new Date()));
//		o.setOrderid("2018101900001");
//		o.setReceviename("张三");
//		o.setTel("110");
//		try {
//		omapper.insertOrder(o);
//		}catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		m.setViewName("test");
//		return m;
//	}
//	/**
//	 * 
//	 */
//	@RequestMapping("test1")
//	public ModelAndView test1() {
//		ModelAndView m = new ModelAndView();
//		List<Order_detail> list=new ArrayList<Order_detail>();
//		list.add(new Order_detail("20181010005","花裤子",150,"images/goods/1.jpg",3));
//		list.add(new Order_detail("20181010005","短裤",150,"images/goods/1.jpg",3));
//		list.add(new Order_detail("20181010005","花书籍",150,"images/goods/1.jpg",5));
//		odmapper.insertOrder_detailMapper(list);
//		m.setViewName("test");
//		return m;
//	}
//	@RequestMapping("test2")
//	public ModelAndView test2() {
//		ModelAndView m = new ModelAndView();
//		ReceiptAddress r=new ReceiptAddress();
//		r.setAddress("湖北武汉");
//		r.setMemberid(1);
//		r.setReceviename("张三");
//		r.setTel("110");
//		//rmapper.insertMemberAddress(r);
//		//rmapper.updateMemberAddressUsercount(1);
//		//System.out.println(rmapper.selectMaxMemberAddressUsecount(2));
//		m.setViewName("test");
//		return m;
//	}
//	@RequestMapping("test3")
//	public ModelAndView test3() {
//		ModelAndView m = new ModelAndView();
//		List<ReceiptAddress> receiptAddressList=null;
//		receiptAddressList=rmapper.selectMemberAddress(1);
//		for (ReceiptAddress receiptAddress : receiptAddressList) {
//			System.out.println(receiptAddress);
//		}
//		m.setViewName("test");
//		return m;
//	}
//	@RequestMapping("test4")
//	public ModelAndView test4() {
//		ModelAndView m = new ModelAndView();
//
//		System.out.println(omapper.selectOrderidIsExist("00000"));
//		m.setViewName("test");
//		return m;
//	}
}
