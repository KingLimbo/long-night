<#include "/macro.include"/>
<#include "/java_copyright.include">
package ${basepackage}.${sysKey}.service;

import ${basepackage}.${sysKey}.service.ICrudService;

/**
*
* @ProjectName: long-night
* @PackageName: ${basepackage}.${sysKey}.service
* @ClassName: I${table.className}Service
* @Description: TODO(这里用一句话描述这个类的作用)
* @Author: ${author}
* @Date: ${now?string('yyyy-MM-dd hh:mm:ss')}
* @Modifier: ${author}
* @ModifiedDate: ${now?string('yyyy-MM-dd hh:mm:ss')}
*
* version V1.0
*/
public interface I${table.className}Service<D,T> extends ICrudService<D,T> {


}
