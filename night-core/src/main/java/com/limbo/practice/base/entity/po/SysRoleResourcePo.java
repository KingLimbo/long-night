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
* @ClassName: SysRoleResourcePo
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
public class SysRoleResourcePo extends BaseBO{

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
     * 资源ID
     * db_column: resource_id
     */
    private Long resourceId;

    public SysRoleResourcePo(){
        super();
    }

    public SysRoleResourcePo(Long id, Long roleId, Long resourceId, Boolean deleted, java.util.Date gmtCreate, java.util.Date gmtModified){
        super(id, deleted, gmtCreate, gmtModified);
        this.roleId = roleId;
        this.resourceId = resourceId;
    }

}
