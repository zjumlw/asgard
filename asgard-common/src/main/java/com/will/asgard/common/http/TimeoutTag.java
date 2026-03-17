package com.will.asgard.common.http;

import lombok.Builder;

/**
 * TimeoutTag类用于封装HTTP请求的超时配置
 * 包含连接超时、读取超时和写入超时三个参数
 *
 * @author willmao
 * Created on 2025/9/4 11:02
 */
@Builder
public class TimeoutTag {
    // 连接超时时间（毫秒）
    private final int connectTimeout;

    // 读取超时时间（毫秒）
    private final int readTimeout;

    // 写入超时时间（毫秒）
    private final int writeTimeout;

    /**
     * 构造函数，初始化三种超时时间
     *
     * @param connectTimeout 连接超时时间（毫秒）
     * @param readTimeout 读取超时时间（毫秒）
     * @param writeTimeout 写入超时时间（毫秒）
     */
    public TimeoutTag(Integer connectTimeout, Integer readTimeout, Integer writeTimeout) {
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
        this.writeTimeout = writeTimeout;
    }

    /**
     * 获取连接超时时间
     * @return connectTimeout 连接超时时间（毫秒）
     */
    public Integer getConnectTimeout() { return connectTimeout; }

    /**
     * 获取读取超时时间
     * @return readTimeout 读取超时时间（毫秒）
     */
    public Integer getReadTimeout() { return readTimeout; }

    /**
     * 获取写入超时时间
     * @return writeTimeout 写入超时时间（毫秒）
     */
    public Integer getWriteTimeout() { return writeTimeout; }
}

