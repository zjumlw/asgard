package com.will.asgard.thor.web.spittr.controller;

import com.will.asgard.thor.model.spittr.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String spittles(Model model) {
//        model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
//        return "spittles";
//    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(
            Model model,
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) Long max,
            @RequestParam(value = "count", defaultValue = "20") Integer count) {
        model.addAttribute(spittleRepository.findSpittles(max, count));
        return "spittles";
    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(
            @PathVariable long spittleId,
            Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }
}
