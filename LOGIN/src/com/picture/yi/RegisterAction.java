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
//��½ע������
//�����������ԭ����û��main�����ģ��������web��Ŀ�봿��java������ô������
public class RegisterAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	//�����name��pwd��mail��register_page.jsp�е����Ӧ,��Ҫ��������֤������Ĵ���Ҳ����Ҫ��
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
   
    SessionFactory sf1 = HibernateUtil.getSessionFactory();  //�����sf1��������sf�����ͻ����Ϊ�ǲ�ͬ�Ķ���
    org.hibernate.Session s1 = sf1.openSession();
    Query query1=s1.createQuery("from User");//����user��user�ᱨ����������User�࣬���������ݿ��ֶ�user
    List list1=query1.list();
    Iterator iter1=list1.iterator();
    User user=null;
    
    public void validate() //Ҫ�ô���֤��������Ҫ�̳и���.�����й����У�validate()����execute()ִ�У�ֻ�е�ǰ����֤�ϸ������º��߷����Żᱻִ��
    { LoginAction la=new LoginAction();
      String aarandom=la.arandom;
    	
    	
       if (name == null||name.trim().equals("") ) 
       {
    	  System.out.println(INPUT);//����һ��Ҫ�У�����ҲҪ��struts2�����ú�,����ֻ��һ���ͺ��ˡ�
          addFieldError("name","�������û���"); //��һ������һ��Ҫ�����ţ�������ʾ��
       }
       else if(name.length()<6){
    	   addFieldError("name","�û�����������6���ַ�");
       }
       
       if(pwd==null||pwd.trim().equals("")){    
    	   addFieldError("pwd","����������");
       }else if(pwd.length()<6){
    	   addFieldError("pwd","���볤�Ȳ���С��6λ");   	   
       }
       
       if(mail==null||mail.trim().equals("")){
    	   addFieldError("mail","����������");
       }else if(!(mail.indexOf("163.com")!=-1)&&!(mail.indexOf("qq.com")!=-1)&&!(mail.indexOf("126.com")!=-1)&&!(mail.indexOf("gmail.com")!=-1)&&!(mail.indexOf("sina.com")!=-1)&&!(mail.indexOf("163.com")!=-1)){
    	   addFieldError("mail","�����ʽ����");//��ʵ�˴�mail���ַ����������ַ���������֤��
       }
       //||!(mail.indexOf("126.com")!=-1)||!(mail.indexOf("qq.com")!=-1)||!(mail.indexOf("gmail.com")!=-1)||!(mail.indexOf("sina.com")!=-1)||!(mail.indexOf("163.com")!=-1)
       if(!confirm_pwd.equals(pwd)){
    	   addFieldError("confirm_pwd","ǰ�����벻һ��");
       }
       //����Ƚ���֤��
       if(!AUTH.equals(aarandom)){
    	   addFieldError("AUTH","��֤�벻��ȷ");
       }
       //������֤ע����Ϣ�Ƿ��Ѵ���
       while(iter1.hasNext()){
       	user=(User)iter1.next();
       	String name1=user.getName();
       	String mail1=user.getMail();
       	
       	if(name1.equals(name)){
       		 addFieldError("name","�û����Ѵ��ڣ���ֱ�ӵ�½");
       		}
       	
   		if(mail1.equals(mail)){
   			addFieldError("mail","�����Ѵ���,��ֱ�ӵ�½");
   			}
       	}
//   	while(iter1.hasNext()){//���ܶ�������һ��while�������棬��Ϊ��ִ��˳���йأ������Ѿ������ݿ�������ˣ�iter1.hasNext()���ص���false�����Բ���ִ�����while�����
//		user=(User)iter1.next();
//		String mail1=user.getMail();
//		if(mail1.equals(mail)){
//			addFieldError("mail","�����Ѵ���");
//		}
//	}

    } 

    
    
    
//    public static void main(String[] args){
//    	System.out.println("hellosa;fj");//�޷��ڿ���̨���
//    	//��������������Action���и����Ͳ��ܱ�ִ�У�Action��ִ�еĶ�����execute�����е�
//    }
  


    public String execute() throws Exception {	   				   	 
				User u = new User();//�����¶����Ȼ�����ڷ������洴����
    	// create an object of User entity,�����ǵ��÷����������Զ�����ʵ��д�����ݿ�
			u.setName(this.getName());//set������д�����ݿ⣬ͨ���������UserDao�еķ���commit��ʵ�֡�
			u.setPassword(pwd);
			u.setMail(mail);//��ʼ��Ȼ��ʾ����ˢ��һ�¾�û������
 	
//			//����6λ������֤��
			Random random = new Random();   
			String sRand="";   
			for (int i=0;i<6;i++){   
			 String rand=String.valueOf(random.nextInt(10));   
			sRand+=rand; }//�ַ���sRand�������ɵ���֤�� 
			System.out.println("���ɵ�������֤����:"+sRand);
	//�����ʼ�ֻҪ������Щ���������		
		System.out.println("�����ʼ����ܱ�ִ��");//��������ڿ���̨���
				   	 try{	//������벻�ܷ���return���֮�󣬷���ᱨunreachable code�����ǲ����ٱ�ִ��Ҳ�޷��Ӵ���
				   		u.setMail(mail);
				   		String to=u.getMail();//not work
				  		String from="13710638629@163.com";
				  		String host="localhost";
				  		String server = "smtp.163.com";  
				  		final String username = "13710638629";//�û������������ǰ��Ĳ��� 
				  		final String password = "yudewy814";  //���ʾ������Ȩ�룬����������
				  		//��properties�����ã�Ȼ����properties�õ�session
				  		Properties properties=System.getProperties();
				  		properties.setProperty("mail.smtp.host", host);
				  		properties.setProperty("mail.transport.protocol", "smtp");  
				  		properties.setProperty("mail.smtp.auth", "true");  
				  		
				  		Session session = Session.getInstance(properties);//session����һ����	
				  		properties.setProperty("mail.debug", "true");//����debugģʽ ��̨����ʼ����͵Ĺ���
				  		session.setDebug(true);//debugģʽ
				  		//��session�õ�Message����Message����Ҫ���͵����ݣ�
				  		Message message = new MimeMessage(session);
				  		message.setFrom(new InternetAddress(from));
				  		message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
				  		message.setSubject("�����û�ע���һ���ʼ�");//�ʼ�������
				  		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ,��ʽ�д�Сд��������ģ�Ҫע��
						message.setText("���ã�����"+df.format(new Date())+"��Ϊ���ǵ�ע���û���Ը����죡����������֤��Ϊ��"+sRand+"���������ⲻ��������֤Ŷ���һ�ûʵ����֤�أ�");//�����ı�

						//message.saveChanges();
						//����ͼƬ�����ˣ���ʼ�����ԣ���֪����������ļ��д���󷢲�����
//						Multipart multi = new MimeMultipart(); 
//						MimeBodyPart body = new MimeBodyPart();
//						body.setDataHandler(new DataHandler(new FileDataSource("D:/test2.jpg")));//���������
//						multi.addBodyPart(body);
//						message.setContent(multi);
//						
						
						//��session�õ�Transport��
				  		Transport transport = session.getTransport("smtp");
				  		transport.connect(server,username, password);  
				  		transport.sendMessage(message, new Address[]{ new InternetAddress(to)});
				  		transport.close();
				  	}catch(MessagingException mex){
				  			mex.printStackTrace();
				  		}	
				
      if ( UserDao.registerUser(u))   // Access persistence tier through DAO���������Ǹ�UserDao
             return "success";
       else
           return "fail";
//ʹ�ô˷������ڷ�����תҳ�棬����ֻ�Ƕ����ݿ�Ĳ�����û��˼��boolean���ص�true��falseͨ����struts��result��ǩ����ʵ��jspҳ����ת��
        //��һ��˼����ĺ���͸�����ѧ����һ����
    }
}
