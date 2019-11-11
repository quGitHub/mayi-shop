package com.mayi.edu.member.impl;
import com.mayi.edu.base.BaseApiService;
import com.mayi.edu.base.BaseResponse;
import com.mayi.edu.entity.User;
import com.mayi.edu.entity.UserVo;
import com.mayi.edu.member.MemberBaseInfoService;

import com.mayi.edu.member.mapper.MemberMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/mem")
public class MemberInfoServiceImpl  implements MemberBaseInfoService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private MemberMapper memberMapper;

    @PostMapping("/register")
    @ResponseBody
    public BaseResponse registerMember(@RequestBody UserVo userVo) {
        BaseApiService baseApiService=new BaseApiService();
        //判断参数是否为空
        if(""==userVo.getPhone()&&null==userVo.getPhone()){
            return baseApiService.setResultError("201","参数为空");
        }
        //根据手机号查询用户是否存在
        User user = memberMapper.selecUserInfo(userVo);
        if(user.getPhone()!=null){
            return baseApiService.setResultError("202","用户手机号已经存在");
        }
        //验证短信码
        String s = stringRedisTemplate.opsForValue().get("sms:code:" + userVo.getPhone());
        if(!s.equals(userVo.getSmsCode())){
            return baseApiService.setResultError("203","短信验证码失效");
        }
        memberMapper.addUser(userVo);
        return  baseApiService.setResultSuccess("200","success","");
    }

    @PostMapping("/login")
    @ResponseBody
    public BaseResponse LoginMember(UserVo userVo) {
        BaseApiService baseApiService=new BaseApiService();
        //判断参数是否为空
        if(StringUtils.isEmpty(userVo.getPhone())&&StringUtils.isEmpty(userVo.getPwd())&&userVo.getType()!=null){
            return baseApiService.setResultError("201","参数为空");
        }

        /** 登录方式
         * 1: 手机号+短信验证码
         * 2: 手机号+密码
         */
        if(userVo.getType()==1){
            //验证短信码
            String s = stringRedisTemplate.opsForValue().get("sms:code:login" + userVo.getPhone());
            if(!s.equals(userVo.getSmsCode())){
                return baseApiService.setResultError("203","短信验证码失效");
            }
        }else if(userVo.getType()==2){
            //查询数据库验证手机号和密码
            User user = memberMapper.selecUserInfo(userVo);
            if(user.getPhone()==null &&user.getPwd()==null){
                return baseApiService.setResultError("204","用户不存在");
            }
        }

        //判断用户时候已经登录，tokenId不是空，那么就不允许等二个人登录， token等于空，说明没有人登录，则token为空
        String s = stringRedisTemplate.opsForValue().get("member:login:" + userVo.getPhone());
        if(s!=null) {
            return baseApiService.setResultError("205","账号不能多人登录");
        }

        //把生成token信息，写入到redis里面
        String uuid = UUID.randomUUID().toString().replace("-", " ").substring(0, 11);
        stringRedisTemplate.opsForValue().set("member:login:"+userVo.getPhone(),uuid);
        //把token信息，返回到前台
        UserVo userVos=new UserVo();
        userVos.setUserTokenId(uuid);
        return  baseApiService.setResultSuccess("200","success",userVos);
    }


    /**
     * 退出功能  ，每次退出，都要删掉tokenid
     * @param userVo
     * @return
     */
    @PostMapping("/exit")
    @ResponseBody
    public BaseResponse ExitMember(UserVo userVo) {
        BaseApiService baseApiService=new BaseApiService();
        //判断参数是否为空
        if(StringUtils.isEmpty(userVo.getPhone())&&StringUtils.isEmpty(userVo.getUserTokenId())){
            return baseApiService.setResultError("201","参数为空");
        }
        redisTemplate.delete("member:login:"+userVo.getPhone());
        return baseApiService.setResultSuccess("200","退出成功","");
    }


}