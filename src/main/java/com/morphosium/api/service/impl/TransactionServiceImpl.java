package com.morphosium.api.service.impl;

import com.morphosium.api.entity.Machine;
import com.morphosium.api.entity.Transaction;
import com.morphosium.api.entity.User;
import com.morphosium.api.exception.CustomServiceException;
import com.morphosium.api.model.GenericResponse;
import com.morphosium.api.model.base.BaseIdNameDto;
import com.morphosium.api.model.dto.TransactionDto;
import com.morphosium.api.model.request.CreateTransactionRequest;
import com.morphosium.api.model.request.TransactionRequest;
import com.morphosium.api.model.response.TransactionResponse;
import com.morphosium.api.repository.MachineRepository;
import com.morphosium.api.repository.TransactionRepository;
import com.morphosium.api.repository.UserRepository;
import com.morphosium.api.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final MachineRepository machineRepository;


    @Transactional
    @Override
    public GenericResponse<?> createTransaction(TransactionRequest request) {
        Optional<User> userOptional = userRepository.findByEnabledTrueAndId(request.getTransaction().getUserId());
        if (!userOptional.isPresent()) {
            throw new CustomServiceException("User Not Found.");
        }
        Optional<Machine> machineOptional = machineRepository.findById(request.getTransaction().getMachineId());
        if (!machineOptional.isPresent()) {
            throw new CustomServiceException("Machine Not Found.");
        }
        Transaction transaction = new Transaction();
        transaction.setDeviceType(request.getTransaction().getDeviceType());
        transaction.setAmount(request.getTransaction().getAmount());
        transaction.setUser(userOptional.get());
        transaction.setOperation(request.getTransaction().getOperation());
        transaction.setMachine(machineOptional.get());
        transaction.setCreateDate(new Date());
        transaction.setUpdateDate(new Date());
        Transaction saved = transactionRepository.save(transaction);
        TransactionDto transactionResponse = createTransactionResponse(saved);
        return GenericResponse.ok(new TransactionResponse(transactionResponse));
    }

    @Override
    public GenericResponse<TransactionResponse> getTransaction(Long id, CreateTransactionRequest request) {
        Optional<Transaction> transactionOptional = transactionRepository.findByIdAndOperation(id, request.getOperationType());
        if (!transactionOptional.isPresent()) {
            return GenericResponse.resourceNotFound();
        }
        Transaction transaction = transactionOptional.get();
        TransactionDto transactionDto = createTransactionResponse(transaction);
        return GenericResponse.ok(new TransactionResponse(transactionDto));
    }

    private TransactionDto createTransactionResponse(Transaction transaction) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(transaction.getId());
        transactionDto.setOperation(transaction.getOperation());
        transactionDto.setDeviceType(transaction.getDeviceType());
        transactionDto.setAmount(transaction.getAmount());
        transactionDto.setMachine(new BaseIdNameDto(transaction.getMachine().getId(), transaction.getMachine().getName()));
        return transactionDto;
    }
}
