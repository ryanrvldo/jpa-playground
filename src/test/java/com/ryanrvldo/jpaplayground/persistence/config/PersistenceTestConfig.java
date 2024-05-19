package com.ryanrvldo.jpaplayground.persistence.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@TestConfiguration
@Import({PersistenceConfig.class})
@EnableJpaRepositories(basePackages = "com.ryanrvldo.jpaplayground")
@EntityScan(basePackages = "com.ryanrvldo.jpaplayground")
public class PersistenceTestConfig {

}
