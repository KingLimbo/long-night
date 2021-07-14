/*
 * Copyright © 2020 - 2021 www.limbodevil.top
 */

package com.limbo.practice.base.dao;

import com.limbo.practice.base.entity.SysUser;
import com.limbo.practice.core.base.BaseDao;
import com.limbo.practice.core.mybatis.MybatisDao;

import java.util.List;

/**
*
* @ProjectName: long-night
* @PackageName: com.limbo.practice.base.dao
* @ClassName: SysUserDao
* @Description: TODO(这里用一句话描述这个类的作用)
* @Author: limbo
* @Date: 2021-02-20 09:46:12
* @Modifier: limbo
* @ModifiedDate: 2021-02-20 09:46:12
*
* version V1.0
*/

@MybatisDao
public interface SysUserDao extends BaseDao<SysUser> {

    /**
     * 根据用户id查询资源id
     *
     * @param userId
     * @return
     */
    List<Long> selectResourceIdByUserId(Long userId);
}
