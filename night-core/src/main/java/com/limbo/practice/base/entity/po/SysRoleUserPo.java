/*
 * Copyright © 2020 - 2021 www.limbodevil.top
 */

package com.limbo.practice.base.entity.po;

import com.limbo.practice.core.base.BaseBO;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
*
* @ProjectName: long-night
* @PackageName: com.limbo.practice.base.entity.po
* @ClassName: SysRoleUserPo
* @Description: TODO(这里用一句话描述这个类的作用)
* @Author: limbo
* @Date: 2021-02-20 09:56:19
* @Modifier: limbo
* @ModifiedDate: 2021-02-20 09:56:19
*
* version V1.0
*/
@Getter
@Setter
@Accessors(chain = true)
public class SysRoleUserPo extends BaseBO{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     * db_column: role_id
     */
    private Long roleId;

    /**
     * 用户ID
     * db_column: user_id
     */
    private Long userId;

    public SysRoleUserPo(){
        super();
    }

    public SysRoleUserPo(Long id, Long roleId, Long userId, Boolean deleted, java.util.Date gmtCreate, java.util.Date gmtModified){
        super(id, deleted, gmtCreate, gmtModified);
        this.roleId = roleId;
        this.userId = userId;
    }

}
