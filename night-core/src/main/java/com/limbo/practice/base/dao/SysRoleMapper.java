package com.limbo.practice.base.dao;

import com.limbo.practice.base.entity.SysRole;

public interface SysRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    int insert(SysRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    int insertSelective(SysRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    SysRole selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    int updateByPrimaryKeySelective(SysRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    int updateByPrimaryKey(SysRole record);
}