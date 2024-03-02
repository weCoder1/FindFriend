package com.findFriend.controller;

import com.findFriend.dto.UserDTO;
import com.findFriend.result.Result;
import com.findFriend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    //登陆
    @PostMapping("/login")
    public Result login(){
        return Result.success();
    }

    //注册
    @PostMapping("/register")
    public Result register(@RequestBody UserDTO userDTO){
        log.info("注册账号{}",userDTO);
        userService.register(userDTO);
        return Result.success();
    }



}
