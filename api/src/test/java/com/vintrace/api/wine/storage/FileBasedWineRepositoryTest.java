package com.vintrace.api.wine.storage;

import com.vintrace.api.wine.domain.models.Wine;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FileBasedWineRepositoryTest {

    private final FileBasedWineRepository repository = new FileBasedWineRepository();

    FileBasedWineRepositoryTest() throws IOException {
    }

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

    @Test
    void findByLotCodeContainingOrDescriptionContaining_forLotCodeMatch() {
        List<Wine> wines = repository.findByLotCodeContainingOrDescriptionContaining("TST");
        assertEquals(1, wines.size());
    }

    @Test
    void findByLotCodeContainingOrDescriptionContaining_forDescriptionMatch() {
        List<Wine> wines = repository.findByLotCodeContainingOrDescriptionContaining("Test");
        assertEquals(1, wines.size());
    }

    @Test
    void findByLotCodeContainingOrDescriptionContaining_forNoMatch() {
        List<Wine> wines = repository.findByLotCodeContainingOrDescriptionContaining("NoMatchingSearchQuery");
        assertEquals(0, wines.size());
    }
}