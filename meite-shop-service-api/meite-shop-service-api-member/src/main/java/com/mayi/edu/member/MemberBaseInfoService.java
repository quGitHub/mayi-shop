package com.mayi.edu.member;


import com.mayi.edu.base.BaseApiService;
import com.mayi.edu.base.BaseResponse;
import com.mayi.edu.entity.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 员工基本信息
 */
@Api(value = "员工基本信息")
public interface MemberBaseInfoService {


    @ApiOperation("用户注册信息")
    public BaseResponse registerMember(UserVo userVo);


    @ApiOperation("用户登录信息")
    public  BaseResponse LoginMember(UserVo userVo);

    @ApiOperation("用户退出")
    public  BaseResponse ExitMember(UserVo userVo);



}
