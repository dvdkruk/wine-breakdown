package com.vintrace.api.storage;

import com.vintrace.api.storage.model.Wine;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FileBasedWineRepositoryTest {

    private final FileBasedWineRepository repository = new FileBasedWineRepository();

    @Test
    public void getByLotCode_forExistingWine() {
        Optional<Wine> wine = repository.getByLotCode("15MPPN002-TST");
        assertTrue(wine.isPresent());
    }

    @Test
    public void getByLotCode_forNonExistingWine() {
        Optional<Wine> wine = repository.getByLotCode("NonExisting");
        assertFalse(wine.isPresent());
    }
}