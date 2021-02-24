package com.limbo.practice.core.constant;

import lombok.Getter;

@Getter
public enum RoleNameEnum {
    NONE(0, "无"),
    ADMIN(1, "超级管理员");

    int value;
    String name;

    RoleNameEnum(int value, String name) {
    }
}
