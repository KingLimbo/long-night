package com.limbo.practice.base.entity.ro;

import com.limbo.practice.core.base.PageRO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户页面参数RO
 *
 * @author limbo
 * @date 2021/8/24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "用户页面参数RO")
public class SysUserRO extends PageRO {

    @ApiModelProperty(name = "登录账号")
    private String loginAccount;

    @ApiModelProperty(name = "昵称")
    private String userName;

    /**
     * 性别 说明：1 表示男，0 表示女
     */
    @ApiModelProperty(name = "性别")
    private Boolean userSex;

    /**
     * 用户类型 说明：1 系统管理员 ，0 普通用户
     */
    @ApiModelProperty(name = "用户类型", example = "1")
    private Boolean userType;

    @ApiModelProperty(name = "是否已锁定", example = "true")
    private Boolean locked;
}
