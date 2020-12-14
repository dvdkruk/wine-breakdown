package com.vintrace.api.wine.web;

import com.vintrace.api.wine.domain.Wine;
import com.vintrace.api.wine.domain.WineRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WineControllerTest {

    @MockBean
    private WineRepository repository;

    @Autowired
    private MockMvc mvc;

    @Test
    void searchWine_returnsWines() throws Exception {
        Wine wine = new Wine("TST", "123", "2010 - best wine", "TAN8", "state", "owner", Collections.emptyList());
        when(repository.findByLotCodeContainingOrDescriptionContaining("TST"))
                .thenReturn(Collections.singletonList(wine));

        mvc.perform(get("/api/wines").param("search", "TST"))
                .andExpect(status().isOk())
                .andExpect(content().json("{ wines: [ { lotCode: 'TST', volume: '123', tankCode: 'TAN8', description: '2010 - best wine', productState: 'state', ownerName: 'owner' } ] }"));
    }

    @Test
    void searchWine_returnsNoResults() throws Exception {
        when(repository.findByLotCodeContainingOrDescriptionContaining("TST")).thenReturn(Collections.emptyList());

        mvc.perform(get("/api/wines").param("search", "TST"))
                .andExpect(status().isOk())
                .andExpect(content().json("{ wines: [] }"));
    }
}