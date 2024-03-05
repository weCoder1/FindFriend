# FindFriend


## Setup 

### How to configure Docker for Database access:
使用命令 `cd docker`		进入docker文件夹
执行命令 `docker-compose up -d`	创建容器

注意！！开发在arm架构的macbook上进行，如果不是arm架构的macbook请删除docker-compose.yml文件中的 platform: linux/amd64

使用命令 `docker exec -it mysql5.7 mysql -uroot` -p进入容器
执行 ```CREATE DATABASE  IF NOT EXISTS `findFriend` ```创建数据库
创建数据库后，你可以通过输入exit命令退出MySQL命令行界面

## Achitecture

### REST API Calls -- use port localhost:8080
###启动程序后在http://localhost:8080/doc.html#/home查看API接口文档
## Features 
user：
1登录注册功能
2创建、查看、删除吧，发布、查看、删除帖子
3点赞，评论，收藏帖子，管理员或吧主可以置顶帖子
4设置“吧管理员”，转让“吧”，
5搜索帖子（同时展示热门帖子）
6关注别的用户，展示被关注用户的帖子
7修改“吧”内容（简介、图片等），修改个人资料
admin
1封禁账号
2审核“吧”，审核帖子，通过后展示
3删除，封禁“吧”，删除封禁“帖子”
4“吧”种类设置
5置顶帖子
6设置吧主，吧管理员
7user有的各种修改功能
