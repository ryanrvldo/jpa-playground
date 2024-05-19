package com.ryanrvldo.jpaplayground.persistence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.ZonedDateTime;
import java.util.Optional;

@Configuration
@EnableJpaAuditing(
    dateTimeProviderRef = "dateTimeProvider",
    auditorAwareRef = "auditorProvider"
)
public class PersistenceConfig {

  @Bean
  public DateTimeProvider dateTimeProvider() {
    return () -> Optional.of(ZonedDateTime.now());
  }

  @Bean
  public AuditorAware<String> auditorProvider() {
    return new AuditorAwareImpl();
  }

}
