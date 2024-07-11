package com.example.baithim4.service.impl;


import com.example.baithim4.model.Transaction;
import com.example.baithim4.model.TransactionDto;
import com.example.baithim4.repository.ITransactionRepo;
import com.example.baithim4.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService implements ITransactionService {
    @Autowired
    private ITransactionRepo transactionRepo;

    @Override
    public Iterable<TransactionDto> searchAll(String name, String transactionType) {
        System.out.println(name);
        System.out.println(transactionType);
        return transactionRepo.searchTransaction(name, transactionType);
    }

    @Override
    public void save(Transaction transaction) {
        transactionRepo.save(transaction);
    }

    @Override
    public Transaction findById(Long id) {
        return transactionRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        transactionRepo.deleteById(id);
    }
}
