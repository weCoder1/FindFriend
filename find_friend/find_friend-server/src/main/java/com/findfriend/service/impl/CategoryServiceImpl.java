package com.findFriend.service.impl;

import com.findFriend.entity.Category;
import com.findFriend.mapper.CategoryMapper;
import com.findFriend.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 贴吧分类表 服务实现类
 * </p>
 *
 * @author lrz
 * @since 2024-03-03
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
