package com.vintrace.api.wine.storage;

import com.vintrace.api.wine.domain.models.Wine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = FileBasedWineRepository.class)
class FileBasedWineRepositoryTest {

    @Autowired
    private FileBasedWineRepository repository;

    @Test
    void getByLotCode_forExistingWine() {
        Optional<Wine> wine = repository.getByLotCode("11YVCHAR001-TST");
        assertTrue(wine.isPresent());
    }

    @Test
    void getByLotCode_forNonExistingWine() {
        Optional<Wine> wine = repository.getByLotCode("NonExisting");
        assertFalse(wine.isPresent());
    }

    @ParameterizedTest
    @ValueSource(strings = {"TST", "tst"})
    void findByLotCodeContainingOrDescriptionContaining_forLotCodeMatch() {
        List<Wine> wines = repository.findByLotCodeContainingOrDescriptionContaining("TST");
        assertEquals(1, wines.size());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Test", "test"})
    void findByLotCodeContainingOrDescriptionContaining_forDescriptionMatch(String query) {
        List<Wine> wines = repository.findByLotCodeContainingOrDescriptionContaining(query);
        assertEquals(1, wines.size());
    }

    @Test
    void findByLotCodeContainingOrDescriptionContaining_forNoMatch() {
        List<Wine> wines = repository.findByLotCodeContainingOrDescriptionContaining("NoMatchingSearchQuery");
        assertEquals(0, wines.size());
    }
}