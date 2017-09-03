package com.souvc.weixin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.souvc.weixin.service.CoreService;
import com.souvc.weixin.util.SignUtil;

/**
 * Servlet implementation class CoreServle
 */
@WebServlet("/CoreServlet")

//@WebServlet(name="CoreServlet",urlPatterns="/CoreServlet",loadOnStartup=1,initParams={@WebInitParam(name="username",value="����")})
public class CoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 // ΢�ż���ǩ��
        String signature = request.getParameter("signature");
        // ʱ���
        String timestamp = request.getParameter("timestamp");
        // �����
        String nonce = request.getParameter("nonce");
        // ����ַ���
        String echostr = request.getParameter("echostr");

        PrintWriter out = response.getWriter();
        
        // ͨ������signature���������У�飬��У��ɹ���ԭ������echostr����ʾ����ɹ����������ʧ��
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            out.print(echostr);
            System.out.println(echostr);
        }
        
        out.close();
        out = null;	
		System.out.println("hello,there");
   }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // ��Ϣ�Ľ��ա���������Ӧ��servlet��ֻ�ǵ�����Ӧ���еķ�����
		//ÿ�����󶼵���һ��servlet
        // ��������Ӧ�ı��������ΪUTF-8����ֹ�������룩
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // ���ú���ҵ���ദ����Ϣ������ҵ�������xml������       
        String respXml = CoreService.processRequest(request);

        // ��Ӧ��Ϣ
        PrintWriter out = response.getWriter();
        out.print(respXml);
        //���ﲻ������ҳ������������ֻ�΢���������������������������respXml��xml���͵�
        out.close();
	}

}