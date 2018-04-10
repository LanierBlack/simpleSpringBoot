package com.lanierblack.controller;

import com.lanierblack.common.Constant;
import com.lanierblack.model.User;
import com.lanierblack.service.impl.UserServiceImpl;
import com.lanierblack.util.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class HomeController {
    private static Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private UserServiceImpl userService;

    @ResponseBody
    @RequestMapping(value = "user/findUser/{userId}")
    public User findUser(@PathVariable("userId") int userId){
        System.out.println("----- 获取用户信息 ------");
        return userService.findUserById(userId);
    }

    @RequestMapping(value = "user/findUserById/{userId}", method = RequestMethod.GET)
    public ResponseModel findUserById(@PathVariable("userId") int userId){
        return new ResponseModel(Constant.SUCCESS, userService.findUserByPrimaryId(userId), Constant.SUCCESS_MSG);
    }

    @RequestMapping(value = "user/find", method = RequestMethod.POST)
    public Map<Object, Object> find(@RequestBody Map<Object, Object> params){
        System.out.println("params: "+params);
        return params;
    }

}
