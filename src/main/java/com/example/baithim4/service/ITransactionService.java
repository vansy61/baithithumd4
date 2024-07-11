package com.example.baithim4.service;

import com.example.baithim4.model.Transaction;
import com.example.baithim4.model.TransactionDto;
import org.springframework.data.domain.Page;

public interface ITransactionService {
    Iterable<TransactionDto> searchAll(String search, String transactionType);

    void save(Transaction transaction);

    Transaction findById(Long id);

    void deleteById(Long id);
}
