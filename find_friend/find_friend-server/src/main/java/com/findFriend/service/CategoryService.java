package com.findFriend.service;

import com.findFriend.dto.CategoryPageQueryDTO;
import com.findFriend.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.findFriend.result.PageResult;

import java.util.List;

/**
 * <p>
 * 贴吧分类表 服务类
 * </p>
 *
 * @author lrz
 * @since 2024-03-03
 */
public interface CategoryService extends IService<Category> {

    void addCategory(Category category);

    void deleteCategory(List<Long> ids);

    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);
}
