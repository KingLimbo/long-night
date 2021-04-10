package com.limbo.practice.core.mybatis;

import com.limbo.practice.core.base.BaseEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * com.limbo.practice.core.mybatis
 * 基础枚举Mybatis处理类
 *
 * @author limbo
 * @version 2021/2/25
 */
public class BaseEnumMybatisHandler<E extends Enum<E> & BaseEnum> extends BaseTypeHandler<BaseEnum> {

    private Class<BaseEnum> type;

    public BaseEnumMybatisHandler(Class<BaseEnum> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }

    private BaseEnum convert(int status) {
        BaseEnum[] objs = type.getEnumConstants();
        for (BaseEnum em : objs) {
            if (em.getValue() == status) {
                return em;
            }
        }
        return null;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, BaseEnum baseEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, baseEnum.getValue());
    }

    @Override
    public BaseEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int value = resultSet.getInt(s);
        return convert(value);
    }

    @Override
    public BaseEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int value = resultSet.getInt(i);
        return convert(value);
    }

    @Override
    public BaseEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int value = callableStatement.getInt(i);
        return convert(value);
    }
}
