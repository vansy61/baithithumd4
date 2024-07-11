package com.example.baithim4.repository;

import com.example.baithim4.model.Transaction;
import com.example.baithim4.model.TransactionDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ITransactionRepo extends CrudRepository<Transaction, Long> {
    @Query("SELECT t FROM Transaction t WHERE " +
            "(:transactionType IS NULL OR :transactionType = '' OR t.transactionType = :transactionType) AND " +
            "(:name IS NULL OR t.customer.name like %:name%)")
    Iterable<TransactionDto> searchTransaction(
            @Param("name") String name,
            @Param("transactionType") String transactionType
    );
}
