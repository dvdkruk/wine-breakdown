package com.vintrace.winebreakdown;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WineBreakdownController.class)
class WineBreakdownControllerTest {

    @MockBean
    private WineRepository repository;

    @Autowired
    private MockMvc mvc;

    @Test
    public void requestBreakDownByYear_ReturnComponentsByYear() throws Exception {
        List<WineComponent> components = Arrays.asList(
                new WineComponent(49, 2011),
                new WineComponent(51, 2010)
        );
        Wine wine = new Wine("1337WFS", components);
        when(repository.getByLotCode("1337WFS")).thenReturn(Optional.of(wine));

        mvc.perform(get("/api/breakdown/year/1337WFS"))
                .andExpect(status().isOk())
                .andExpect(content().json("{ breakDownType: 'year', breakdown: [ { percentage: '51' }, { percentage: '49' } ] }"));
    }
}