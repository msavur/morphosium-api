package com.morphosium.api.service;

import com.morphosium.api.model.GenericResponse;
import com.morphosium.api.model.request.CreateTransactionRequest;
import com.morphosium.api.model.request.TransactionRequest;
import com.morphosium.api.model.response.TransactionResponse;

public interface TransactionService {
    GenericResponse<?> createTransaction(TransactionRequest request);

    GenericResponse<TransactionResponse> getTransaction(Long id, CreateTransactionRequest request);
}
