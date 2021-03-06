package com.mayi.edu.member.impl;
import com.mayi.edu.base.BaseApiService;
import com.mayi.edu.member.MemberSmsService;
import com.mayi.edu.member.fegin.MemberSmsFegin;
import com.mayi.edu.sms.entity.SmsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MemberSmsServerImpl implements MemberSmsService {

    @Autowired
   private MemberSmsFegin memberSmsFegin;


    @GetMapping("/getSmsInfo")
    public BaseApiService getMemberSmsInfo(String phone) {
        BaseApiService smsInfo = memberSmsFegin.getSmsInfo(phone);
        return smsInfo;
    }

}