package com.findFriend.controller;


import com.findFriend.entity.Category;
import com.findFriend.result.Result;
import com.findFriend.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 贴吧分类表 前端控制器
 * </p>
 *
 * @author lrz
 * @since 2024-03-03
 */
@RestController
@Api(tags = "贴吧分类接口")
@RequestMapping("/category")
@Slf4j
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @ApiOperation("新增分类")
    @PostMapping
    public Result addCategory(@RequestBody Category category){
        log.info("新增分类{}",category);
        categoryService.addCategory(category);
        return Result.success();
    }

    @ApiOperation("删除分类")
    @DeleteMapping
    public Result deleteCategory(@RequestParam List<Long> ids){
        log.info("删除分类{}",ids);
        categoryService.deleteCategory(ids);
        //TODO 删除对应的帖子
        return Result.success();
    }

}
