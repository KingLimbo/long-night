package com.limbo.practice.core.enums;

import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Sets;
import com.limbo.practice.core.base.BaseEnum;
import lombok.Getter;

import java.util.Objects;
import java.util.Set;

import static com.limbo.practice.core.enums.RoleNameEnum.ADMIN;
import static com.limbo.practice.core.enums.RoleNameEnum.NORMAL;

@Getter
public enum MenuLevelEnum implements BaseEnum {
    ROOT(1, "根目录", null, Sets.newHashSet(), 1),
    SYS(2, "系统管理", ROOT, Sets.newHashSet(ADMIN), 1),
    BUSINESS(3, "业务管理", ROOT, Sets.newHashSet(ADMIN, NORMAL), 2),
    ;

    private final int value;
    private final String name;
    private final MenuLevelEnum parent;
    private final Set<RoleNameEnum> roles;
    private final int sort;

    MenuLevelEnum(int value, String name, MenuLevelEnum parent, Set<RoleNameEnum> roles, int sort) {
        this.value = value;
        this.name = name;
        this.parent = parent;
        this.roles = roles;
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