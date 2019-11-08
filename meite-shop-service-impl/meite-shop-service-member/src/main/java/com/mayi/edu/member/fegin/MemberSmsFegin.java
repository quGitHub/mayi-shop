package com.mayi.edu.member.fegin;

import com.mayi.edu.sms.service.SmsAppService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="app-euerke-sms")
public interface MemberSmsFegin extends SmsAppService {


}
