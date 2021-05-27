/*
 * Copyright © 2020 - 2021 www.limbodevil.top
 */

package com.limbo.practice.base.dao;

import com.limbo.practice.base.entity.SysResource;
import com.limbo.practice.core.base.BaseDao;
import com.limbo.practice.core.mybatis.MybatisDao;

import java.util.Set;

/**
*
* @ProjectName: long-night
* @PackageName: com.limbo.practice.base.dao
* @ClassName: SysResourceDao
* @Description: TODO(这里用一句话描述这个类的作用)
* @Author: limbo
* @Date: 2021-02-20 09:46:09
* @Modifier: limbo
* @ModifiedDate: 2021-02-20 09:46:09
*
* version V1.0
*/

@MybatisDao
public interface SysResourceDao extends BaseDao<SysResource> {

    int deleteByPid(Long pid);

    Set<Long> selectChildAndSelfById(Long id);
}
