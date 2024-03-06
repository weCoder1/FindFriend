package com.findFriend.controller;

import com.findFriend.constant.JwtClaimsConstant;
import com.findFriend.dto.UserDTO;
import com.findFriend.dto.UserLoginDTO;
import com.findFriend.entity.User;
import com.findFriend.properties.JwtProperties;
import com.findFriend.result.Result;
import com.findFriend.service.UserService;
import com.findFriend.utils.JwtUtil;
import com.findFriend.vo.UserLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/user")
@Api(tags = "账号相关接口")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    JwtProperties jwtProperties;
    //登陆
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO){
        //登陆
        log.info("用户登录{}",userLoginDTO);
        User user = userService.login(userLoginDTO);
        //生成jwt
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.ID, user.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getSecretKey(),
                jwtProperties.getTtl(),
                claims);

        //创建UserLoginVO
        UserLoginVO userLoginVO = UserLoginVO.builder()
                .userName(user.getUsername())
                .name(user.getName())
                .id(user.getId())
                .token(token)
                .build();
        return Result.success(userLoginVO);
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
