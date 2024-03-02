package com.findFriend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.findFriend.dto.UserDTO;
import com.findFriend.entity.User;
import com.findFriend.mapper.UserMapper;

public interface UserService extends IService<User> {

    void register(UserDTO userDTO);
}
