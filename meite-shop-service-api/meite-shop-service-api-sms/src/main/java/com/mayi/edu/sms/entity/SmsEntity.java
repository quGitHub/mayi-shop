package com.mayi.edu.sms.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SmsEntity {

    /**短信验证码*/
    private  String smsCode;

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }
}
