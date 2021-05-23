package com.limbo.practice.comm.service;

import com.limbo.practice.base.entity.SysResource;

import java.util.List;

/**
 * 注解工具接口
 *
 * @author limbo
 * @version
 */
public interface AnnotationService {

    /**
     * 自动生成所有菜单资源
     * @return
     */
    List<SysResource> autoGeneratorAllMenuResource();
}
