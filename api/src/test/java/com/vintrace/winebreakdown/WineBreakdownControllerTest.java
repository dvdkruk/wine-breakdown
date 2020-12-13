package com.vintrace.winebreakdown;

import com.vintrace.winebreakdown.breakdown.BreakDownService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WineBreakdownControllerTest {

    @MockBean
    private WineRepository repository;

    @Autowired
    private MockMvc mvc;

    @Test
    public void requestBreakDownByYear_ReturnComponents() throws Exception {
        List<WineComponent> components = Arrays.asList(
                new WineComponent(40, 2011, ""),
                new WineComponent(40, 2010, ""),
                new WineComponent(20, 2010, "")
        );
        Wine wine = new Wine("1337WFS", components);
        when(repository.getByLotCode("1337WFS")).thenReturn(Optional.of(wine));

        mvc.perform(get("/api/breakdown/year/1337WFS"))
                .andExpect(status().isOk())
                .andExpect(content().json("{ breakDownType: 'year', breakdown: [ { percentage: '60', key: '2010' }, { percentage: '40', key: '2011' } ] }"));
    }

    @Test
    public void requestBreakDownByVariety_ReturnComponents() throws Exception {
        List<WineComponent> components = Arrays.asList(
                new WineComponent(80, 2011, "Pinot Noir"),
                new WineComponent(20, 2010, "Chardonnay")
        );
        Wine wine = new Wine("VAR1337TST", components);
        when(repository.getByLotCode("VAR1337TST")).thenReturn(Optional.of(wine));

        mvc.perform(get("/api/breakdown/variety/VAR1337TST"))
                .andExpect(status().isOk())
                .andExpect(content().json("{ breakDownType: 'variety', breakdown: [ { percentage: '80', key: 'Pinot Noir' }, { percentage: '20', key: 'Chardonnay' } ] }"));
    }
}