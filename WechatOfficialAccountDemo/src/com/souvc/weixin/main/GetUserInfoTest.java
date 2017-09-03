package com.souvc.weixin.main;

import com.souvc.weixin.pojo.WeixinUserInfo;
import com.souvc.weixin.util.CommonUtil;
import com.souvc.weixin.util.GetUserInfo;

public class GetUserInfoTest {
	public static void main(String args[]) {
        // 获取接口访问凭证
        String accessToken = CommonUtil.getToken("wx277afa1f1210a601", "de27b2a651c6912d45b61adfe32f4fa9").getAccessToken();
        /**
         * 获取用户信息
         */
        WeixinUserInfo user = GetUserInfo.getUserInfo(accessToken, "o2DAZwI90w-TSQyLyWYuNXK4eNao");//这里的openId就是微信公众平台的测试号页面看关注着的微信号。
        System.out.println("OpenID：" + user.getOpenId());
        System.out.println("关注状态：" + user.getSubscribe());
        System.out.println("关注时间：" + user.getSubscribeTime());
        System.out.println("昵称：" + user.getNickname());
        System.out.println("性别：" + user.getSex());
        System.out.println("国家：" + user.getCountry());
        System.out.println("省份：" + user.getProvince());
        System.out.println("城市：" + user.getCity());
        System.out.println("语言：" + user.getLanguage());
        System.out.println("头像：" + user.getHeadImgUrl());
    }
}
