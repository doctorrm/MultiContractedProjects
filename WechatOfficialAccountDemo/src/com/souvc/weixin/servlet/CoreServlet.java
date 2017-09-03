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

//@WebServlet(name="CoreServlet",urlPatterns="/CoreServlet",loadOnStartup=1,initParams={@WebInitParam(name="username",value="张三")})
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
		 // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        PrintWriter out = response.getWriter();
        
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
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
		 // 消息的接收、处理、响应（servlet中只是调用相应类中的方法）
		//每次请求都调用一次servlet
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 调用核心业务类处理消息，核心业务类调用xml工具类       
        String respXml = CoreService.processRequest(request);

        // 响应消息
        PrintWriter out = response.getWriter();
        out.print(respXml);
        //这里不是往网页输出！而是在手机微信聊天界面输出！！！而且这里的respXml是xml类型的
        out.close();
	}

}
