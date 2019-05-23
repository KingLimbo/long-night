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
    login_status TINYINT(1) UNSIGNED NULL DEFAULT '0' COMMENT '登录状态 说明：0 表示未登录，1 表示已登录', 
    last_login_time DATETIME NULL COMMENT '最后登录时间', 
    last_login_ip VARCHAR(50) NULL COMMENT '最后登录IP', 
    is_locked TINYINT(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否已锁定 说明：1 表示已锁定，0 表示未锁定', 
    is_deleted TINYINT(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否已删除 说明：1 表示删除，0 表示未删除', 
    gmt_create DATETIME NOT NULL COMMENT '创建时间', 
    gmt_modified DATETIME NULL COMMENT '修改时间', 
    CONSTRAINT PK_sys_user PRIMARY KEY (id)
)COMMENT  '系统用户表'; 

ALTER TABLE sys_user Add UNIQUE INDEX uk_login_account(login_account);


-- ---------系统角色表-----------

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE sys_role (
    id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID 说明：自增ID', 
    role_code VARCHAR(20) NOT NULL COMMENT '角色编号', 
    role_name VARCHAR(20) NOT NULL COMMENT '角色名称', 
    role_description VARCHAR(100) NULL COMMENT '角色描述', 
    is_deleted TINYINT(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否已删除 说明：1 表示删除，0 表示未删除', 
    gmt_create DATETIME NULL COMMENT '创建时间', 
    gmt_modified DATETIME NULL COMMENT '修改时间', 
    CONSTRAINT PK_sys_role PRIMARY KEY (id)
)COMMENT  '系统角色表'; 

ALTER TABLE sys_role Add UNIQUE INDEX uk_role_code(role_code);


-- ---------系统权限表-----------

DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE sys_permission (
    id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID 说明：自增ID', 
    permission_name VARCHAR(20) NOT NULL COMMENT '权限名称', 
    permission_description VARCHAR(100) NULL COMMENT '权限描述', 
    permission_url VARCHAR(50) NULL COMMENT '权限访问路径', 
    permission_type TINYINT(1) NOT NULL DEFAULT '0' COMMENT '权限类型 说明：0 表示页面，1 表示按钮', 
    is_deleted TINYINT(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否已删除 说明：1 表示删除，0 表示未删除', 
    gmt_create DATETIME NOT NULL COMMENT '创建时间', 
    gmt_modified DATETIME NULL COMMENT '修改时间', 
    CONSTRAINT PK_sys_permission PRIMARY KEY (id)
)COMMENT  '系统权限表'; 


-- ---------系统角色用户关联表-----------

DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE sys_role_user (
    id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID 说明：自增ID', 
    role_id BIGINT(20) NOT NULL COMMENT '角色ID', 
    user_id BIGINT(20) NOT NULL COMMENT '用户ID', 
    is_deleted TINYINT(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否已删除 说明：1 表示删除，0 表示未删除', 
    gmt_create DATETIME NULL COMMENT '创建时间', 
    gmt_modified DATETIME NULL COMMENT '修改时间', 
    CONSTRAINT PK_sys_role_user PRIMARY KEY (id)
)COMMENT  '系统角色用户关联表'; 

ALTER TABLE sys_role_user Add UNIQUE INDEX uk_role_user(role_id);


-- ---------系统角色权限关联表-----------

DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE sys_role_permission (
    id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID 说明：自增ID', 
    role_id BIGINT(20) NOT NULL COMMENT '角色ID', 
    permission_id BIGINT(20) NOT NULL COMMENT '权限ID', 
    is_deleted TINYINT(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否已删除 说明：1 表示删除，0 表示未删除', 
    gmt_create DATETIME NULL COMMENT '创建时间', 
    gmt_modified DATETIME NULL COMMENT '修改时间', 
    CONSTRAINT PK_sys_role_permission PRIMARY KEY (id)
)COMMENT  '系统角色权限关联表'; 

ALTER TABLE sys_role_permission Add UNIQUE INDEX uk_role_permission(role_id, permission_id);


-- ---------系统菜单表-----------

DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE sys_menu (
    id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID 说明：自增ID', 
    menu_name VARCHAR(20) NOT NULL COMMENT '菜单名称', 
    menu_url VARCHAR(50) NULL COMMENT '菜单访问路径', 
    menu_description VARCHAR(100) NULL COMMENT '角色描述', 
    parent_id BIGINT(20) UNSIGNED NOT NULL DEFAULT '0' COMMENT '父节点ID 说明：根节点为0', 
    parents_id VARCHAR(100) NOT NULL COMMENT '全节点ID 说明：用分号分隔  0;100', 
    menu_level TINYINT(1) UNSIGNED NOT NULL COMMENT '级别 说明：根节点为0', 
    menu_sort TINYINT(1) UNSIGNED NOT NULL COMMENT '排序 说明：同级目录下从1开始排序', 
    is_deleted TINYINT(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否已删除 说明：1 表示删除，0 表示未删除', 
    gmt_create DATETIME NULL COMMENT '创建时间', 
    gmt_modified DATETIME NULL COMMENT '修改时间', 
    CONSTRAINT PK_sys_menu PRIMARY KEY (id)
)COMMENT  '系统菜单表'; 


-- ---------系统角色菜单关联表-----------

DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE sys_role_menu (
    id BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID 说明：自增ID', 
    role_id BIGINT(20) NOT NULL COMMENT '角色ID', 
    menu_id BIGINT(20) NOT NULL COMMENT '用户ID', 
    is_deleted TINYINT(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否已删除 说明：1 表示删除，0 表示未删除', 
    gmt_create DATETIME NULL COMMENT '创建时间', 
    gmt_modified DATETIME NULL COMMENT '修改时间', 
    CONSTRAINT PK_sys_role_menu PRIMARY KEY (id)
)COMMENT  '系统角色菜单关联表'; 

ALTER TABLE sys_role_menu Add UNIQUE INDEX uk_role_menu(role_id, menu_id);


