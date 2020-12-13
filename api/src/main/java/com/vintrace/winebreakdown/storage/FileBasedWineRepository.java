package com.vintrace.winebreakdown.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vintrace.winebreakdown.storage.model.Wine;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

@Repository
class FileBasedWineRepository implements WineRepository {

    @Override
    public Optional<Wine> getByLotCode(String lotCode) {
        if (lotCode == null || lotCode.isEmpty()) {
            return Optional.empty();
        }

        URL fileUrl = this.getClass().getClassLoader().getResource("data/" + lotCode + ".json");
        if(fileUrl == null) {
            return Optional.empty();
        }

        File file = new File(fileUrl.getFile());
        if(!file.exists()) {
            return Optional.empty();
        }

        try {
            Wine wine = new ObjectMapper().readValue(file, Wine.class);
            return Optional.of(wine);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
