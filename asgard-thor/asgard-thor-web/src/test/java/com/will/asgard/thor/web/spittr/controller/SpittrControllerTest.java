package com.will.asgard.thor.web.spittr.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class SpittrControllerTest {

    @Test
    public void testHome() throws Exception {
        SpittrController controller = new SpittrController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/spittr"))
                .andExpect(MockMvcResultMatchers.view().name("home"));
    }
}