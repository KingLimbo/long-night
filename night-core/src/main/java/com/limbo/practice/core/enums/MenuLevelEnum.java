package com.limbo.practice.core.enums;

import cn.hutool.core.util.StrUtil;
import com.limbo.practice.core.base.BaseEnum;
import lombok.Getter;

import java.util.Objects;

@Getter
public enum MenuLevelEnum implements BaseEnum {
    ROOT(1001, "根目录", null, 1),
    SYS(1002, "系统管理", ROOT, 1),
    ;

    private final int value;
    private final String name;
    private final MenuLevelEnum parent;
    private final int sort;

    MenuLevelEnum(int value, String name, MenuLevelEnum parent, int sort) {
        this.value = value;
        this.name = name;
        this.parent = parent;
        this.sort = sort;
    }

    public String getParents(){
        String parents = "";
        MenuLevelEnum parent = this.getParent();
        if (Objects.nonNull(parent)) {
            parents = parent.getParents();
            if (StrUtil.isNotBlank(parents)) {
                parents += "," + parent.getValue();
            } else {
                parents = String.valueOf(parent.getValue());
            }
            return parents;
        }
        return null;
    }

}