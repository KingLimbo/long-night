/*
 * Copyright © 2020 - 2021 www.limbodevil.top
 */

package com.limbo.practice.base.entity.po;

import com.limbo.practice.core.base.BaseBO;
import lombok.Getter;
import lombok.Setter;
/**
*
* @ProjectName: long-night
* @PackageName: com.limbo.practice.base.entity.po
* @ClassName: SysRolePo
* @Description: TODO(这里用一句话描述这个类的作用)
* @Author: limbo
* @Date: 2021-02-20 09:56:18
* @Modifier: limbo
* @ModifiedDate: 2021-02-20 09:56:18
*
* version V1.0
*/
@Getter
@Setter
public class SysRolePo extends BaseBO{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     * db_column: name
     */
    private String name;

    /**
     * 角色描述
     * db_column: description
     */
    private String description;

    /**
     * 是否自动生成 说明：1 表示是，0 表示否
     * db_column: is_auto_generation
     */
    private Boolean autoGeneration;

    public SysRolePo(){
        super();
    }

    public SysRolePo(Long id, String name, String description, Boolean autoGeneration, Boolean deleted, java.util.Date gmtCreate, java.util.Date gmtModified){
        super(id, deleted, gmtCreate, gmtModified);
        this.name = name;
        this.description = description;
        this.autoGeneration = autoGeneration;
    }

}
