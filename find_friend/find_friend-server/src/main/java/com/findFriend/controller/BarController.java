package com.findFriend.controller;


import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.findFriend.dto.BarDTO;
import com.findFriend.result.Result;
import com.findFriend.service.BarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 * 贴吧表 前端控制器
 * </p>
 *
 * @author lrz
 * @since 2024-03-17
 */
@RestController
@Api(tags = "吧相关接口")
@RequestMapping("/bar")
@Slf4j
public class BarController {
    @Autowired
    BarService barService;

    @ApiOperation("新增吧")
    @PostMapping
    public Result addBar(@RequestBody BarDTO barDTO){
        log.info("新增吧{}",barDTO);
        barService.addBar(barDTO);
        return Result.success();
    }

    @ApiOperation("更新吧")
    @PutMapping
    public Result updateBar(@RequestBody BarDTO barDTO){
        log.info("更新吧{}",barDTO);
        barService.updateBar(barDTO);
        return Result.success();
    }
    @ApiOperation("更新吧状态")
    @PostMapping("/status/{status}")
    public Result updateBarstatus(@PathVariable Integer status,Long id){
        log.info("更新吧状态：{},{}",status,id);
        barService.updateBarstatus(status,id);
        return Result.success();
    }

    //删除吧
    @ApiOperation("删除吧")
    @DeleteMapping
    public Result deleteBar(@RequestParam List<Integer> ids)
    {
        log.info("删除吧{}",ids);
        //TODO 删除对应帖子，评论
        barService.removeBatchByIds(ids);
        return Result.success();
    }

    //查询单个吧详细信息

    //分页查询吧
}
