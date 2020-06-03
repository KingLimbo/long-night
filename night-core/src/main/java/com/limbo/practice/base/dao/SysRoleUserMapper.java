package com.limbo.practice.base.dao;

import com.limbo.practice.base.entity.SysRoleUser;
import com.limbo.practice.base.entity.SysRoleUserKey;

public interface SysRoleUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    int deleteByPrimaryKey(SysRoleUserKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    int insert(SysRoleUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    int insertSelective(SysRoleUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    SysRoleUser selectByPrimaryKey(SysRoleUserKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    int updateByPrimaryKeySelective(SysRoleUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    int updateByPrimaryKey(SysRoleUser record);
}