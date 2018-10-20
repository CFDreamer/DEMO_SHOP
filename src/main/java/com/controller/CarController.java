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
 * ���ﳵ�Ŀ�����
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
	 * ���������޸��û����ﳵ
	 */
	@RequestMapping("addCar")
	public ModelAndView addOrUpdateCar(@ModelAttribute("memberInfo") Member mb, Integer goodsid, Integer count) {
		System.out.println("addCar");
		String addCarMessage = "";
		ModelAndView m = new ModelAndView();
		service.addCar(mb.getId(), goodsid, count);
		addCarMessage = "�ɹ�";
		m.addObject("addCarMessage", addCarMessage);
		m.setView(new MappingJackson2JsonView());
		return m;
	}

	/**
	 * ��ȡ�û����ﳵ��Ϣ
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
	 * ����û��Ĺ��ﳵ������ɾ������ĳһ����Ʒ ֻ����Post����
	 */
	@RequestMapping(value = "deleteMemberCarOrSomeGoods", method = RequestMethod.POST)
	public ModelAndView deleteMemberCarOrSomeGoods(@ModelAttribute("memberInfo") Member mb,
			@RequestBody List<Integer> goodsidList) {
		ModelAndView m = new ModelAndView();
		System.out.println(goodsidList);
		List<Integer> list = null;
		list = goodsidList;
		String deleteMessage = "ɾ���ɹ�";
		System.out.println("ɾ�����ﳵ");
		service.deleteMemberCarOrSomeGoods(mb.getId(), list);
		m.addObject("deleteMessage", deleteMessage);
		m.setView(new MappingJackson2JsonView());
		return m;
	}

	/**
	 * ��Ⱦ�û���Ԥ���嵥
	 */
	@RequestMapping(value = "selectMemberPurchaseList1")
	public ModelAndView selectMemberPurchaseList1(@ModelAttribute("memberInfo") Member mb,
			@ModelAttribute("memberPurchaseList")  GoodidsList list,
			@ModelAttribute("memberRecAddressid") Integer memberRecAddressid) {
		//Ԥ������ҳ����ջ���ַ
		System.out.println(memberRecAddressid);
		ReceiptAddress memberAddress=null;
		//���==0˵���û�û��ѡ���ַ��Ĭ��ѡ��ʹ�ô�������
		if(memberRecAddressid==0) {
			// �û��ĳ����ջ���ַ
			memberAddress = rService.selectMaxMemberAddressUsecount(mb.getId());
		}
		//��=0�û�����ѡ��ĵ�ַ
		else {
			System.out.println("����ѡ��");
			memberAddress=rService.selectMemberRecAddressByID(memberRecAddressid);
		}
		List<Integer> goodsidList=list.getList();
		
		ModelAndView m = new ModelAndView();
		// �û���Ԥ����Ʒ
		String message = "�ɹ�";
		System.out.println("Ԥ���嵥");
		System.out.println(goodsidList);
		List<Car> memberPurchaseList = service.selectMemberPurchaseList(mb.getId(), goodsidList);
		m.addObject("memberPurchaseList", memberPurchaseList);
		m.addObject("memberAddress", memberAddress);
		m.addObject("message", message);
		m.setView(new MappingJackson2JsonView());
		return m;
	}

	/**
	 * �����û�Ԥ���嵥����Ʒid
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
		m.addObject("message", "����ɹ�");
		m.setView(new MappingJackson2JsonView());
		return m;
	}
	
	/**
	 * �����û����ջ���ַid��ת����selectMemberPurchaseList1��Ⱦҳ��
	 */
	@RequestMapping("selectMemberPurchaseList")
	public String saveRecAddressid(ModelMap m,Integer addressid) {
		m.addAttribute("memberRecAddressid",addressid);
		System.out.println(addressid);
		return "redirect:selectMemberPurchaseList1";
	}
	/**
	 * Ԥ���嵥�Ľ���
	 */
	@RequestMapping("purchaseListBalance")
	public ModelAndView  PurchaseListBalance(@ModelAttribute("memberInfo") Member mb,
			@ModelAttribute("memberPurchaseList")  GoodidsList list,
			String bz,Integer addressid,double allprice) {
		ModelAndView m=new ModelAndView();
		service.PurchaseListBalance(mb, bz, list.getList(), addressid, allprice);
		m.addObject("message", "�ɹ��ύ����");
		m.setView(new MappingJackson2JsonView());
		return m;
	}

	
	/**
	 * ��ת��orderҳ��
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
