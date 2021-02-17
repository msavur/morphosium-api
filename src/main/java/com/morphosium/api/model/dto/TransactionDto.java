package com.morphosium.api.model.dto;

import com.morphosium.api.enums.DeviceType;
import com.morphosium.api.enums.Operation;
import com.morphosium.api.model.base.BaseIdNameDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto implements Serializable {
    private Long id;
    private Operation operation;
    private DeviceType deviceType;
    private BigDecimal amount;
    private BaseIdNameDto machine;
}