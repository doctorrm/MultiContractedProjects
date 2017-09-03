package com.souvc.weixin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.souvc.weixin.pojo.SNSUserInfo;
import com.souvc.weixin.pojo.WeixinOauth2Token;
import com.souvc.weixin.util.AdvancedUtil;

/**
* ����: OAuthServlet </br>
* ����: ��Ȩ��Ļص������� </br>
* ������Ա�� souvc </br>
* ����ʱ�䣺  2015-11-27 </br>
* �����汾��V1.0  </br>
 */
@WebServlet("/OAuthServlet")
public class OAuthServlet extends HttpServlet {
    private static final long serialVersionUID = -1847238807216447030L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // �û�ͬ����Ȩ���ܻ�ȡ��code
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        
        // �û�ͬ����Ȩ
        if (!"authdeny".equals(code)) {
            // ��ȡ��ҳ��Ȩaccess_token
            WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken("wx277afa1f1210a601", "de27b2a651c6912d45b61adfe32f4fa9", code);
            // ��ҳ��Ȩ�ӿڷ���ƾ֤
            String accessToken = weixinOauth2Token.getAccessToken();
            // �û���ʶ
            String openId = weixinOauth2Token.getOpenId();
            // ��ȡ�û���Ϣ
            SNSUserInfo snsUserInfo = AdvancedUtil.getSNSUserInfo(accessToken, openId);

            // ����Ҫ���ݵĲ���
            request.setAttribute("snsUserInfo", snsUserInfo);
            request.setAttribute("state", state);
        }
        // ��ת��index.jsp
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}