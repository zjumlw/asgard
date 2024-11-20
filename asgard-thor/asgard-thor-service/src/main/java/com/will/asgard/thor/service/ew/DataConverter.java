package com.will.asgard.thor.service.ew;

import java.util.Map;

/**
 * @author willmao
 * Created on 2024/10/21 23:47
 **/
public interface DataConverter {

    /**
     * 是否支持当前的 dataId
     *
     * @param dataId dataId
     * @return true/false
     */
    boolean support(String dataId);

    /**
     * 转换数据
     *
     * @param originData 原始数据
     * @return 转换后的数据
     */
    Map<String, Object> convertData(Object originData);
}
