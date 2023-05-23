package com.qf.login.service;


import com.qf.login.common.qo.UserQO;
import com.qf.login.entity.User;

public interface UserService {


    //查询用户是否存在
    User selectById(String username,String password);


    int update(UserQO userQO);

}
