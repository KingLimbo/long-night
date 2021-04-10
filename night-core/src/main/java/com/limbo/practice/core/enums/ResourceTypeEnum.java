package com.limbo.practice.core.enums;

import com.limbo.practice.core.base.BaseEnum;
import lombok.Getter;
@Getter
public enum ResourceTypeEnum implements BaseEnum {

    MENU(1, "菜单"),
    RESOURCE(2, "资源"),
    CONTENTS(3, "目录"),
    ;

    private final int value;
    private final String name;

    ResourceTypeEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }
}
