package com.findFriend.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 贴吧表
 * </p>
 *
 * @author lrz
 * @since 2024-03-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Bar对象", description="贴吧表")
public class BarDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "贴吧名称")
    private String name;

    @ApiModelProperty(value = "贴吧分类id")
    private Long categoryId;

    @ApiModelProperty(value = "图片路径")
    private String image;

    @ApiModelProperty(value = "贴吧描述")
    private String description;



}
