package com.findFriend.service.impl;

import com.findFriend.entity.Category;
import com.findFriend.mapper.CategoryMapper;
import com.findFriend.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 贴吧分类表 服务实现类
 * </p>
 *
 * @author lrz
 * @since 2024-03-03
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public void addCategory(Category category) {
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.addCategory(category);
    }

    @Override
    public void deleteCategory(List<Long> ids) {
        categoryMapper.deleteCategory(ids);

    }
}
