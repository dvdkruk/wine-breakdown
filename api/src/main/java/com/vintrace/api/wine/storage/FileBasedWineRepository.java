package com.vintrace.api.wine.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vintrace.api.wine.domain.Wine;
import com.vintrace.api.wine.domain.WineRepository;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

@Repository
class FileBasedWineRepository implements WineRepository {

    private final ObjectMapper mapper = new ObjectMapper();

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
            Wine wine = mapper.readValue(file, Wine.class);
            return Optional.of(wine);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
