package com.will.asgard.thor.service.ew;

import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * @author willmao
 * Created on 2024/10/21 23:53
 **/
@Service
public class StockListDataConverter implements DataConverter {

    @Override
    public boolean support(String dataId) {
        return "stockList".equals(dataId);
    }

    @Override
    public Map<String, Object> convertData(Object originData) {
        return null;
    }
}
