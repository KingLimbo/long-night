package com.limbo.practice.base.entity.vo;

import com.limbo.practice.base.entity.SysRole;
import com.limbo.practice.base.entity.SysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * 系统用户VO
 *
 * @author limbo
 * @date 2021/8/24
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserVO extends SysUser {

    /**
     * 角色集合
     */
    private Set<SysRole> roles;
}
