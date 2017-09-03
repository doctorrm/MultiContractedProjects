package com.souvc.weixin.test;

import java.sql.SQLException;

import org.junit.Test;

import com.souvc.weixin.util.DBUtility;

public class TestDBUtility {

    /**
    * 方法名：testgetConnection</br>
    * 详述：测试是否连接</br>
    * 开发人员：souvc </br>
    * 创建时间：2015-10-5  </br>
    * @throws SQLException
    * @throws
     */
    @Test//测试数据库的链接 
    public void testgetConnection() throws SQLException {
        System.out.println(DBUtility.getConnection());
    }

   
}