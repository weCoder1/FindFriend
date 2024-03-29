package com.findFriend.controller;


import com.findFriend.dto.CategoryPageQueryDTO;
import com.findFriend.entity.Category;
import com.findFriend.result.PageResult;
import com.findFriend.result.Result;
import com.findFriend.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    @ApiOperation("更新分类")
    @PutMapping
    public Result updateCategory(@RequestBody Category category){
        log.info("更新分类{}",category);
        category.setUpdateTime(LocalDateTime.now());
        categoryService.updateById(category);
        return Result.success();
    }

    @ApiOperation("根据id查询单个分类")
    @GetMapping("/{id}")
    public Result<Category> selectCategoryById(@PathVariable Long id){
        log.info("根据id查询单个分类{}",id);
        return Result.success(categoryService.getById(id));
    }

    @ApiOperation("批量查询分类")
    @GetMapping("/page")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO){
        log.info("分页查询{},第{}页,每页{}条数据",categoryPageQueryDTO.getName(),categoryPageQueryDTO.getPage(),categoryPageQueryDTO.getPageSize());
        PageResult pageResult=categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

}
