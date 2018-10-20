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
import com.entity.Order;
import com.service.OrderService;

@Controller
@RequestMapping("/order")
@SessionAttributes(types={Member.class})
public class OrderController {
	@Autowired
   private OrderService service;
	/**
	 * 查询用户的订单
	 */
	  @RequestMapping("selectOrders")
      public ModelAndView selectOrders(@ModelAttribute("memberInfo") Member mb) {
	   ModelAndView m=new ModelAndView();
	   List<Order> ordersList=service.selectOrdersByMemberUsername(mb.getUsername());
	   m.addObject("ordersList", ordersList);
	   m.setView(new MappingJackson2JsonView());
	   return m;
   }

}
