package com.limbo.practice.core.base;

import lombok.Data;

/**
 * ResultBean 处理结果Bean
 *
 * @author limbo
 * @Date: 2019/11/12
 */
@Data
public class ResultBean {

    /**
     * 处理状态
     */
    private String resultFlg;

    /**
     * 处理数据
     */
    private Object resultObject;

    /**
     * 处理消息
     */
    private String message;
}
