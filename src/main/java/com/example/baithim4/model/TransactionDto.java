package com.example.baithim4.model;

import java.sql.Date;

public interface TransactionDto {
    Long getId();
    String getCode();
    Date getTransactionDate();
    String getTransactionType();
    Double getAmount();
    Double getArea();
    Customer getCustomer();

}
