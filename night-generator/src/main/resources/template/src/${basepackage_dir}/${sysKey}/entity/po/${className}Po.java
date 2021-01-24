<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign baseProps = ["id","createUser","createDate","updateUser","updateDate","delFlag"]>
package ${basepackage}.${sysKey}.entity.po;

import ${basepackage}.${sysKey}.entity.DataEntity;
import lombok.Getter;
import lombok.Setter;
/**
*
* @ProjectName: long-night
* @PackageName: ${basepackage}.${sysKey}.entity.po
* @ClassName: ${table.className}Po
* @Description: TODO(这里用一句话描述这个类的作用)
* @Author: ${author}
* @Date: ${now?string('yyyy-MM-dd hh:mm:ss')}
* @Modifier: ${author}
* @ModifiedDate: ${now?string('yyyy-MM-dd hh:mm:ss')}
*
* version V1.0
*/
@Getter
@Setter
public class ${table.className}Po<T> extends DataEntity<T>{

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;
    <#list table.columns as column>
    <#if (baseProps?seq_index_of(column.columnNameLower)) == -1>

    /**
     * ${column.columnAlias!}
     * db_column: ${column.sqlName}
     */
    private ${column.javaType} <@getName itemColumn=column/>;
    </#if>
    </#list>

    public ${table.className}Po(){
        super();
    }

    public ${table.className}Po(String id){
        super(id);
    }
}
