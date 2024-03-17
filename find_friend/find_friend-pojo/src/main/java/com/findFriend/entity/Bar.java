package com.findFriend.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

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
@TableName("bar")
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="Bar对象", description="贴吧表")
public class Bar implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "贴吧名称")
    private String name;

    @ApiModelProperty(value = "贴吧分类id")
    private Long categoryId;

    @ApiModelProperty(value = "图片路径")
    private String image;

    @ApiModelProperty(value = "贴吧描述")
    private String description;

    @ApiModelProperty(value = "贴吧状态 2封禁 1审核中 0正常")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "最后修改时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "创建人id")
    private Long createUser;

    @ApiModelProperty(value = "最后修改人id")
    private Long updateUser;


}
