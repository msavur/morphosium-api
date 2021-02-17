package com.morphosium.api.entity;

import com.morphosium.api.entity.base.BaseEntity;
import com.morphosium.api.enums.DeviceType;
import com.morphosium.api.enums.Operation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Transaction extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private Operation operation;

    @Enumerated(EnumType.STRING)
    private DeviceType deviceType;

    @ManyToOne
    private User user;

    @ManyToOne
    private Machine machine;

    private BigDecimal amount;
}
