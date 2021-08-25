package com.limbo.practice.core.base;

import cn.hutool.core.collection.CollUtil;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author limbo
 * @date 2021/8/24
 */
@Data
public class PageRO implements Serializable {

    @ApiModelProperty(name = "页码")
    protected Integer page = 1;

    @ApiModelProperty(name = "查询条数")
    protected Integer limit = 10;

    /**
     * 生成bean
     */
    public static <T, VO> VO toBean(T bean, Class<VO> voClass){
        try {
            VO vo = voClass.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(bean, vo);
            return vo;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成ListVO
     */
    public static <T, VO> List<VO> toListBean(List<T> beans, Class<VO> voClass){
        try {
            ArrayList<VO> list = Lists.newArrayList();
            if (CollUtil.isNotEmpty(beans)) {
                for (T bean : beans) {
                    VO vo = voClass.getDeclaredConstructor().newInstance();
                    BeanUtils.copyProperties(bean, vo);
                    list.add(vo);
                }
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 是否需要分页
     * @return
     */
    public Boolean needPage(){
        if (Objects.nonNull(page) && page > 0 && Objects.nonNull(limit) && limit > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
