package com.morphosium.api.model.request;


import com.morphosium.api.model.dto.TransactionBase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {

    private TransactionBase transaction;

}
