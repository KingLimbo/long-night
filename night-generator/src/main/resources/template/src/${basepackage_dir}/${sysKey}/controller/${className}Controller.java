<#include "/macro.include"/>
<#include "/java_copyright.include">
package ${basepackage}.${sysKey}.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ${basepackage}.${sysKey}.controller.BaseController;
import ${basepackage}.${sysKey}.dao.${table.className}Dao;
import ${basepackage}.${sysKey}.entity.${table.className};

import ${basepackage}.${sysKey}.service.I${table.className}Service;

/**
*
* @ProjectName: long-night
* @PackageName: ${basepackage}.${sysKey}.controller
* @ClassName: ${table.className}Controller
* @Description: TODO(这里用一句话描述这个类的作用)
* @Author: ${author}
* @Date: ${now?string('yyyy-MM-dd hh:mm:ss')}
* @Modifier: ${author}
* @ModifiedDate: ${now?string('yyyy-MM-dd hh:mm:ss')}
*
* version V1.0
*/

@Controller
public class ${table.className}Controller extends BaseController {
    @Autowired
    private I${table.className}Service<${table.className}Dao,${table.className}>  ${table.className?uncap_first}Service;
}
