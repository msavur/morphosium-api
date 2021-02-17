package com.morphosium.api.controller;


import com.morphosium.api.config.swagger.AuthorizationInfo;
import com.morphosium.api.controller.endpoint.TransactionEndpoint;
import com.morphosium.api.model.GenericResponse;
import com.morphosium.api.model.request.CreateTransactionRequest;
import com.morphosium.api.model.request.TransactionRequest;
import com.morphosium.api.model.response.TransactionResponse;
import com.morphosium.api.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @AuthorizationInfo
    @PostMapping(value = TransactionEndpoint.GET_TRANSACTION)
    public GenericResponse<TransactionResponse> getTransaction(@PathVariable("id") Long id, @RequestBody CreateTransactionRequest request) {
        return transactionService.getTransaction(id, request);
    }

    @AuthorizationInfo
    @PostMapping(value = TransactionEndpoint.CREATE_TRANSACTION)
    public GenericResponse<?> createTransaction(@RequestBody TransactionRequest request) {
        return transactionService.createTransaction(request);
    }

}
