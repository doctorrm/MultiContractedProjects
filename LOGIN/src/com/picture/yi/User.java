package com.picture.yi;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//@��ʾ ������ӳ���ļ�
@Entity
@Table (name="user")
public  class User {
//ֱ�������ݿ���������ֶΣ����Ӧ,RegisterAction��Ҳ����Ҫ��
    @Id
    @GeneratedValue ( strategy =  GenerationType.AUTO)
    private int userid;
    private String name;
    private String password;
    private String mail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail(){
    	return mail;
    }
    
    public void setMail(String mail){
    	this.mail=mail;    
    }
    
    public int getUserid() {
        return userid;
    }
    
    public void setUserid(int userid) {
        this.userid = userid;
    }
}
