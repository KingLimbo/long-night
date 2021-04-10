package com.limbo.practice.core.enums;

import com.limbo.practice.core.base.BaseEnum;
import lombok.Getter;
@Getter
public enum RoleNameEnum implements BaseEnum {
    NONE(0, "无"),
    ADMIN(1, "超级管理员"),
    ;

    private final int value;
    private final String name;

    RoleNameEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }
}