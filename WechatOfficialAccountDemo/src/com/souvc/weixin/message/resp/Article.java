package com.souvc.weixin.message.resp;

/**
* ����: Article </br>
* ����: ͼ��model </br>
* ������Ա�� souvc </br>
* ����ʱ�䣺  2015-9-30 </br>
* �����汾��V1.0  </br>
 */
public class Article {
    // ͼ����Ϣ����
    private String Title;
    // ͼ����Ϣ����
    private String Description;
    // ͼƬ���ӣ�֧��JPG��PNG��ʽ���Ϻõ�Ч��Ϊ��ͼ640*320��Сͼ80*80
    private String PicUrl;
    // ���ͼ����Ϣ��ת����
    private String Url;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return null == Description ? "" : Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPicUrl() {
        return null == PicUrl ? "" : PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getUrl() {
        return null == Url ? "" : Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}