package com.ryanrvldo.jpaplayground.service;

import com.ryanrvldo.jpaplayground.persistence.entity.JsonSampleEntity;
import com.ryanrvldo.jpaplayground.persistence.repository.JsonSampleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JsonSampleService {

    private final JsonSampleRepository repository;

    @Transactional
    public void create(JsonSampleEntity entity) {
        repository.save(entity);
    }

    public List<JsonSampleEntity> findAll() {
        return repository.findAll();
    }

}
