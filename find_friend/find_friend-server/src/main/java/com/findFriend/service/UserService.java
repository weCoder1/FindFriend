package com.findFriend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.findFriend.dto.UserDTO;
import com.findFriend.dto.UserLoginDTO;
import com.findFriend.dto.UserPageQueryDTO;
import com.findFriend.entity.User;
import com.findFriend.result.PageResult;

public interface UserService extends IService<User> {

    void register(UserDTO userDTO);

    User login(UserLoginDTO userLoginDTO);

    void setStatusById(java.lang.Integer status, java.lang.Long id);

    PageResult pageQuery(UserPageQueryDTO userPageQueryDTO);

    void updateUser(UserDTO userDTO);
}
