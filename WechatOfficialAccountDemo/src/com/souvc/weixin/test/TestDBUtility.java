package com.souvc.weixin.test;

import java.sql.SQLException;

import org.junit.Test;

import com.souvc.weixin.util.DBUtility;

public class TestDBUtility {

    /**
    * ��������testgetConnection</br>
    * �����������Ƿ�����</br>
    * ������Ա��souvc </br>
    * ����ʱ�䣺2015-10-5  </br>
    * @throws SQLException
    * @throws
     */
    @Test//�������ݿ������ 
    public void testgetConnection() throws SQLException {
        System.out.println(DBUtility.getConnection());
    }

   
}