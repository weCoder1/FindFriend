CREATE DATABASE  IF NOT EXISTS `find_friend` ;
USE `find_friend`;

DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
                           `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                           `name` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '姓名',
                           `username` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
                           `password` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
                           `phone` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '手机号',
                           `sex` varchar(2) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '性别',
                           `image` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图片路径',
                           `type` int NOT NULL COMMENT '账号类型 1用户账户 0管理员',
                           `status` int NOT NULL COMMENT '账号状态 1正常 0锁定',
                           `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                           `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
                           `create_user` bigint DEFAULT NULL COMMENT '创建人id',
                           `update_user` bigint DEFAULT NULL COMMENT '最后修改人id',
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `username_unique` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='账号表';

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
                            `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                            `name` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '分类名称',
                            `description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '贴吧种类描述',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `name_unique` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='贴吧分类表';

DROP TABLE IF EXISTS `bar`;
CREATE TABLE `bar` (
                       `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                       `name` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '贴吧名称',
                       `category_id` bigint NOT NULL COMMENT '贴吧分类id',
                       `image` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图片路径',
                       `description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '贴吧描述',
                       `status` int NOT NULL COMMENT '贴吧状态 2封禁 1审核中 0正常',
                       `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                       `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
                       `create_user` bigint DEFAULT NULL COMMENT '创建人id',
                       `update_user` bigint DEFAULT NULL COMMENT '最后修改人id',
                       PRIMARY KEY (`id`),
                       UNIQUE KEY `name_unique` (`name`),
                       KEY `category_id_idx` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='贴吧表';

DROP TABLE IF EXISTS `forum`;
CREATE TABLE `forum` (
                         `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                         `bar_id` bigint NOT NULL COMMENT '贴吧id',
                         `title` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '标题名称',
                         `details` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '内容',
                         `image` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图片路径',
                         `status` int NOT NULL COMMENT '帖子状态 2封禁 1审核中 0正常',
                         `visit` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '访问次数',
                         `heat` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '热度',
                         `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                         `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
                         `create_user` bigint DEFAULT NULL COMMENT '创建人id',
                         `update_user` bigint DEFAULT NULL COMMENT '最后修改人id',
                         PRIMARY KEY (`id`),
                         KEY `bar_id_idx` (`bar_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='帖子表';

DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
                           `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                           `user_id` bigint NOT NULL COMMENT '用户id',
                           `forum_id` bigint NOT NULL COMMENT '帖子id',
                           `image` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图片路径',
                           `details` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '回复内容',
                           `status` int NOT NULL COMMENT '评论状态 2封禁 1审核中 0正常',
                           `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                           `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
                           `create_user` bigint DEFAULT NULL COMMENT '创建人id',
                           `update_user` bigint DEFAULT NULL COMMENT '最后修改人id',
                           PRIMARY KEY (`id`),
                           KEY `user_id_idx` (`user_id`),
                           KEY `forum_id_idx` (`forum_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='评论表';

DROP TABLE IF EXISTS `collect_forum`;
CREATE TABLE `collect_forum` (
                                 `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                                 `user_id` bigint NOT NULL COMMENT '用户id',
                                 `forum_id` bigint NOT NULL COMMENT '帖子id',
                                 PRIMARY KEY (`id`),
                                 KEY `user_id_idx` (`user_id`),
                                 KEY `forum_id_idx` (`forum_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='收藏帖子关系表';

DROP TABLE IF EXISTS `favorite_forum`;
CREATE TABLE `favorite_forum` (
                                  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                                  `user_id` bigint NOT NULL COMMENT '用户id',
                                  `forum_id` bigint NOT NULL COMMENT '帖子id',
                                  PRIMARY KEY (`id`),
                                  KEY `user_id_idx` (`user_id`),
                                  KEY `forum_id_idx` (`forum_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='点赞表';

DROP TABLE IF EXISTS `focus_user`;
CREATE TABLE `focus_user` (
                              `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                              `user_id` bigint NOT NULL COMMENT '关注用户id',
                              `user_id_focused` bigint NOT NULL COMMENT '被关注用户id',
                              `bar_id` bigint DEFAULT NULL COMMENT '贴吧id',
                              PRIMARY KEY (`id`),
                              KEY `user_id_idx` (`user_id`),
                              KEY `user_id_focused_idx` (`user_id_focused`),
                              KEY `bar_id_idx` (`bar_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='关注表';

DROP TABLE IF EXISTS `bar_admin`;
CREATE TABLE `bar_admin` (
                             `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                             `user_id` bigint NOT NULL COMMENT '用户id',
                             `bar_id` bigint NOT NULL COMMENT '贴吧id',
                             `status` int NOT NULL COMMENT '吧主/管理员状态 1管理员 0吧主',
                             `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                             `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
                             `create_user` bigint DEFAULT NULL COMMENT '创建人id',
                             `update_user` bigint DEFAULT NULL COMMENT '最后修改人id',
                             PRIMARY KEY (`id`),
                             KEY `user_id_idx` (`user_id`),
                             KEY `bar_id_idx` (`bar_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='吧主管理员表';
