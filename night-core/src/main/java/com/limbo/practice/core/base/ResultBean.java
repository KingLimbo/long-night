package com.limbo.practice.core.base;

/**
 * ResultBean 处理结果Bean
 *
 * @author limbo
 * @Date: 2019/11/12
 */
public class ResultBean {

    // 处理状态
    private String resultFlg;

    // 处理数据
    private Object resultObject;

    // 处理消息
    private String message;

    public String getResultFlg() {
        return resultFlg;
    }

    public void setResultFlg(String resultFlg) {
        this.resultFlg = resultFlg;
    }

    public Object getResultObject() {
        return resultObject;
    }

    public void setResultObject(Object resultObject) {
        this.resultObject = resultObject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
