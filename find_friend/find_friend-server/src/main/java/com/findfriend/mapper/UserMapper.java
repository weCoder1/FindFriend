package com.findFriend.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.findFriend.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Update("update account set status=#{status} where id=#{id}")
    void setStatusById(Integer status, Long id);
}
