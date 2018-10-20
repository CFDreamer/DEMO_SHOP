package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.entity.Member;
import com.service.MemberService;

/**
 * ��Ա������
 * 
 * @author ��С��
 *
 */
@Controller
@RequestMapping("/member")
@SessionAttributes(types={Member.class})
public class MemberController {
	@Autowired
	private MemberService service;

	/**
	 * ��Աע��
	 */
  @RequestMapping("register")
  public ModelAndView Register( Member member) {
	  ModelAndView m=new ModelAndView();
	  String registerMessage="";
	  if(service.Register(member))
		 registerMessage="ע��ɹ�";
	  else
		  registerMessage="ע��ʧ��";
	  m.addObject("registerMessage", registerMessage);
	  m.setView(new MappingJackson2JsonView());
	  return m;
	  
  }
  /**
   * ��Ա��¼
   */
  @RequestMapping("login")
  public ModelAndView Login(String username,String password) {
	  System.out.println(username+" "+password);
	  ModelAndView m=new ModelAndView();
	  String loginMessage="";
	  if(service.login(username, password))
	  {
		  loginMessage="��¼�ɹ�";
		  //��ȡ��Ա��Ϣ
		  
		  Member mb=service.selectMemberInfoByUsername(username);
		  //�����û���Ϣ
		  System.out.println(mb);
		  m.addObject("memberInfo", mb);
	  }
	  else
	      loginMessage="��¼ʧ��";
	  m.addObject("loginMessage", loginMessage);
	  m.setView(new MappingJackson2JsonView());
	  return m;
  }
  /**
   * �˳�
   */
  @RequestMapping("logout")
  public ModelAndView logout() {
	  String logoutMessage="ע���ɹ�";
	  ModelAndView m=new ModelAndView();
	  Member mb=null;
	  m.addObject("logoutMessage",logoutMessage);
	  //�ÿ��û�����
	  m.addObject("memberInfo",mb);
	  m.setView(new MappingJackson2JsonView());
	  return m;
	  
  }

 
}
