/*
 * Copyright © 2020 - 2021 www.limbodevil.top
 */

package com.limbo.practice.base.entity;

import com.limbo.practice.base.entity.po.SysResourcePo;
import com.limbo.practice.core.enums.ResourceTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
*
* @ProjectName: long-night
* @PackageName: com.limbo.practice.base.entity
* @ClassName: SysResource
* @Description: TODO(这里用一句话描述这个类的作用)
* @Author: limbo
* @Date: 2021-02-20 09:53:30
* @Modifier: limbo
* @ModifiedDate: 2021-02-20 09:53:30
*
* version V1.0
*/
@Getter
@Setter
@Accessors(chain = true)
public class SysResource extends SysResourcePo {

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;


    /**
     * 资源类型 说明：0 表示菜单，1 表示资源
     * db_column: type
     */
    private List<ResourceTypeEnum> types;
}
