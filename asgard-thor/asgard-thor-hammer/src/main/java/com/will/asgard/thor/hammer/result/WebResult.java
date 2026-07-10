package com.will.asgard.thor.hammer.result;

import java.io.Serializable;

/**
 * 统一 Web 响应结果封装
 *
 * @param <T> 响应数据类型
 */
public class WebResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    private int statusCode;

    /**
     * 状态消息
     */
    private String statusMsg;

    /**
     * 响应数据（泛型）
     */
    private T response;

    /**
     * 耗时（毫秒）
     */
    private long costTime;

    public WebResult() {
    }

    public WebResult(int statusCode, String statusMsg, T response, long costTime) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
        this.response = response;
        this.costTime = costTime;
    }

    /**
     * 创建成功响应
     */
    public static <T> WebResult<T> success(T data) {
        return new WebResult<>(0, "success", data, 0);
    }

    /**
     * 创建成功响应（带耗时）
     */
    public static <T> WebResult<T> success(T data, long costTime) {
        return new WebResult<>(0, "success", data, costTime);
    }

    /**
     * 创建失败响应
     */
    public static <T> WebResult<T> error(int statusCode, String msg) {
        return new WebResult<>(statusCode, msg, null, 0);
    }

    /**
     * 创建失败响应（带耗时）
     */
    public static <T> WebResult<T> error(int statusCode, String msg, long costTime) {
        return new WebResult<>(statusCode, msg, null, costTime);
    }

    // Getters and Setters
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public long getCostTime() {
        return costTime;
    }

    public void setCostTime(long costTime) {
        this.costTime = costTime;
    }
}
