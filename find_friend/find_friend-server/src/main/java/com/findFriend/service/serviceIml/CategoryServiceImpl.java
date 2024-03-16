package com.findFriend.service.serviceIml;

import com.findFriend.dto.CategoryPageQueryDTO;
import com.findFriend.entity.Category;
import com.findFriend.entity.User;
import com.findFriend.mapper.CategoryMapper;
import com.findFriend.result.PageResult;
import com.findFriend.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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

    @Override
    public PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO) {
        PageHelper.startPage(categoryPageQueryDTO.getPage(),categoryPageQueryDTO.getPageSize());
        Page<Category> page=categoryMapper.pageQuery(categoryPageQueryDTO);
        long total = page.getTotal();
        List<Category> result = page.getResult();
        return new PageResult(total,result);
    }
}
