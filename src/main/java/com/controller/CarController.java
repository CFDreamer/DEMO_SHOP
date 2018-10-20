package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.entity.Car;
import com.entity.GoodidsList;
import com.entity.Member;
import com.entity.ReceiptAddress;
import com.service.CarService;
import com.service.ReceiptAddressService;

/**
 * 购物车的控制器
 */
@Controller
@RequestMapping("/car")
@SessionAttributes(types = { Member.class ,GoodidsList.class},value={"memberRecAddressid"})
public class CarController {
	@Autowired
	private CarService service;
	@Autowired
	private ReceiptAddressService rService;

	/**
	 * 新增或者修改用户购物车
	 */
	@RequestMapping("addCar")
	public ModelAndView addOrUpdateCar(@ModelAttribute("memberInfo") Member mb, Integer goodsid, Integer count) {
		System.out.println("addCar");
		String addCarMessage = "";
		ModelAndView m = new ModelAndView();
		service.addCar(mb.getId(), goodsid, count);
		addCarMessage = "成功";
		m.addObject("addCarMessage", addCarMessage);
		m.setView(new MappingJackson2JsonView());
		return m;
	}

	/**
	 * 获取用户购物车信息
	 */
	@RequestMapping("selectMemberCar")
	public ModelAndView selectMemberCar(@ModelAttribute("memberInfo") Member mb) {
		ModelAndView m = new ModelAndView();
		List<Car> memberCarList = service.selectMemberCar(mb.getId());
		m.addObject("memberCarList", memberCarList);
		m.setView(new MappingJackson2JsonView());
		return m;
	}

	/**
	 * 清空用户的购物车，或者删除他的某一件商品 只接受Post请求
	 */
	@RequestMapping(value = "deleteMemberCarOrSomeGoods", method = RequestMethod.POST)
	public ModelAndView deleteMemberCarOrSomeGoods(@ModelAttribute("memberInfo") Member mb,
			@RequestBody List<Integer> goodsidList) {
		ModelAndView m = new ModelAndView();
		System.out.println(goodsidList);
		List<Integer> list = null;
		list = goodsidList;
		String deleteMessage = "删除成功";
		System.out.println("删除购物车");
		service.deleteMemberCarOrSomeGoods(mb.getId(), list);
		m.addObject("deleteMessage", deleteMessage);
		m.setView(new MappingJackson2JsonView());
		return m;
	}

	/**
	 * 渲染用户的预购清单
	 */
	@RequestMapping(value = "selectMemberPurchaseList1")
	public ModelAndView selectMemberPurchaseList1(@ModelAttribute("memberInfo") Member mb,
			@ModelAttribute("memberPurchaseList")  GoodidsList list,
			@ModelAttribute("memberRecAddressid") Integer memberRecAddressid) {
		//预购订单页面的收货地址
		System.out.println(memberRecAddressid);
		ReceiptAddress memberAddress=null;
		//如果==0说明用户没有选择地址，默认选择使用次数最多的
		if(memberRecAddressid==0) {
			// 用户的常用收货地址
			memberAddress = rService.selectMaxMemberAddressUsecount(mb.getId());
		}
		//！=0用户自行选择的地址
		else {
			System.out.println("自行选择");
			memberAddress=rService.selectMemberRecAddressByID(memberRecAddressid);
		}
		List<Integer> goodsidList=list.getList();
		
		ModelAndView m = new ModelAndView();
		// 用户的预购商品
		String message = "成功";
		System.out.println("预购清单");
		System.out.println(goodsidList);
		List<Car> memberPurchaseList = service.selectMemberPurchaseList(mb.getId(), goodsidList);
		m.addObject("memberPurchaseList", memberPurchaseList);
		m.addObject("memberAddress", memberAddress);
		m.addObject("message", message);
		m.setView(new MappingJackson2JsonView());
		return m;
	}

	/**
	 * 保存用户预购清单的商品id
	 * 
	 * @param goodsidList
	 * @return
	 */
	@RequestMapping(value = "saveMemberPurchaseList")
	public ModelAndView saveMemberPurchaseList(@RequestBody List<Integer> list) {;
		GoodidsList goodsidList=new GoodidsList();
		goodsidList.setList(list);
		System.out.println(goodsidList);
		ModelAndView m = new ModelAndView();
		m.addObject("memberPurchaseList", goodsidList);
		m.addObject("message", "保存成功");
		m.setView(new MappingJackson2JsonView());
		return m;
	}
	
	/**
	 * 保存用户的收货地址id，转发到selectMemberPurchaseList1渲染页面
	 */
	@RequestMapping("selectMemberPurchaseList")
	public String saveRecAddressid(ModelMap m,Integer addressid) {
		m.addAttribute("memberRecAddressid",addressid);
		System.out.println(addressid);
		return "redirect:selectMemberPurchaseList1";
	}
	/**
	 * 预购清单的结算
	 */
	@RequestMapping("purchaseListBalance")
	public ModelAndView  PurchaseListBalance(@ModelAttribute("memberInfo") Member mb,
			@ModelAttribute("memberPurchaseList")  GoodidsList list,
			String bz,Integer addressid,double allprice) {
		ModelAndView m=new ModelAndView();
		service.PurchaseListBalance(mb, bz, list.getList(), addressid, allprice);
		m.addObject("message", "成功提交订单");
		m.setView(new MappingJackson2JsonView());
		return m;
	}

	
	/**
	 * 跳转到order页面
	 * @param cxf
	 * @param m
	 * @return
	 */
	@RequestMapping("orders")
	public String order(Integer cxf,ModelMap m) {
		System.out.println(cxf);
		m.addAttribute("cxf", cxf);
		return "orders";
	}
}
