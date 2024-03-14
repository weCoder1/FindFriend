package com.findFriend.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryPageQueryDTO implements Serializable {

    //帖子姓名
    private String name;

    //页码
    private int page;

    //每页显示记录数
    private int pageSize;

}
