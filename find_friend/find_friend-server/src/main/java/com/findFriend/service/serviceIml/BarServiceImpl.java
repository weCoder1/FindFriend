package com.findFriend.service.serviceIml;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.findFriend.constant.BarStatusConstant;
import com.findFriend.constant.MessageConstant;

import com.findFriend.dto.BarDTO;
import com.findFriend.entity.Bar;
import com.findFriend.exception.BarExistException;
import com.findFriend.mapper.BarMapper;
import com.findFriend.service.BarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 贴吧表 服务实现类
 * </p>
 *
 * @author lrz
 * @since 2024-03-17
 */
@Service
public class BarServiceImpl extends ServiceImpl<BarMapper, Bar> implements BarService {

    @Autowired
    BarMapper barMapper;
    @Override
    public void addBar(BarDTO barDTO) {
        Bar bar=new Bar();
        BeanUtils.copyProperties(barDTO,bar);
        //检查吧名是否重复
        if(lambdaQuery()
                .eq(Bar::getName,bar.getName())
                .count()>0){
            throw new BarExistException(MessageConstant.BAR_EXIST);
        }
        bar.setStatus(BarStatusConstant.INVESTIGATE);
        bar.setCreateTime(LocalDateTime.now());
        bar.setUpdateTime(LocalDateTime.now());
        //TODO 添加创建人和更新人
        barMapper.addBar(bar);
    }

    @Override
    public void updateBar(BarDTO barDTO) {
        Bar bar=new Bar();
        BeanUtils.copyProperties(barDTO,bar);
        bar.setUpdateTime(LocalDateTime.now());
        //TODO 添加和更新人
        barMapper.updateBar(bar);
    }

    @Override
    public void updateBarstatus(Integer status, Long id) {
        //TODO updateuser
        Bar bar = Bar.builder().
                id(id).status(status)
                .updateTime(LocalDateTime.now())
                .build();
        barMapper.updateBar(bar);
    }
}
