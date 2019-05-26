package com.limbo.practice.base.dao;

import com.limbo.practice.base.entity.SysUser;
import com.limbo.practice.core.mybatis.MybatisDao;

@MybatisDao
public interface SysUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}