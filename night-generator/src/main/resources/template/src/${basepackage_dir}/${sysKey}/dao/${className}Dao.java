<#include "/java_copyright.include">
package ${basepackage}.${sysKey}.dao;

import com.limbo.practice.core.mybatis.MybatisDao;
import com.limbo.practice.core.base.BaseDao;
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

@MybatisDao
public interface ${table.className}Dao extends BaseDao<${table.className}> {

}
