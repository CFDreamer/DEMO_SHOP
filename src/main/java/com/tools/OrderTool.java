package com.tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.junit.Test;



/**
 * ������Ĺ�����
 * @author ��С��
 *
 */
public class OrderTool {
  private static String orderid="";
  /**
   * ������ɶ������
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
