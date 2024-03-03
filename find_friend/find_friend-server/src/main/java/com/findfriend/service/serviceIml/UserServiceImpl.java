package com.findFriend.service.serviceIml;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.findFriend.constant.MessageConstant;
import com.findFriend.dto.UserDTO;
import com.findFriend.entity.User;
import com.findFriend.exception.AccountExistException;
import com.findFriend.mapper.UserMapper;
import com.findFriend.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl <UserMapper,User> implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void register(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        QueryWrapper <User> queryWrapper = new QueryWrapper<User>()
                .isNotNull("username");
        //检查用户名是否重复
/*        if(lambdaQuery()
                .eq(User::getUsername,user.getUsername())
                .count()>0){
            throw new AccountExistException(MessageConstant.ACCOUNT_EXIST);
        }*/

         if(userMapper.selectCount(queryWrapper)>0){
             throw new AccountExistException(MessageConstant.ACCOUNT_EXIST);
         }
         user.setType(1);
         user.setStatus(1);
         //TODO aop设置时间ThreadLocal设置创始人创建人
        userMapper.insert(user);

    }
}
