package com.findFriend.mapper;

import com.findFriend.entity.Bar;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 贴吧表 Mapper 接口
 * </p>
 *
 * @author lrz
 * @since 2024-03-17
 */
@Mapper
public interface BarMapper extends BaseMapper<Bar> {

    @Insert("INSERT INTO bar (name, category_id, description, status, create_time, update_time, create_user, update_user, image) " +
            "VALUES (#{name},#{categoryId}, #{description}, #{status}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser}, #{image})")
    void addBar(Bar bar);

    void updateBar(Bar bar);
}
