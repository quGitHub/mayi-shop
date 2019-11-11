package com.mayi.edu.sms.entity;

import lombok.Data;
@Data
public class SmsEntity {

    /**短信验证码*/
    private  String smsCode;

    private  String phone;

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
