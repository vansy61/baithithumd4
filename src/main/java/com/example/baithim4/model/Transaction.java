package com.example.baithim4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên khách hàng không được để trống")
    @Pattern(regexp = "^[A-Z]{3}-[0-9]{4}$", message = "Mã giao dịch phải theo format MGD-XXXX")
    private String code;

    @NotNull
    @FutureOrPresent(message = "Ngày giao dịch phải lớn hơn hiện tại")
    private Date transactionDate;

    @NotNull
    private String transactionType;

    @NotNull(message = "Đơn giá không được để trống")
    @Min(value = 500000, message = "Số tiền giao dịch phải lớn hơn 500,000 VNĐ")
    private Double amount;

    @NotNull(message = "Diện tích không được để trống")
    @Min(value = 20, message = "Diện tích phải lớn hơn 20")
    private Double area;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
}
