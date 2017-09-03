package com.souvc.weixin.util;

import java.sql.SQLException;
/**
 * 类名:Test
 * 描述:纯粹的测试用的单独类，随便折腾。<br>
 * 创建者:doctor<br>
 * <a href="http://www.baidu.com">点击跳到百度</a>
 */
public class Test {
	public static void main(String[] args) throws SQLException{
		JDBCConnection jc=new JDBCConnection();
		String result=jc.getStringa();
		System.out.println(result);
	}
}
