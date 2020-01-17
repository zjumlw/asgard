package com.will.asgard.thor.service.spittr;

import java.util.List;

import org.springframework.stereotype.Component;

import com.will.asgard.thor.model.spittr.Spittle;
import com.will.asgard.thor.model.spittr.SpittleRepository;

/**
 * @ClassName SpittleRepositoryImpl
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-01-17 19:05
 * @Version 1.0
 **/
@Component
public class SpittleRepositoryImpl implements SpittleRepository {
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }

    @Override
    public Spittle findOne(long id) {
        return null;
    }
}
