package com.limbo.practice.core.constant;

import lombok.Getter;

@Getter
public enum MenuLevelEnum {
    ROOT(0L, "根目录"),
    SYS(1L, "系统管理");

    Long value;
    String name;

    MenuLevelEnum(Long value, String name) {
    }
}
