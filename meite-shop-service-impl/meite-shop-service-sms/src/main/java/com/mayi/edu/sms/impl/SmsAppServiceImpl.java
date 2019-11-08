package com.mayi.edu.sms.impl;

import com.mayi.edu.sms.entity.SmsEntity;
import com.mayi.edu.sms.service.SmsAppService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsAppServiceImpl implements SmsAppService {


    @Override
    public SmsEntity getSmsInfo() {
        SmsEntity smsEntity=new SmsEntity();
        smsEntity.setSmsCode("4528965");
        return smsEntity;
    }
}
