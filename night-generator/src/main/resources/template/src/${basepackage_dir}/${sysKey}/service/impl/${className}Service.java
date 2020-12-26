<#include "/macro.include"/>
<#include "/java_copyright.include">
package ${basepackage}.${sysKey}.service.impl;

import org.springframework.stereotype.Service;

import com.eims.common.service.impl.CrudService;
import ${basepackage}.${sysKey}.dao.${table.className}Dao;
import ${basepackage}.${sysKey}.entity.${table.className};
import ${basepackage}.${sysKey}.service.I${table.className}Service;

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
public class ${table.className}Service extends CrudService<${table.className}Dao,${table.className}> implements I${table.className}Service<${table.className}Dao,${table.className}> {

}
