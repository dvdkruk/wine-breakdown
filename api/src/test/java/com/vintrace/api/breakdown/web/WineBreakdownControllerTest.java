package com.vintrace.api.breakdown.web;

import com.vintrace.api.breakdown.domain.models.BreakDownType;
import com.vintrace.api.wine.domain.models.Wine;
import com.vintrace.api.wine.domain.models.WineComponent;
import com.vintrace.api.wine.domain.WineRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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

    @BeforeEach
    public void beforeEach() {
        List<WineComponent> components = Arrays.asList(
                new WineComponent(40.0, 2011, "Pinot Noir", "Mornington"),
                new WineComponent(40.0, 2010, "Pinot Noir", "Macedon"),
                new WineComponent(20.0, 2010, "Chardonnay", "Macedon")
        );
        Wine wine = new Wine("1337WFS", 0d, "Best wine ever!!", "tankCode", "state", "owner", components);
        when(repository.getByLotCode("1337WFS")).thenReturn(Optional.of(wine));
    }

    @Test
    void requestBreakDownByYear_ReturnBreakdown() throws Exception {
        mvc.perform(get("/api/breakdown/year/1337WFS"))
                .andExpect(status().isOk())
                .andExpect(content().json("{ breakDownType: 'year', breakdown: [ { percentage: '60', key: '2010' }, { percentage: '40', key: '2011' } ] }"));
    }

    @Test
    void requestBreakDownByVariety_ReturnBreakdown() throws Exception {
        mvc.perform(get("/api/breakdown/variety/1337WFS"))
                .andExpect(status().isOk())
                .andExpect(content().json("{ breakDownType: 'variety', breakdown: [ { percentage: '80', key: 'Pinot Noir' }, { percentage: '20', key: 'Chardonnay' } ] }"));
    }

    @Test
    void requestBreakDownByRegion_ReturnBreakdown() throws Exception {
        mvc.perform(get("/api/breakdown/region/1337WFS"))
                .andExpect(status().isOk())
                .andExpect(content().json("{ breakDownType: 'region', breakdown: [ { percentage: '60', key: 'Macedon' }, { percentage: '40', key: 'Mornington' } ] }"));
    }

    @Test
    void requestBreakDownByYearVariety_ReturnBreakdown() throws Exception {
        mvc.perform(get("/api/breakdown/year-variety/1337WFS"))
                .andExpect(status().isOk())
                .andExpect(content().json("{ breakDownType: 'year-variety', breakdown: [ { percentage: '40', key: '2011 - Pinot Noir' }, { percentage: '40', key: '2010 - Pinot Noir' }, { percentage: '20', key: '2010 - Chardonnay' } ] }"));
    }

    @ParameterizedTest
    @EnumSource(BreakDownType.class)
    void requestForNonExistingWine_returnsNotFound(BreakDownType type) throws Exception {
        mvc.perform(get("/api/breakdown/" + type + "/NonExistingWine"))
                .andExpect(status().isNotFound())
                .andExpect(status().reason("breakdown not available for NonExistingWine"));
    }
}