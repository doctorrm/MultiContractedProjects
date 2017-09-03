package com.picture.yi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.opensymphony.xwork2.ActionSupport;
import com.picture.yi.UserDao;
import com.picture.yi.User;
import auth.LoginAction;
//登陆注册例子
//发现这个过程原来是没有main函数的，醉，这就是web项目与纯粹java的区别么。。。
public class RegisterAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	//这里的name，pwd，mail和register_page.jsp中的相对应,主要是用于验证，这里的代码也很重要！
    public  String name,pwd;
	public  String mail;
	private String confirm_pwd;
	private String AUTH;
	private String mail_auth;

	public String getMail_auth() {
		return mail_auth;
	}

	public void setMail_auth(String mail_auth) {
		this.mail_auth = mail_auth;
	}

	public String getAUTH() {
		return AUTH;
	}

	public void setAUTH(String aUTH) {
		AUTH = aUTH;
	}

	public String getConfirm_pwd() {
		return confirm_pwd;
	}


	public void setConfirm_pwd(String confirm_pwd) {
		this.confirm_pwd = confirm_pwd;
	}

	public RegisterAction() {
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    public String getMail(){
    	return mail;    
    }
    
    public void setMail(String mail){
    	this.mail=mail;
    }
   
    SessionFactory sf1 = HibernateUtil.getSessionFactory();  //这里的sf1与其它的sf不会冲突，因为是不同的对象
    org.hibernate.Session s1 = sf1.openSession();
    Query query1=s1.createQuery("from User");//不是user，user会报错，操作的是User类，而不是数据库字段user
    List list1=query1.list();
    Iterator iter1=list1.iterator();
    User user=null;
    
    public void validate() //要用此验证方法必须要继承父类.在运行过程中，validate()先于execute()执行，只有当前者验证合格的情况下后者方法才会被执行
    { LoginAction la=new LoginAction();
      String aarandom=la.arandom;
    	
    	
       if (name == null||name.trim().equals("") ) 
       {
    	  System.out.println(INPUT);//这里一定要有，而且也要在struts2中配置好,但是只用一个就好了。
          addFieldError("name","请输入用户名"); //第一个参数一定要加引号！否则不显示！
       }
       else if(name.length()<6){
    	   addFieldError("name","用户名不能少于6个字符");
       }
       
       if(pwd==null||pwd.trim().equals("")){    
    	   addFieldError("pwd","请输入密码");
       }else if(pwd.length()<6){
    	   addFieldError("pwd","密码长度不能小于6位");   	   
       }
       
       if(mail==null||mail.trim().equals("")){
    	   addFieldError("mail","请输入邮箱");
       }else if(!(mail.indexOf("163.com")!=-1)&&!(mail.indexOf("qq.com")!=-1)&&!(mail.indexOf("126.com")!=-1)&&!(mail.indexOf("gmail.com")!=-1)&&!(mail.indexOf("sina.com")!=-1)&&!(mail.indexOf("163.com")!=-1)){
    	   addFieldError("mail","邮箱格式出错");//其实此处mail是字符串，即对字符串进行验证。
       }
       //||!(mail.indexOf("126.com")!=-1)||!(mail.indexOf("qq.com")!=-1)||!(mail.indexOf("gmail.com")!=-1)||!(mail.indexOf("sina.com")!=-1)||!(mail.indexOf("163.com")!=-1)
       if(!confirm_pwd.equals(pwd)){
    	   addFieldError("confirm_pwd","前后密码不一致");
       }
       //这里比较验证码
       if(!AUTH.equals(aarandom)){
    	   addFieldError("AUTH","验证码不正确");
       }
       //下面验证注册信息是否已存在
       while(iter1.hasNext()){
       	user=(User)iter1.next();
       	String name1=user.getName();
       	String mail1=user.getMail();
       	
       	if(name1.equals(name)){
       		 addFieldError("name","用户名已存在，请直接登陆");
       		}
       	
   		if(mail1.equals(mail)){
   			addFieldError("mail","邮箱已存在,请直接登陆");
   			}
       	}
//   	while(iter1.hasNext()){//不能独立于另一个while放在外面，因为和执行顺序有关，上面已经把数据库遍历完了，iter1.hasNext()返回的是false，所以不会执行这个while代码块
//		user=(User)iter1.next();
//		String mail1=user.getMail();
//		if(mail1.equals(mail)){
//			addFieldError("mail","邮箱已存在");
//		}
//	}

    } 

    
    
    
//    public static void main(String[] args){
//    	System.out.println("hellosa;fj");//无法在控制台输出
//    	//这个主函数在这个Action类中根本就不能被执行，Action类执行的都是在execute方法中的
//    }
  


    public String execute() throws Exception {	   				   	 
				User u = new User();//创建新对象居然可以在方法外面创建！
    	// create an object of User entity,不管是调用方法还是属性都可以实现写入数据库
			u.setName(this.getName());//set方法是写入数据库，通过下面调用UserDao中的方法commit后实现。
			u.setPassword(pwd);
			u.setMail(mail);//开始居然显示出错！刷新一下就没问题了
 	
//			//生成6位邮箱验证码
			Random random = new Random();   
			String sRand="";   
			for (int i=0;i<6;i++){   
			 String rand=String.valueOf(random.nextInt(10));   
			sRand+=rand; }//字符串sRand就是生成的验证码 
			System.out.println("生成的邮箱验证码是:"+sRand);
	//发送邮件只要下面这些代码就行了		
		System.out.println("发送邮件功能被执行");//这个可以在控制台输出
				   	 try{	//这大块代码不能放在return语句之后，否则会报unreachable code，就是不会再被执行也无法接触到
				   		u.setMail(mail);
				   		String to=u.getMail();//not work
				  		String from="13710638629@163.com";
				  		String host="localhost";
				  		String server = "smtp.163.com";  
				  		final String username = "13710638629";//用户名就是邮箱的前面的部分 
				  		final String password = "yudewy814";  //这表示的是授权码，而不是密码
				  		//对properties的配置；然后由properties得到session
				  		Properties properties=System.getProperties();
				  		properties.setProperty("mail.smtp.host", host);
				  		properties.setProperty("mail.transport.protocol", "smtp");  
				  		properties.setProperty("mail.smtp.auth", "true");  
				  		
				  		Session session = Session.getInstance(properties);//session就是一座桥	
				  		properties.setProperty("mail.debug", "true");//设置debug模式 后台输出邮件发送的过程
				  		session.setDebug(true);//debug模式
				  		//由session得到Message并在Message放入要发送的内容；
				  		Message message = new MimeMessage(session);
				  		message.setFrom(new InternetAddress(from));
				  		message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
				  		message.setSubject("来自用户注册的一份邮件");//邮件的主题
				  		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式,格式中大小写是有区别的，要注意
						message.setText("您好，您在"+df.format(new Date())+"成为我们的注册用户，愿您愉快！您的邮箱验证码为："+sRand+"。不过呢这不是邮箱验证哦！我还没实现验证呢！");//发送文本

						//message.saveChanges();
						//发送图片发不了，开始还可以，不知道改了下面的几行代码后发不了了
//						Multipart multi = new MimeMultipart(); 
//						MimeBodyPart body = new MimeBodyPart();
//						body.setDataHandler(new DataHandler(new FileDataSource("D:/test2.jpg")));//问题出在这
//						multi.addBodyPart(body);
//						message.setContent(multi);
//						
						
						//由session得到Transport；
				  		Transport transport = session.getTransport("smtp");
				  		transport.connect(server,username, password);  
				  		transport.sendMessage(message, new Address[]{ new InternetAddress(to)});
				  		transport.close();
				  	}catch(MessagingException mex){
				  			mex.printStackTrace();
				  		}	
				
      if ( UserDao.registerUser(u))   // Access persistence tier through DAO，链接了那个UserDao
             return "success";
       else
           return "fail";
//使用此方法用于方便跳转页面，否则只是对数据库的操作，没意思，boolean返回的true和false通过和struts的result标签可以实现jsp页面跳转，
        //这一个思想真的很妙，就跟做数学答题一样。
    }
}
