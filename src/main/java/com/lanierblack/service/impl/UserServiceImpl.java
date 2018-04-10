package com.lanierblack.service.impl;

import com.lanierblack.mapper.UserMapper;
import com.lanierblack.model.User;
import com.lanierblack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;//这里会报错，但是并不会影响

    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public User findUserByPrimaryId(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

}
