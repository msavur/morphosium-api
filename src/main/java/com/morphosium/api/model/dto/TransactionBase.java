package com.morphosium.api.model.dto;

import com.morphosium.api.enums.DeviceType;
import com.morphosium.api.enums.Operation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionBase {
    private String ip;
    private Long machineId;
    private Long userId;
    private DeviceType deviceType;
    private Operation operation;
    private BigDecimal amount;
}
