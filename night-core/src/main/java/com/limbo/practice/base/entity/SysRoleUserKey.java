package com.limbo.practice.base.entity;

public class SysRoleUserKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_user.id
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_user.role_id
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    private Long roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_user.user_id
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    private Long userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    public SysRoleUserKey(Long id, Long roleId, Long userId) {
        this.id = id;
        this.roleId = roleId;
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_user
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    public SysRoleUserKey() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_user.id
     *
     * @return the value of sys_role_user.id
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_user.id
     *
     * @param id the value for sys_role_user.id
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_user.role_id
     *
     * @return the value of sys_role_user.role_id
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_user.role_id
     *
     * @param roleId the value for sys_role_user.role_id
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_user.user_id
     *
     * @return the value of sys_role_user.user_id
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_user.user_id
     *
     * @param userId the value for sys_role_user.user_id
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}