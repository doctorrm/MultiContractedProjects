package com.souvc.weixin.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.junit.Test;

import com.souvc.weixin.pojo.Token;
import com.souvc.weixin.util.CommonUtil;
import com.souvc.weixin.util.MyX509TrustManager;
import com.souvc.weixin.util.TokenUtil;

import net.sf.json.JSONObject;

public class TokenTest {//����Ҫ��ȡ��token��access_token����䣩

 /*   @Test//�������л�ȡtoken,����Ҫ��ȡ��token��access_token����䣩
    public void testGetToken1() throws Exception {//ֱ���ڷ�������д����ȡtoken,����CommonUtil�еķ����еĲ�ࡣ
        String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx277afa1f1210a601&secret=de27b2a651c6912d45b61adfe32f4fa9 ";
        // ��������
        URL url = new URL(tokenUrl);
        HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();

        // ����SSLContext���󣬲�ʹ������ָ�������ι�������ʼ��
        TrustManager[] tm = { new MyX509TrustManager() };
        SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
        sslContext.init(null, tm, new java.security.SecureRandom());
        // ������SSLContext�����еõ�SSLSocketFactory����
        SSLSocketFactory ssf = sslContext.getSocketFactory();

        httpUrlConn.setSSLSocketFactory(ssf);
        httpUrlConn.setDoOutput(true);
        httpUrlConn.setDoInput(true);

        // ��������ʽ��GET/POST��
        httpUrlConn.setRequestMethod("GET");

        // ȡ��������
        InputStream inputStream = httpUrlConn.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(
                inputStream, "utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        // ��ȡ��Ӧ����
        StringBuffer buffer = new StringBuffer();
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
        }
        bufferedReader.close();
        inputStreamReader.close();
        // �ͷ���Դ
        inputStream.close();
        httpUrlConn.disconnect();
         // ������ؽ��
        System.out.println(buffer);
    }*/

  /*  @Test//�������л�ȡtoken,����Ҫ��ȡ��token��access_token����䣩
    public void testGetToken2() {//���ù�����CommonUtil�еķ�������ȡtoken
        Token token = CommonUtil.getToken("wx277afa1f1210a601","de27b2a651c6912d45b61adfe32f4fa9");
        System.out.println("access_token:"+token.getAccessToken());
        System.out.println("expires_in:"+token.getExpiresIn());
    }*/
    
	/**
	 * �������л�ȡtoken�󱣴浽���ݿ��У�ÿִ��һ�����ݿ��оͻ��һ�����ݡ�
	 */
	@Test	
    public void testSaveToken4() {		
        Token token=CommonUtil.getToken("wx277afa1f1210a601", "de27b2a651c6912d45b61adfe32f4fa9");
        TokenUtil.saveToken(token);
    }         
	
   /* @Test//�����ݿ��л�ȡtoken
    public void testGetToken3() {
        Map<String, Object> token=TokenUtil.getToken();
        System.out.println(token.get("access_token"));
        System.out.println(token.get("expires_in"));
    }*/
    
    
    
}