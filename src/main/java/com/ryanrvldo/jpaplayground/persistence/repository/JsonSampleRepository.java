package com.ryanrvldo.jpaplayground.persistence.repository;

import com.ryanrvldo.jpaplayground.persistence.entity.JsonSampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JsonSampleRepository extends JpaRepository<JsonSampleEntity, String> {
}
