package com.findFriend.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "用户批量查询传递的数据模型")
public class UserPageQueryDTO implements Serializable {

    //用户姓名
    private String name;

    //用户名
    private String username;

    //页码
    private int page;

    //每页显示记录数
    private int pageSize;

}
