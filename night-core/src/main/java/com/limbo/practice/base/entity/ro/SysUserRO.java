package com.limbo.practice.base.entity.ro;

import com.limbo.practice.core.base.PageRO;
import io.swagger.annotations.ApiModel;
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
}
