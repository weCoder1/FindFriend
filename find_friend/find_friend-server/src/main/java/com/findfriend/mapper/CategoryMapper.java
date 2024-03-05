package com.findFriend.mapper;

import com.findFriend.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 贴吧分类表 Mapper 接口
 * </p>
 *
 * @author lrz
 * @since 2024-03-03
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}
