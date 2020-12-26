<#include "/java_copyright.include">
package ${basepackage}.${sysKey}.dao;

import com.eims.kernel.persistence.annotation.MyBatisDao;
import com.eims.kernel.persistence.dao.CrudDao;
import ${basepackage}.${sysKey}.entity.${table.className};

/**
*
* @ProjectName: long-night
* @PackageName: ${basepackage}.${sysKey}.dao
* @ClassName: ${table.className}Dao
* @Description: TODO(这里用一句话描述这个类的作用)
* @Author: ${author}
* @Date: ${now?string('yyyy-MM-dd hh:mm:ss')}
* @Modifier: ${author}
* @ModifiedDate: ${now?string('yyyy-MM-dd hh:mm:ss')}
*
* version V1.0
*/

@MyBatisDao
public interface ${table.className}Dao extends CrudDao<${table.className}> {

}
