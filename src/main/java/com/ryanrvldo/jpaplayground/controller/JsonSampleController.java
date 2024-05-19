package com.ryanrvldo.jpaplayground.controller;

import com.ryanrvldo.jpaplayground.model.response.WebResponse;
import com.ryanrvldo.jpaplayground.persistence.entity.JsonSampleEntity;
import com.ryanrvldo.jpaplayground.service.JsonSampleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JsonSampleController {

    private final JsonSampleService service;

    @PostMapping(value = "/json-samples")
    public ResponseEntity<WebResponse<String>> create(@RequestBody @Valid JsonSampleEntity entity) {
        service.create(entity);
        return ResponseEntity.ok(new WebResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), "Success", null, null));
    }

    @GetMapping(value = "/json-samples", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WebResponse<List<JsonSampleEntity>>> getAll() {
        var entities = new WebResponse<List<JsonSampleEntity>>()
                .withCode(HttpStatus.OK.value())
                .withStatus(HttpStatus.OK.getReasonPhrase())
                .withData(service.findAll());
        return ResponseEntity.ok(entities);
    }

}
