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

public class TokenTest {//这里要获取的token是access_token（会变）

 /*   @Test//从网络中获取token,这里要获取的token是access_token（会变）
    public void testGetToken1() throws Exception {//直接在方法中书写来获取token,跟在CommonUtil中的方法中的差不多。
        String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx277afa1f1210a601&secret=de27b2a651c6912d45b61adfe32f4fa9 ";
        // 建立连接
        URL url = new URL(tokenUrl);
        HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();

        // 创建SSLContext对象，并使用我们指定的信任管理器初始化
        TrustManager[] tm = { new MyX509TrustManager() };
        SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
        sslContext.init(null, tm, new java.security.SecureRandom());
        // 从上述SSLContext对象中得到SSLSocketFactory对象
        SSLSocketFactory ssf = sslContext.getSocketFactory();

        httpUrlConn.setSSLSocketFactory(ssf);
        httpUrlConn.setDoOutput(true);
        httpUrlConn.setDoInput(true);

        // 设置请求方式（GET/POST）
        httpUrlConn.setRequestMethod("GET");

        // 取得输入流
        InputStream inputStream = httpUrlConn.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(
                inputStream, "utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        // 读取响应内容
        StringBuffer buffer = new StringBuffer();
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
        }
        bufferedReader.close();
        inputStreamReader.close();
        // 释放资源
        inputStream.close();
        httpUrlConn.disconnect();
         // 输出返回结果
        System.out.println(buffer);
    }*/

  /*  @Test//从网络中获取token,这里要获取的token是access_token（会变）
    public void testGetToken2() {//利用工具类CommonUtil中的方法来获取token
        Token token = CommonUtil.getToken("wx277afa1f1210a601","de27b2a651c6912d45b61adfe32f4fa9");
        System.out.println("access_token:"+token.getAccessToken());
        System.out.println("expires_in:"+token.getExpiresIn());
    }*/
    
	/**
	 * 从网络中获取token后保存到数据库中，每执行一次数据库中就会多一条数据。
	 */
	@Test	
    public void testSaveToken4() {		
        Token token=CommonUtil.getToken("wx277afa1f1210a601", "de27b2a651c6912d45b61adfe32f4fa9");
        TokenUtil.saveToken(token);
    }         
	
   /* @Test//从数据库中获取token
    public void testGetToken3() {
        Map<String, Object> token=TokenUtil.getToken();
        System.out.println(token.get("access_token"));
        System.out.println(token.get("expires_in"));
    }*/
    
    
    
}