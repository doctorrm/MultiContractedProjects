package com.souvc.weixin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 类名:JDBCConnection
 * 描述:只是一个测试用的另类，就是从特定数据库中获取数据，没了，单独的类。
 * @author Administrator
 *
 */
public class JDBCConnection {
	private static  String url = "jdbc:mysql://localhost:3306/jo" ;
	private static String user="root";
	private static String password="yudeqq814";	
//	private static StringBuffer sb;
	public  String getStringa() throws SQLException{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			System.out.println("can't find the driver");
			e.printStackTrace();
		}
		
		//conncet to the mysql.
		Connection con=DriverManager.getConnection(url,user,password);
		
		//query
		String sql="select * from jokes";
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		StringBuffer sb=new StringBuffer();
		while(rs.next()){
			String content=rs.getString(1)+"."+rs.getString(2);
			if(rs.isLast()){//avoid the last content is followed by a “\n”;
				sb.append(content);
			}else{			
			sb.append(content+"\n");
			}
		}
		/*while(rs!=null||pstmt!=null||con!=null){
			rs.close();pstmt.close();con.close();
			System.out.println("close");
		}dead loop,but why?*/
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) con.close();		
		return sb.toString();
	}
}
