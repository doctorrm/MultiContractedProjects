package com.souvc.weixin.pojo;

/**
* ����: AccessToken </br>
* ������ com.souvc.weixin.pojo
* ����: ΢��ͨ�ýӿ�ƾ֤  </br>
* ������Ա��souvc </br>
* ����ʱ�䣺  2015-12-1 </br>
* �����汾��V1.0  </br>
 */
public class AccessToken {
    // ��ȡ����ƾ֤
    private String token;
    // ƾ֤��Чʱ�䣬��λ����
    private int expiresIn;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}