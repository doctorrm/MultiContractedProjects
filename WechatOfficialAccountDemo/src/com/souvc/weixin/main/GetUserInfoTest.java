package com.souvc.weixin.main;

import com.souvc.weixin.pojo.WeixinUserInfo;
import com.souvc.weixin.util.CommonUtil;
import com.souvc.weixin.util.GetUserInfo;

public class GetUserInfoTest {
	public static void main(String args[]) {
        // ��ȡ�ӿڷ���ƾ֤
        String accessToken = CommonUtil.getToken("wx277afa1f1210a601", "de27b2a651c6912d45b61adfe32f4fa9").getAccessToken();
        /**
         * ��ȡ�û���Ϣ
         */
        WeixinUserInfo user = GetUserInfo.getUserInfo(accessToken, "o2DAZwI90w-TSQyLyWYuNXK4eNao");//�����openId����΢�Ź���ƽ̨�Ĳ��Ժ�ҳ�濴��ע�ŵ�΢�źš�
        System.out.println("OpenID��" + user.getOpenId());
        System.out.println("��ע״̬��" + user.getSubscribe());
        System.out.println("��עʱ�䣺" + user.getSubscribeTime());
        System.out.println("�ǳƣ�" + user.getNickname());
        System.out.println("�Ա�" + user.getSex());
        System.out.println("���ң�" + user.getCountry());
        System.out.println("ʡ�ݣ�" + user.getProvince());
        System.out.println("���У�" + user.getCity());
        System.out.println("���ԣ�" + user.getLanguage());
        System.out.println("ͷ��" + user.getHeadImgUrl());
    }
}
