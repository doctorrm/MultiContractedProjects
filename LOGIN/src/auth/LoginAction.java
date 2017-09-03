/**
 * 
 */
package auth;

import com.opensymphony.xwork2.ActionContext;

/**
 * @author Doctor_
 * 2017-2-22  	下午8:46:22
*/
//糟糕，这个类名和另一个包里的类名一样，调用时要带包名
public class LoginAction {
	private String rand; //表单中的rand
	public String jj;
	public String getRand() {  
	return rand;  
	}  
	public void setRand(String rand) {  
	this.rand = rand;  
	}  
	//从session中取出RandomAction.java 中生成的验证码random  
	public String arandom=(String)(ActionContext.getContext().getSession().get("random")); 
	  
	//下面就是将session中保存验证码字符串与客户输入的验证码字符串对比了  
	
	 

}
