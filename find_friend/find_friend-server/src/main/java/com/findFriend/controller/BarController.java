package com.findFriend.controller;


import com.findFriend.dto.BarDTO;
import com.findFriend.result.Result;
import com.findFriend.service.BarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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



}
