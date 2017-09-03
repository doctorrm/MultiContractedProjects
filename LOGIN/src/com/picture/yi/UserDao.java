package com.picture.yi;

import com.picture.yi.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserDao {
	//ʵ���Ͽ��Ժ�RegisterAction.java�ϲ���һ����ʵ�Ѿ����ӣ�ͨ������ķ�������
	public static boolean registerUser(User u) {
//��֪��Ϊʲô������Ĵ����������ݿ�
		
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Transaction t = null;
        try  {
        Session s  = sf.openSession();
        	//Session s=HibernateSessionFactory.getSession();
        t = s.beginTransaction(); // start a new transaction
        s.save(u);
        t.commit();  // commit transaction  
        HibernateSessionFactory.closeSession();
        return true;
        }
        catch(Exception ex) {
            System.err.println("Error -->"  + ex.getMessage());
            if ( t!=null) t.rollback();  // rollback transaction on exception 
            return false;
        }
        
   }
}
