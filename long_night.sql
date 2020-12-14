SET FOREIGN_KEY_CHECKS=0;

-- ---------系统用户表-----------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE sys_user (
id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID 说明：自增长ID',
login_account VARCHAR(20) NOT NULL COMMENT '登录账号',
login_pass VARCHAR(32) NOT NULL COMMENT '登录密码',
login_salt VARCHAR(32) NOT NULL COMMENT '密码盐',
user_name VARCHAR(20) NOT NULL COMMENT '昵称',
user_head VARCHAR(64) NULL COMMENT '头像',
user_phone VARCHAR(20) NULL COMMENT '手机',
user_email VARCHAR(30) NULL COMMENT '邮箱',
user_sex TINYINT(1) UNSIGNED NULL COMMENT '性别 说明：1 表示男，0 表示女',
user_type TINYINT(1) UNSIGNED NULL DEFAULT 0 COMMENT '用户类型 说明：1 系统管理员 ，0 普通用户',
is_locked TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否已锁定 说明：1 表示已锁定，0 表示未锁定',
is_deleted TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否已删除 说明：1 表示删除，0 表示未删除',
gmt_create DATETIME NOT NULL COMMENT '创建时间',
gmt_modified DATETIME NULL COMMENT '修改时间',
PRIMARY KEY (id),
UNIQUE INDEX uk_sys_user1(login_account) USING BTREE
)ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT '系统用户表';

-- ---------系统角色表-----------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE sys_role (
id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID 说明：自增ID',
name VARCHAR(20) NOT NULL COMMENT '角色名称',
description VARCHAR(100) NULL COMMENT '角色描述',
is_auto_generation TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否自动生成 说明：1 表示是，0 表示否',
is_deleted TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否已删除 说明：1 表示删除，0 表示未删除',
gmt_create DATETIME NOT NULL COMMENT '创建时间',
gmt_modified DATETIME NULL COMMENT '修改时间',
PRIMARY KEY (id),
UNIQUE INDEX uk_sys_role1(name) USING BTREE
)ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT '系统角色表';

-- ---------系统资源表-----------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE sys_resource (
id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID 说明：自增ID',
parent_id BIGINT(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '父节点资源ID 说明：父节点资源ID,0为根节点',
name VARCHAR(20) NOT NULL COMMENT '资源名称',
url VARCHAR(50) NOT NULL COMMENT '请求地址',
url_type VARCHAR(10) NULL COMMENT '请求类型 说明：GET POST DELETE',
type TINYINT(1) UNSIGNED NOT NULL COMMENT '资源类型 说明：0 表示菜单，1 表示资源',
route VARCHAR(50) NULL COMMENT '资源路由',
sort TINYINT(3) UNSIGNED NOT NULL COMMENT '资源排列顺序',
parents VARCHAR(20) NOT NULL DEFAULT '0' COMMENT '包含的父节点资源ID 说明：从上到下，用,分隔',
description VARCHAR(100) NULL COMMENT '资源描述',
is_auto_generation TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否自动生成 说明：1 表示是，0 表示否',
is_deleted TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否已删除 说明：1 表示删除，0 表示未删除',
gmt_create DATETIME NOT NULL COMMENT '创建时间',
gmt_modified DATETIME NULL COMMENT '修改时间',
PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT '系统资源表';

-- ---------系统角色用户关联表-----------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE sys_role_user (
id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID 说明：自增ID',
role_id BIGINT(20) UNSIGNED NOT NULL COMMENT '角色ID',
user_id BIGINT(20) UNSIGNED NOT NULL COMMENT '用户ID',
is_deleted TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否已删除 说明：1 表示删除，0 表示未删除',
gmt_create DATETIME NOT NULL COMMENT '创建时间',
gmt_modified DATETIME NULL COMMENT '修改时间',
PRIMARY KEY (id),
UNIQUE INDEX uk_sys_role_user1(role_id,user_id) USING BTREE
)ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT '系统角色用户关联表';

-- ---------系统角色资源关联表-----------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE sys_role_resource (
id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID 说明：自增ID',
role_id BIGINT(20) UNSIGNED NOT NULL COMMENT '角色ID',
resource_id BIGINT(20) UNSIGNED NOT NULL COMMENT '资源ID',
is_deleted TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否已删除 说明：1 表示删除，0 表示未删除',
gmt_create DATETIME NOT NULL COMMENT '创建时间',
gmt_modified DATETIME NULL COMMENT '修改时间',
PRIMARY KEY (id),
UNIQUE INDEX uk_sys_role_resource1(role_id,resource_id) USING BTREE
)ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT '系统角色资源关联表';

INSERT INTO `long_night`.`sys_user` (`id`, `login_account`, `login_pass`, `login_salt`, `user_name`, `user_head`, `user_phone`, `user_email`, `user_sex`, `user_type`, `is_locked`, `is_deleted`, `gmt_create`, `gmt_modified`)
VALUES ('1', 'admin', 'c22e1e2404b7914198773a88dc6272ef', 'admin', '管理员', NULL, NULL, NULL, NULL, '0', '0', '0', '2020-12-14 22:24:17', '2020-12-14 22:24:19');
