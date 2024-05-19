package com.ryanrvldo.jpaplayground.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dummy_auditable_entities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DummyAuditableEntity extends AuditableEntity {

    @NotBlank
    private String foo;

    private String bar;

}
