package com.mayi.edu.member.impl;
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
    public SmsEntity getMemberSmsInfo() {
        SmsEntity smsInfo = memberSmsFegin.getSmsInfo();
        return smsInfo;
    }
}