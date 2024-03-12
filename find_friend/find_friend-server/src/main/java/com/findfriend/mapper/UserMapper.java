package com.findFriend.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.findFriend.dto.UserPageQueryDTO;
import com.findFriend.entity.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Update("update account set status=#{status} where id=#{id}")
    void setStatusById(Integer status, Long id);

    Page<User> pageQuery(HashMap<String,Object> map);
//    Page<User> pageQuery(UserPageQueryDTO userPageQueryDTO);
}
