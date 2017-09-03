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
	public String NAME_FLAG,PSD_FLAG;//标记
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
	    
	 	SessionFactory sf2 = HibernateUtil.getSessionFactory();  //这里的sf1与其它的sf不会冲突，因为是不同的对象
	    org.hibernate.Session s2 = sf2.openSession();
	    Query query2=s2.createQuery("from User");//不是user，user会报错，操作的是User类，而不是数据库字段user
	    List list2=query2.list();
	    Iterator iter2=list2.iterator();
	    User user2=null;
	
	
	   public void validate() { //要用此验证方法必须要继承父类.在运行过程中，validate()先于execute()执行，只有当前者验证合格的情况下后者方法才会被执行
	    	   //验证密码是否为空	  
	    	if(login_psd==null||login_psd.trim().equals("")){
	    		addFieldError("login_psd","请输入密码");
	    	}	    		   
	    	//验证用户名是否为空	    	
	    	if (name1 == null||name1.trim().equals("") ) {
	    	  System.out.println(INPUT);//这里一定要有，而且也要在struts2中配置好,但是只用一个就好了。
	          addFieldError("name1","请输入用户名"); //有问题，无法输出(后来检查时配置文件少了一行配置)
	       }
	    	
//当输入不为空时，遍历数据库并与用户输入的信息比较，若是不符合则提醒用户。
	    	//因为会比较很多次，不符合的会出现很多次，所以会输出很多报错提示用户,
	    	//所以采用做标记的方式，比较完了再对标记做处理。
	    while(iter2.hasNext()){//一个循环形成标记。
	       	user2=(User)iter2.next();
	       	String name2=user2.getName();
	       	//name2是从数据库取出的，name1是用户输入的，很容易混淆后在代码中出错。
	       	if(name2.equals(name1)){
	       		 NAME_FLAG="name_exist!";	//找到就做个标记，找不到就没标记       		 
	       		}	      
	       	//get_login_psd是从数据库取出的，login_psd是用户输入的，很容易混淆后在代码中出错。
	    	String get_login_psd=user2.getPassword();	       	
	       	if(get_login_psd.equals(login_psd)){
	       		 PSD_FLAG="psd_exist!";
	       		}   
	       	}
	    //在用户输入不为空的前提下进行对标记的判断
	    if(NAME_FLAG!="name_exist!"&&(name1!=null)&&(!name1.trim().equals("")) ){//无标记的处理方式，即NAME_FLAG标记只为null或者name_exist！,如果不是后者就给用户报错
	    	addFieldError("name1","用户名不存在，请先注册");
	    }
	    if(PSD_FLAG!="psd_exist!"&&(login_psd!=null)&&(!login_psd.trim().equals(""))){
	    	addFieldError("login_psd","密码错误");
	    }
	} 
	    	    
	public String execute()throws Exception{
		return "success";
	}
}
