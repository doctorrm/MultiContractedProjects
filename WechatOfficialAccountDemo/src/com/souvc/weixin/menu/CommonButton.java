package com.souvc.weixin.menu;

/**
* ����: CommonButton </br>
* ������ com.souvc.weixin.menu
* ����: �Ӳ˵��� :û���Ӳ˵��Ĳ˵���п����Ƕ����˵��Ҳ�п����ǲ��������˵���һ���˵��� </br>
* ������Ա�� souvc  </br>
* ����ʱ�䣺  2015-12-1 </br>
* �����汾��V1.0  </br>
 */
public class CommonButton extends Button {
    
    private String type;
    private String key;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}