package com.findFriend.mapper;

import com.findFriend.dto.CategoryPageQueryDTO;
import com.findFriend.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.findFriend.entity.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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

    void addCategory(Category category);

    void deleteCategory(List<Long> ids);

    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);
}
