package com.limbo.practice.core.enums;

import com.limbo.practice.core.base.BaseEnum;
import lombok.Getter;
@Getter
public enum RoleNameEnum implements BaseEnum {
    ADMIN(1, "超级管理员"),
    NORMAL(2, "普通用户"),
    ;

    private final int value;
    private final String name;

    RoleNameEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }
}