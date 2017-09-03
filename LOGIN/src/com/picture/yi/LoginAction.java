/**
 * 
 */
package com.picture.yi;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ActionSupport;


/**
 * @author Doctor_
 * 2017-2-16
 */
public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	public  String name1,login_psd;
	public String NAME_FLAG,PSD_FLAG;//���
	public String getLogin_psd() {
		return login_psd;
	}
	public void setLogin_psd(String login_psd) {
		this.login_psd = login_psd;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	    
	 	SessionFactory sf2 = HibernateUtil.getSessionFactory();  //�����sf1��������sf�����ͻ����Ϊ�ǲ�ͬ�Ķ���
	    org.hibernate.Session s2 = sf2.openSession();
	    Query query2=s2.createQuery("from User");//����user��user�ᱨ����������User�࣬���������ݿ��ֶ�user
	    List list2=query2.list();
	    Iterator iter2=list2.iterator();
	    User user2=null;
	
	
	   public void validate() { //Ҫ�ô���֤��������Ҫ�̳и���.�����й����У�validate()����execute()ִ�У�ֻ�е�ǰ����֤�ϸ������º��߷����Żᱻִ��
	    	   //��֤�����Ƿ�Ϊ��	  
	    	if(login_psd==null||login_psd.trim().equals("")){
	    		addFieldError("login_psd","����������");
	    	}	    		   
	    	//��֤�û����Ƿ�Ϊ��	    	
	    	if (name1 == null||name1.trim().equals("") ) {
	    	  System.out.println(INPUT);//����һ��Ҫ�У�����ҲҪ��struts2�����ú�,����ֻ��һ���ͺ��ˡ�
	          addFieldError("name1","�������û���"); //�����⣬�޷����(�������ʱ�����ļ�����һ������)
	       }
	    	
//�����벻Ϊ��ʱ���������ݿⲢ���û��������Ϣ�Ƚϣ����ǲ������������û���
	    	//��Ϊ��ȽϺܶ�Σ������ϵĻ���ֺܶ�Σ����Ի�����ܶ౨����ʾ�û�,
	    	//���Բ�������ǵķ�ʽ���Ƚ������ٶԱ��������
	    while(iter2.hasNext()){//һ��ѭ���γɱ�ǡ�
	       	user2=(User)iter2.next();
	       	String name2=user2.getName();
	       	//name2�Ǵ����ݿ�ȡ���ģ�name1���û�����ģ������׻������ڴ����г���
	       	if(name2.equals(name1)){
	       		 NAME_FLAG="name_exist!";	//�ҵ���������ǣ��Ҳ�����û���       		 
	       		}	      
	       	//get_login_psd�Ǵ����ݿ�ȡ���ģ�login_psd���û�����ģ������׻������ڴ����г���
	    	String get_login_psd=user2.getPassword();	       	
	       	if(get_login_psd.equals(login_psd)){
	       		 PSD_FLAG="psd_exist!";
	       		}   
	       	}
	    //���û����벻Ϊ�յ�ǰ���½��жԱ�ǵ��ж�
	    if(NAME_FLAG!="name_exist!"&&(name1!=null)&&(!name1.trim().equals("")) ){//�ޱ�ǵĴ���ʽ����NAME_FLAG���ֻΪnull����name_exist��,������Ǻ��߾͸��û�����
	    	addFieldError("name1","�û��������ڣ�����ע��");
	    }
	    if(PSD_FLAG!="psd_exist!"&&(login_psd!=null)&&(!login_psd.trim().equals(""))){
	    	addFieldError("login_psd","�������");
	    }
	} 
	    	    
	public String execute()throws Exception{
		return "success";
	}
}
