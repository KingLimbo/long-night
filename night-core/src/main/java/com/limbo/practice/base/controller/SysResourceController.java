/*
 * Copyright © 2020 - 2021 www.limbodevil.top
 */

package com.limbo.practice.base.controller;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import com.limbo.practice.base.dao.SysResourceDao;
import com.limbo.practice.base.entity.SysResource;
import com.limbo.practice.base.service.SysResourceService;
import com.limbo.practice.comm.service.SysInitService;
import com.limbo.practice.core.annotation.ApiResources;
import com.limbo.practice.core.annotation.PublicUrl;
import com.limbo.practice.core.base.BaseController;
import com.limbo.practice.core.enums.MenuLevelEnum;
import com.limbo.practice.core.enums.ResourceTypeEnum;
import com.limbo.practice.core.enums.RoleNameEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;

/**
*
* @ProjectName: long-night
* @PackageName: com.limbo.practice.base.controller
* @ClassName: SysResourceController
* @Description: TODO(这里用一句话描述这个类的作用)
* @Author: limbo
* @Date: 2021-02-20 09:46:09
* @Modifier: limbo
* @ModifiedDate: 2021-02-20 09:46:09
*
* version V1.0
*/
@Api(tags = "系统资源管理")
@ApiResources(type = ResourceTypeEnum.MENU, roleName = RoleNameEnum.ADMIN, parent = MenuLevelEnum.SYS)
@Controller
@RequestMapping("/sys-resource")
public class SysResourceController extends BaseController<SysResource, SysResourceDao> {

    @Autowired
    private SysResourceService<SysResource, SysResourceDao> sysResourceServiceImpl;
    @Autowired
    private SysInitService sysInitService;

    @PostConstruct
    public void initService(){
        setService(sysResourceServiceImpl);
    }

    @GetMapping("/init/{json}")
    @ApiOperation("初始化")
    public ModelAndView init(@ApiParam("初始化json") @PathVariable("json") String json){
        return new ModelAndView();
    }


    @GetMapping("/init-role-resource")
    @ApiOperation("初始化系统资源")
    @ResponseBody
    @PublicUrl
    public void initSysResource(){
        sysInitService.initRole();
        sysInitService.initMenuLevel();
        sysResourceServiceImpl.autoGeneratorAllMenuResource();
    }

    @GetMapping("/scan-resource")
    @ApiOperation("扫描资源")
    @ResponseBody
    @PublicUrl
    public List<SysResource> scanResource(){
        return sysResourceServiceImpl.autoGeneratorAllMenuResource();
    }

    @GetMapping("/scan-resource/{zlass}")
    @ApiOperation("扫描资源")
    @ResponseBody
    public List<SysResource> scanResourceByClass(@ApiParam() @PathVariable("zlass") String zlass){
        if (StrUtil.isNotBlank(zlass)) {
            Class<Object> loadClass = ClassUtil.loadClass(zlass);
            if (Objects.nonNull(loadClass)) {
                return sysResourceServiceImpl.scanController(loadClass);
            }
        }
        return null;
    }
}
