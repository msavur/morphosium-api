package com.morphosium.api.mapper;


import com.morphosium.api.entity.Transaction;
import com.morphosium.api.model.dto.TransactionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(implementationPackage = "mapper.impl")
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);


    TransactionDto toTransactionResponse(Transaction transaction);

}