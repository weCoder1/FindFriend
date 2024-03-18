package com.findFriend.service;

import com.findFriend.dto.BarDTO;
import com.findFriend.entity.Bar;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 贴吧表 服务类
 * </p>
 *
 * @author lrz
 * @since 2024-03-17
 */
public interface BarService extends IService<Bar> {

    void addBar(BarDTO barDTO);

    void updateBar(BarDTO barDTO);

    void updateBarstatus(Integer status, Long id);
}
