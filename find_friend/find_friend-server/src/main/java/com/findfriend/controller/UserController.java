package com.findFriend.controller;

import com.findFriend.dto.UserDTO;
import com.findFriend.result.Result;
import com.findFriend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/user")
@Api(tags = "账号相关接口")
public class UserController {

    @Autowired
    UserService userService;
    //登陆
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result login(){
        return Result.success();
    }

    //注册
    @ApiOperation("用户注册")
    @PostMapping("/register")
    public Result register(@RequestBody UserDTO userDTO){
        log.info("注册账号{}",userDTO);
        userService.register(userDTO);
        return Result.success();
    }



}
