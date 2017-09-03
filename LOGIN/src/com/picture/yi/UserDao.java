package com.picture.yi;

import com.picture.yi.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserDao {
	//实际上可以和RegisterAction.java合并在一起（其实已经链接，通过下面的方法）。
	public static boolean registerUser(User u) {
//不知道为什么，这里的代码会清空数据库
		
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
