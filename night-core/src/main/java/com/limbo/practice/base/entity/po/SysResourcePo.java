/*
 * Copyright © 2020 - 2021 www.limbodevil.top
 */

package com.limbo.practice.base.entity.po;

import com.limbo.practice.core.base.BaseBO;
import com.limbo.practice.core.enums.ResourceTypeEnum;
import lombok.Getter;
import lombok.Setter;
/**
*
* @ProjectName: long-night
* @PackageName: com.limbo.practice.base.entity.po
* @ClassName: SysResourcePo
* @Description: TODO(这里用一句话描述这个类的作用)
* @Author: limbo
* @Date: 2021-02-20 09:56:17
* @Modifier: limbo
* @ModifiedDate: 2021-02-20 09:56:17
*
* version V1.0
*/
@Getter
@Setter
public class SysResourcePo extends BaseBO{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    /**
     * 父节点资源ID 说明：父节点资源ID,0为根节点
     * db_column: parent_id
     */
    private Long parentId;

    /**
     * 资源名称
     * db_column: name
     */
    private String name;

    /**
     * 请求地址
     * db_column: url
     */
    private String url;

    /**
     * 请求类型 说明：GET POST DELETE
     * db_column: url_type
     */
    private String urlType;

    /**
     * 资源类型 说明：0 表示菜单，1 表示资源
     * db_column: type
     */
    private ResourceTypeEnum type;

    /**
     * 资源路由
     * db_column: route
     */
    private String route;

    /**
     * 资源排列顺序
     * db_column: sort
     */
    private Integer sort;

    /**
     * 包含的父节点资源ID 说明：从上到下，用,分隔
     * db_column: parents
     */
    private String parents;

    /**
     * 资源描述
     * db_column: description
     */
    private String description;

    /**
     * 是否自动生成 说明：1 表示是，0 表示否
     * db_column: is_auto_generation
     */
    private Boolean autoGeneration;

    public SysResourcePo(){
        super();
    }

    public SysResourcePo(Long id, Long parentId, String name, String url, String urlType, ResourceTypeEnum type, String route, Integer sort, String parents, String description, Boolean autoGeneration, Boolean deleted, java.util.Date gmtCreate, java.util.Date gmtModified){
        super(id, deleted, gmtCreate, gmtModified);
        this.parentId = parentId;
        this.name = name;
        this.url = url;
        this.urlType = urlType;
        this.type = type;
        this.route = route;
        this.sort = sort;
        this.parents = parents;
        this.description = description;
        this.autoGeneration = autoGeneration;
    }

}
