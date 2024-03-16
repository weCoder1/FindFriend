package com.findFriend.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 贴吧分类表
 * </p>
 *
 * @author lrz
 * @since 2024-03-03
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("category")
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Category对象", description="贴吧分类表")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "分类名称")
    @TableField(value = "name")
    private String name;

    @ApiModelProperty(value = "贴吧种类描述")
    @TableField(value = "description")
    private String description;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;


}
