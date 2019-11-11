package com.mayi.edu.sms.service;

import com.mayi.edu.base.BaseApiService;
import com.mayi.edu.sms.entity.SmsEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

@Api(tags = "短信服务接口")
public interface SmsAppService {


    /**
     * 调用短信接口，返回短信验证码
     * @return
     */
    @ApiOperation(value = "短信发送接口")
    @GetMapping("/getSmsInfo")
    public BaseApiService getSmsInfo(String phone);
}
