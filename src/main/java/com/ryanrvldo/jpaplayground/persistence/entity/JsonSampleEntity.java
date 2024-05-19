package com.ryanrvldo.jpaplayground.persistence.entity;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JsonSampleEntity extends AuditableEntity {

    @Column(name = "data_json", columnDefinition = "jsonb")
    @Type(JsonType.class)
    @NotBlank
    private String dataJson;

    @Column(name = "data_text", columnDefinition = "text")
    private String dataText;

}
