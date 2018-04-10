package com.lanierblack.service;

import com.lanierblack.model.User;

public interface UserService {
    public User findUserById(Integer id);
    public User findUserByPrimaryId(Integer id);
}
