package com.ryanrvldo.jpaplayground.persistence.repository;

import com.ryanrvldo.jpaplayground.persistence.entity.DummyAuditableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DummyAuditableRepository extends JpaRepository<DummyAuditableEntity, String> {
}

