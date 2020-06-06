package com.will.asgard.thor.service.spittr;

import org.springframework.stereotype.Component;

import com.will.asgard.thor.model.spittr.Spitter;
import com.will.asgard.thor.model.spittr.SpitterRepository;

@Component
public class SpitterRepositoryImpl implements SpitterRepository {

    @Override
    public Spitter save(Spitter spitter) {
        Spitter res = new Spitter();
        res.setId(24L);
        res.setUsername(spitter.getUsername());
        res.setFirstName(spitter.getFirstName());
        res.setLastName(spitter.getLastName());

        return res;
    }

    @Override
    public Spitter findByUsername(String username) {
        Spitter res = new Spitter();
        res.setId(24L);
        res.setUsername(username);
        res.setFirstName("Jack");
        res.setLastName("Bauer");

        return res;
    }
}
