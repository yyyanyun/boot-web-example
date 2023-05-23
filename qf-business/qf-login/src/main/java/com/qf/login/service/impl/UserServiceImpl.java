package com.qf.login.service.impl;

import com.qf.common.base.exception.ServiceException;
import com.qf.common.base.result.ResultCode;
import com.qf.login.common.qo.UserQO;
import com.qf.login.entity.User;
import com.qf.login.mapper.UserMapper;
import com.qf.login.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User selectById(String username, String password) {
        User user = userMapper.selectByUserName(username);
        if (!ObjectUtils.isEmpty(user)) {
            if (user.getPassword().equals(password)) {
                return user;
            } else {
                throw new ServiceException(ResultCode.SYS_ERROR);
            }
        } else {
            throw new ServiceException(ResultCode.SYS_ERROR);
        }
    }

    @Override
    public int update(UserQO userQO) {

        User user = new User();
        BeanUtils.copyProperties(userQO, user);
        User user1 = userMapper.selectByUserName(user.getUsername());
        if (!ObjectUtils.isEmpty(user1)) {
            if (user.getPassword().equals(user1.getPassword())) {
                if (user.getNewPassword().equals(user.getConfirmPassword())) {
                    int i = userMapper.updatePassword(user);
                    if (i > 0) {
                        return i;
                    } else {
                        throw new ServiceException(ResultCode.SYS_ERROR);
                    }
                } else {
                    throw new ServiceException(ResultCode.SYS_ERROR);
                }

            } else {
                throw new ServiceException(ResultCode.SYS_ERROR);
            }
        } else {
            throw new ServiceException(ResultCode.SYS_ERROR);
        }

    }
}