package com.morphosium.api.repository;


import com.morphosium.api.entity.Transaction;
import com.morphosium.api.enums.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Optional<Transaction> findByIdAndOperation(Long id, Operation operation);
}