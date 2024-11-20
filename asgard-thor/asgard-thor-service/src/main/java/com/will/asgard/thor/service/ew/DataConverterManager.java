package com.will.asgard.thor.service.ew;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author willmao
 * Created on 2024/10/21 23:54
 **/
@Service
public class DataConverterManager {

    @Autowired
    private List<DataConverter> dataConverterList;

    public Map<String,Object> convertData(Object data, String dataId) {
        for (DataConverter converter : dataConverterList) {
            if (converter.support(dataId)) {
                return converter.convertData(data);
            }
        }
        return null;
    }
}
