/**
 * 
 */
package auth;

import com.opensymphony.xwork2.ActionContext;

/**
 * @author Doctor_
 * 2017-2-22  	����8:46:22
*/
//��⣬�����������һ�����������һ��������ʱҪ������
public class LoginAction {
	private String rand; //���е�rand
	public String jj;
	public String getRand() {  
	return rand;  
	}  
	public void setRand(String rand) {  
	this.rand = rand;  
	}  
	//��session��ȡ��RandomAction.java �����ɵ���֤��random  
	public String arandom=(String)(ActionContext.getContext().getSession().get("random")); 
	  
	//������ǽ�session�б�����֤���ַ�����ͻ��������֤���ַ����Ա���  
	
	 

}
