package com.mayi.edu.member.mapper;


import com.mayi.edu.entity.User;
import com.mayi.edu.entity.UserVo;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface MemberMapper extends Mapper<User>, MySqlMapper<User> {


    /*查询用户基本信息*/
    public User selecUserInfo(UserVo userVo);
    /*添加用户基本信息*/
    public void addUser(UserVo userVo);
    /*修改用户信息*/
    public void updateUser(UserVo userVo);
}
