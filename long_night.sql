/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50643
Source Host           : localhost:3306
Source Database       : long_night

Target Server Type    : MYSQL
Target Server Version : 50643
File Encoding         : 65001

Date: 2021-01-24 23:53:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID 说明：自增ID',
  `parent_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '父节点资源ID 说明：父节点资源ID,0为根节点',
  `name` varchar(20) NOT NULL COMMENT '资源名称',
  `url` varchar(50) NOT NULL COMMENT '请求地址',
  `url_type` varchar(10) DEFAULT NULL COMMENT '请求类型 说明：GET POST DELETE',
  `type` tinyint(1) unsigned NOT NULL COMMENT '资源类型 说明：0 表示菜单，1 表示资源',
  `route` varchar(50) DEFAULT NULL COMMENT '资源路由',
  `sort` tinyint(3) unsigned NOT NULL COMMENT '资源排列顺序',
  `parents` varchar(20) NOT NULL DEFAULT '0' COMMENT '包含的父节点资源ID 说明：从上到下，用,分隔',
  `description` varchar(100) DEFAULT NULL COMMENT '资源描述',
  `is_auto_generation` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否自动生成 说明：1 表示是，0 表示否',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否已删除 说明：1 表示删除，0 表示未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统资源表';

-- ----------------------------
-- Records of sys_resource
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID 说明：自增ID',
  `name` varchar(20) NOT NULL COMMENT '角色名称',
  `description` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `is_auto_generation` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否自动生成 说明：1 表示是，0 表示否',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否已删除 说明：1 表示删除，0 表示未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_sys_role1` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID 说明：自增ID',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色ID',
  `resource_id` bigint(20) unsigned NOT NULL COMMENT '资源ID',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否已删除 说明：1 表示删除，0 表示未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_sys_role_resource1` (`role_id`,`resource_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统角色资源关联表';

-- ----------------------------
-- Records of sys_role_resource
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID 说明：自增ID',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色ID',
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户ID',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否已删除 说明：1 表示删除，0 表示未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_sys_role_user1` (`role_id`,`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统角色用户关联表';

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID 说明：自增长ID',
  `login_account` varchar(20) NOT NULL COMMENT '登录账号',
  `login_pass` varchar(32) NOT NULL COMMENT '登录密码',
  `login_salt` varchar(32) NOT NULL COMMENT '密码盐',
  `user_name` varchar(20) NOT NULL COMMENT '昵称',
  `user_head` varchar(64) DEFAULT NULL COMMENT '头像',
  `user_phone` varchar(20) DEFAULT NULL COMMENT '手机',
  `user_email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `user_sex` tinyint(1) unsigned DEFAULT NULL COMMENT '性别 说明：1 表示男，0 表示女',
  `user_type` tinyint(1) unsigned DEFAULT '0' COMMENT '用户类型 说明：1 系统管理员 ，0 普通用户',
  `is_locked` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否已锁定 说明：1 表示已锁定，0 表示未锁定',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否已删除 说明：1 表示删除，0 表示未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_sys_user1` (`login_account`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'c22e1e2404b7914198773a88dc6272ef', 'admin', '管理员', null, null, null, null, '0', '0', '0', '2020-12-14 22:24:17', '2020-12-14 22:24:19');
