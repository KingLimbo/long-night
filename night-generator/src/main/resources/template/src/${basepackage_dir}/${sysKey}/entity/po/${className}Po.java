<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign baseProps = ["id","gmtCreate","gmtModified","isDeleted"]>
package ${basepackage}.${sysKey}.entity.po;

import ${basepackage}.core.base.BaseBO;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
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
@Accessors(chain = true)
public class ${table.className}Po extends BaseBO {

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

    public ${table.className}Po(<#list table.columns as column>${column.javaType} <@getName itemColumn=column/><#if column_has_next>,</#if></#list>){
        super(id, deleted, gmtCreate, gmtModified);
        <#list table.columns as column>
        <#if (baseProps?seq_index_of(column.columnNameLower)) == -1>
        this.<@getName itemColumn=column/> = <@getName itemColumn=column/>;
        </#if>
        </#list>
    }

}
