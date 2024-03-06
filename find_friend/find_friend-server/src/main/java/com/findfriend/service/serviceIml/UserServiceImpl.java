package com.findFriend.service.serviceIml;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.findFriend.constant.MessageConstant;
import com.findFriend.constant.StatusConstant;
import com.findFriend.dto.UserDTO;
import com.findFriend.dto.UserLoginDTO;
import com.findFriend.entity.User;
import com.findFriend.exception.AccountExistException;
import com.findFriend.exception.AccountLockedException;
import com.findFriend.exception.AccountNotFoundException;
import com.findFriend.exception.PasswordErrorException;
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
                .eq("username",user.getUsername());
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
         //TODO aop设置时间
        userMapper.insert(user);

    }

    @Override
    public User login(UserLoginDTO userLoginDTO) {
        //根据username查询账户
        User user = this.lambdaQuery()
                .eq(User::getUsername, userLoginDTO.getUsername())
                .one();
        //错误处理
        if(user == null){
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        if (!user.getPassword().equals(userLoginDTO.getPassword()))
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        if(user.getStatus().equals(StatusConstant.DISABLE))
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        return user;
    }
}
