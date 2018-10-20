package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.entity.Order_detail;
import com.service.Order_detailService;

@Controller
@RequestMapping("/orderdetails")
public class OrderDetailsController {
   @Autowired
   private Order_detailService service;
   @RequestMapping("details")
   public ModelAndView details(String orderid) {
	   ModelAndView m=new ModelAndView();
	   List<Order_detail> list=service.selectOrder_detailByOrderid(orderid);
	   m.addObject("list", list);
	   m.setView(new MappingJackson2JsonView());
	   return m;
   }
}
