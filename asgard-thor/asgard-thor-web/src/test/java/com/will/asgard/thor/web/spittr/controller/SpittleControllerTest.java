package com.will.asgard.thor.web.spittr.controller;

import com.will.asgard.thor.model.spittr.Spittle;
import com.will.asgard.thor.model.spittr.SpittleRepository;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpittleControllerTest {

    @Test
    public void showShowRecentSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(20);

        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
        Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE, 20))
                .thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/views/spittles.jsp"))
                .build();

        mockMvc.perform(MockMvcRequestBuilders.get("/spittles"))
                .andExpect(MockMvcResultMatchers.view().name("spittles"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))
                .andExpect(MockMvcResultMatchers.model()
                        .attribute("spittleList", CoreMatchers.hasItems(expectedSpittles.toArray())));
    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            spittles.add(new Spittle("Spittle" + i, new Date()));
        }
        return spittles;
    }

    @Test
    public void shouldShowPagedSpittled() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(50);
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
        Mockito.when(mockRepository.findSpittles(238900, 50))
                .thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/views/spittles.jsp"))
                .build();

        mockMvc.perform(MockMvcRequestBuilders.get("/spittles?max=238900&count=50"))
                .andExpect(MockMvcResultMatchers.view().name("spittles"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))
                .andExpect(MockMvcResultMatchers.model()
                        .attribute("spittleList", CoreMatchers.hasItems(expectedSpittles.toArray())));
    }

    @Test
    public void testSpittle() throws Exception {
        Spittle expectedSpittle = new Spittle("Hello", new Date());
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
        Mockito.when(mockRepository.findOne(12345))
                .thenReturn(expectedSpittle);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .build();
        mockMvc.perform(MockMvcRequestBuilders.get("/spittles/12345"))
                .andExpect(MockMvcResultMatchers.view().name("spittle"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittle"))
                .andExpect(MockMvcResultMatchers.model().attribute("spittle", expectedSpittle));
    }
}