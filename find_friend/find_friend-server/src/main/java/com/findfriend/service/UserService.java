package com.findFriend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.findFriend.dto.UserDTO;
import com.findFriend.dto.UserLoginDTO;
import com.findFriend.entity.User;

public interface UserService extends IService<User> {

    void register(UserDTO userDTO);

    User login(UserLoginDTO userLoginDTO);
}
