package com.mayi.edu.member;

import com.mayi.edu.base.BaseApiService;
import com.mayi.edu.sms.entity.SmsEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "会员服务接口")
public interface MemberSmsService {

    /**
     * 会员调用短信接口
     * @return
     */
    @ApiOperation(value="会员调用短信服务接口")
    public BaseApiService getMemberSmsInfo(String phone);
}
