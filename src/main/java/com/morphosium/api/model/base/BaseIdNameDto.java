package com.morphosium.api.model.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseIdNameDto {

    private Long id;
    private String name;

    public BaseIdNameDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

