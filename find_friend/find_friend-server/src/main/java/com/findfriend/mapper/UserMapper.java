package com.findFriend.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.findFriend.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
