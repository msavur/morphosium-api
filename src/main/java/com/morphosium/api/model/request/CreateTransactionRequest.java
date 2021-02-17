package com.morphosium.api.model.request;


import com.morphosium.api.enums.Operation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateTransactionRequest {
    private Long id;
    private Operation operationType;
}
