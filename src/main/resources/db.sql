-- 创建数据库
create database if not exists myblog;

use myblog;

-- 创建博客表
drop table if exists blog;
create table blog(
    blogId int primary key auto_increment,
    title varchar(1024),
    content mediumtext,
    postTime datetime,
    userId int
);

-- 创建用户表
drop table if exists user;
create table user(
    userId int primary key auto_increment,
    username varchar(128) unique ,
    password varchar(128)
);

