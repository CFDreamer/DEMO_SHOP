package com.tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.junit.Test;



/**
 * 订单表的工具类
 * @author 陈小锋
 *
 */
public class OrderTool {
  private static String orderid="";
  /**
   * 随机生成订单编号
   */
  public static String getOrderid() {
	  String s[]=new String[] {"0","1","2","3","4","5","6","7","8","9"};
	  Random r=new Random();
	  Date date=new Date();
	  SimpleDateFormat formatter=new SimpleDateFormat("yyyyMMdd");
	  orderid=formatter.format(date);
	  for(int i=0;i<=6;i++) {
		  orderid=orderid+s[r.nextInt(10)];
	  }
	  return orderid;
  }
  @Test
  public void test() {
	  System.out.println(getOrderid());
  }
}
