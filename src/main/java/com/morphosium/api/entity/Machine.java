package com.morphosium.api.entity;

import com.morphosium.api.entity.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Machine extends BaseEntity {
    private String name;
    private String latitude;
    private String longitude;
}
