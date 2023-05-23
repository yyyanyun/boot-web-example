package com.qf.login.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.login.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {

    User selectByUserName(@Param("username")String username);

    int updatePassword(@Param("User")User user);


}