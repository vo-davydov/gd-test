package org.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "OKOPF")
public class Okopf extends AbstractEntity {
    private String name;
    private String code;

    public Okopf() {

    }

    public Okopf(LocalDateTime created, LocalDateTime updated) {
        super(created, updated);
    }

    @Column(name = "NAME", unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "CODE", unique = true)
    @NotNull(message = "code is required.")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
