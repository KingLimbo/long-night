package com.limbo.practice.base.dao;

import com.limbo.practice.base.entity.SysRoleUser;
import com.limbo.practice.base.entity.SysRoleUserKey;

public interface SysRoleUserMapper {
    int deleteByPrimaryKey(SysRoleUserKey key);

    int insert(SysRoleUser record);

    int insertSelective(SysRoleUser record);

    SysRoleUser selectByPrimaryKey(SysRoleUserKey key);

    int updateByPrimaryKeySelective(SysRoleUser record);

    int updateByPrimaryKey(SysRoleUser record);
}