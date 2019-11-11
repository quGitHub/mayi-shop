package com.mayi.edu.sms.impl;


import com.mayi.edu.base.BaseApiService;
import com.mayi.edu.sms.entity.SmsEntity;
import com.mayi.edu.sms.service.SmsAppService;
import com.mayi.edu.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
public class SmsAppServiceImpl implements SmsAppService {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/smsCode")
    @ResponseBody
    public BaseApiService getSmsInfo(@RequestParam("phone") String phone) {
        BaseApiService baseApiService=new BaseApiService();
        int i = (int)((Math.random()*6+1)*10000);
        String s = String.valueOf(i);
        stringRedisTemplate.opsForValue().set("sms:code:"+phone, s, 10000, TimeUnit.SECONDS);
        baseApiService.setResultSuccess("200","","");
        return baseApiService;
    }


}
