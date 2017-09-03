package com.souvc.weixin.util;

public class TestURL {

    /**     
     * 方法名：main</br>
     * 详述：生成URL编码 </br>
     * 开发人员：souvc </br>
     * 创建时间：2016-1-4  </br>
     * @param args 说明返回值含义
     * @throws 说明发生此异常的条件
     */
    public static void main(String[] args) {
        String source="http://northenlight.tunnel.2bdata.com/dd/OAuthServlet";
        System.out.println(CommonUtil.urlEncodeUTF8(source));
    }

}


/*下面是在手机端用户授权后获取用户信息的。

https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect
（手机微信的聊天界面打开。）
需要修改的地方：

 

（1）替换自己的AppID

（2）将redirect_url换成自己的授权请求链接URL。注意这个连接需要经过UTF-8编码。（上面的main方法的输出就是了。）

（3）需要修改scope。需要弹出页面则要修改为snsapi_userinfo 。
注意，这里只能用手机或者微信电脑端的浏览器打开，不能用普通的浏览器打开，否则会出错。
还有，要在开发者中心的接口权限中把接口中的   *网页账号 	网页授权获取用户基本信息 	无上限 	修改  *点击修改，输入域名（不加协议头）：northenlight.tunnel.2bdata.com
*
*/