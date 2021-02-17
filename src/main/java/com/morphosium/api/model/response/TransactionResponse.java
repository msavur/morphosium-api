package com.morphosium.api.model.response;

import com.morphosium.api.model.dto.TransactionDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionResponse {
    private TransactionDto transaction;

    public TransactionResponse(TransactionDto transaction) {
        this.transaction = transaction;
    }
}