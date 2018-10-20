package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.entity.Goods;
import com.entity.Member;
import com.service.GoodsService;

@Controller
@RequestMapping("")
@SessionAttributes(types={Member.class})
public class GoodsController {
   /**
    * 首页信息
    */
	@Autowired
	private GoodsService service;
	@RequestMapping("index1")
	public ModelAndView index(@RequestParam(value="typename" ,required=false) String typename) {
		ModelAndView m=new ModelAndView();
		System.out.println(typename);
		long s1=System.currentTimeMillis();
		//最新商集合
		List<Goods> newgoodsList=service.selectNewGoods(typename);
		//折扣商品集合
		List<Goods> discountList=service.selectDiscountGoods(typename);
		//热门商品集合
		List<Goods> hotList=service.selectHotGoods();
		
		long s2=System.currentTimeMillis();
		System.out.println("time"+(s2-s1));
		m.addObject("newgoodsList",newgoodsList);
		m.addObject("discountList", discountList);
		m.addObject("hotList", hotList);
		//返回JSON视图
		m.setView(new MappingJackson2JsonView());
		return m;
	}
	/**
	 * 商品详情
	 */
	@RequestMapping("details")
	public ModelAndView GoodDetails(@RequestParam("id") Integer id) {
		ModelAndView m=new ModelAndView();
		
		// 该商品的详情
		Goods g=service.selectDetailsByID(id);
		//商品的点击次数+1
		service.updateGoodsHit(id);
		//该商品的同类商品
		List<Goods> similarGoodsList=service.selectSimilar(id);
		System.out.println(g);
		m.addObject("goods", g);
		m.addObject("similarGoodsList", similarGoodsList);
		System.out.println(id);
		//m.setView(new MappingJackson2JsonView());
		m.setViewName("prodetails");
		return m;
	}
	@RequestMapping("first")
	public ModelAndView test(){
		ModelAndView m=new ModelAndView();
		m.setViewName("index");
		return m;
	}


	
}
