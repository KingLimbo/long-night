<#include "/macro.include"/>
<#include "/java_copyright.include">
package ${basepackage}.${sysKey}.service.impl;

import org.springframework.stereotype.Service;

import ${basepackage}.core.base.BaseServiceImpl;
import ${basepackage}.${sysKey}.dao.${table.className}Dao;
import ${basepackage}.${sysKey}.entity.${table.className};
import ${basepackage}.${sysKey}.service.${table.className}Service;

/**
*
* @ProjectName: long-night
* @PackageName: ${basepackage}.${sysKey}.service.impl
* @ClassName: ${table.className}Service
* @Description: TODO(这里用一句话描述这个类的作用)
* @Author: ${author}
* @Date: ${now?string('yyyy-MM-dd hh:mm:ss')}
* @Modifier: ${author}
* @ModifiedDate: ${now?string('yyyy-MM-dd hh:mm:ss')}
*
* version V1.0
*/

@Service
public class ${table.className}ServiceImpl extends BaseServiceImpl<${table.className}, ${table.className}Dao> implements ${table.className}Service<${table.className}, ${table.className}Dao> {

}
