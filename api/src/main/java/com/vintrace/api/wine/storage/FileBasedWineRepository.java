package com.vintrace.api.wine.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vintrace.api.wine.domain.models.Wine;
import com.vintrace.api.wine.domain.WineRepository;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
class FileBasedWineRepository implements WineRepository {

    private final ObjectMapper mapper = new ObjectMapper();
    private final PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    private final List<Wine> wines = new ArrayList<>();

    public FileBasedWineRepository() throws IOException {
        loadFiles();
    }

    @Override
    public Optional<Wine> getByLotCode(String lotCode) {
        return wines.stream()
                .filter(wine -> wine.getLotCode().equals(lotCode))
                .findFirst();
    }

    @Override
    public List<Wine> findByLotCodeContainingOrDescriptionContaining(String query) {
        return wines.stream()
                .filter(wine -> contains(wine.getLotCode(), query) || contains(wine.getDescription(), query))
                .collect(Collectors.toList());
    }

    private boolean contains(String value, String query) {
        return value != null && value.contains(query);
    }

    private void loadFiles() throws IOException {
        Arrays.stream(resolver.getResources("classpath:data/*.json"))
                .map(resource -> {
                    try {
                        return mapper.readValue(resource.getFile(), Wine.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                }).forEach(this.wines::add);
    }
}
