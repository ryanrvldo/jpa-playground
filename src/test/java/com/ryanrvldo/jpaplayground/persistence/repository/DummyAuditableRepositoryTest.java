package com.ryanrvldo.jpaplayground.persistence.repository;

import com.ryanrvldo.jpaplayground.persistence.config.PersistenceTestConfig;
import com.ryanrvldo.jpaplayground.persistence.entity.DummyAuditableEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ContextConfiguration(classes = {
        PersistenceTestConfig.class,
        DummyAuditableRepository.class}
)
class DummyAuditableRepositoryTest {

    @Autowired
    private DummyAuditableRepository repository;

    @Test
    @DisplayName("When create an entity, all audit properties should not null and as expected")
    void testAuditPropertiesNotNull() {
        var entity = repository.save(new DummyAuditableEntity("foo", "bar"));
        // assert all field are not null
        assertNotNull(entity.getId());
        assertNotNull(entity.getCreatedAt());
        assertNotNull(entity.getCreatedBy());
        assertNotNull(entity.getUpdatedAt());
        assertNotNull(entity.getUpdatedBy());
        assertNotNull(entity.getVersion());
        // additional assertions
        assertFalse(entity.getId().trim().isEmpty());
        assertFalse(entity.getId().length() < 32);
        assertEquals(entity.getCreatedAt(), entity.getUpdatedAt());
        assertEquals(0, entity.getVersion());
        var currentDateTime = ZonedDateTime.now();
        assertTrue(entity.getCreatedAt().isBefore(currentDateTime));
        assertTrue(entity.getUpdatedAt().isBefore(currentDateTime));
    }

    @Test
    @DisplayName("When update entity, should only change updated date")
    void testAuditPropertiesWhenUpdateEntity() {
        // save initial entity to database
        var entity = repository.save(new DummyAuditableEntity("foo", "bar"));
        assertNotNull(entity.getId());
        assertEquals(0, entity.getVersion());
        // update data
        entity.setFoo("new foo");
        entity.setBar("new bar");
        var updatedEntity = repository.saveAndFlush(entity);
        // assert auditing properties
        assertEquals(1, updatedEntity.getVersion());
        assertNotEquals("foo", updatedEntity.getFoo());
        assertNotEquals("bar", updatedEntity.getBar());
        assertEquals(entity.getCreatedBy(), entity.getUpdatedBy());
        assertNotEquals(entity.getCreatedAt(), entity.getUpdatedAt());
        assertTrue(entity.getUpdatedAt().isAfter(entity.getCreatedAt()));
    }
}
