package com.souvc.weixin.util;

public class TestURL {

    /**     
     * ��������main</br>
     * ����������URL���� </br>
     * ������Ա��souvc </br>
     * ����ʱ�䣺2016-1-4  </br>
     * @param args ˵������ֵ����
     * @throws ˵���������쳣������
     */
    public static void main(String[] args) {
        String source="http://northenlight.tunnel.2bdata.com/dd/OAuthServlet";
        System.out.println(CommonUtil.urlEncodeUTF8(source));
    }

}


/*���������ֻ����û���Ȩ���ȡ�û���Ϣ�ġ�

https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect
���ֻ�΢�ŵ��������򿪡���
��Ҫ�޸ĵĵط���

 

��1���滻�Լ���AppID

��2����redirect_url�����Լ�����Ȩ��������URL��ע�����������Ҫ����UTF-8���롣�������main��������������ˡ���

��3����Ҫ�޸�scope����Ҫ����ҳ����Ҫ�޸�Ϊsnsapi_userinfo ��
ע�⣬����ֻ�����ֻ�����΢�ŵ��Զ˵�������򿪣���������ͨ��������򿪣���������
���У�Ҫ�ڿ��������ĵĽӿ�Ȩ���аѽӿ��е�   *��ҳ�˺� 	��ҳ��Ȩ��ȡ�û�������Ϣ 	������ 	�޸�  *����޸ģ���������������Э��ͷ����northenlight.tunnel.2bdata.com
*
*/