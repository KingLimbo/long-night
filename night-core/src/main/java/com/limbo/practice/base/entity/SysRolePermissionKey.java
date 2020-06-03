package com.limbo.practice.base.entity;

public class SysRolePermissionKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_permission.id
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_permission.role_id
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    private Long roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_permission.permission_id
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    private Long permissionId;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    public SysRolePermissionKey(Long id, Long roleId, Long permissionId) {
        this.id = id;
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    public SysRolePermissionKey() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_permission.id
     *
     * @return the value of sys_role_permission.id
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_permission.id
     *
     * @param id the value for sys_role_permission.id
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_permission.role_id
     *
     * @return the value of sys_role_permission.role_id
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_permission.role_id
     *
     * @param roleId the value for sys_role_permission.role_id
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role_permission.permission_id
     *
     * @return the value of sys_role_permission.permission_id
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    public Long getPermissionId() {
        return permissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role_permission.permission_id
     *
     * @param permissionId the value for sys_role_permission.permission_id
     *
     * @mbggenerated Wed Jun 03 22:27:47 CST 2020
     */
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}