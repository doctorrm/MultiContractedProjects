package com.picture.yi;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//@表示 代替了映射文件
@Entity
@Table (name="user")
public  class User {
//直接与数据库的列名（字段）相对应,RegisterAction类也很重要。
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
