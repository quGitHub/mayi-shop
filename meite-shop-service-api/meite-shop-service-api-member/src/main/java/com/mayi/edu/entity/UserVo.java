package com.mayi.edu.entity;

public class UserVo {

    private String phone;
    private String  pwd;
    /**用户tokenid*/
    private String UserTokenId;

    private  String  smsCode;

    /**
     * 1: 手机号+短信验证码
     * 2: 手机号+密码
     */
    private  Integer type;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUserTokenId() {
        return UserTokenId;
    }

    public void setUserTokenId(String userTokenId) {
        UserTokenId = userTokenId;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
