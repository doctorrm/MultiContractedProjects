package com.souvc.weixin.util;

import java.sql.SQLException;
/**
 * ����:Test
 * ����:����Ĳ����õĵ����࣬������ڡ�<br>
 * ������:doctor<br>
 * <a href="http://www.baidu.com">��������ٶ�</a>
 */
public class Test {
	public static void main(String[] args) throws SQLException{
		JDBCConnection jc=new JDBCConnection();
		String result=jc.getStringa();
		System.out.println(result);
	}
}
