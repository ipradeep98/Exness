package com.my.exness.model;

import com.my.exness.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "deposits")
@Getter
@Setter
public class Deposits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    private String asset;
    private BigDecimal amount;
    @Column(precision = 30, scale = 12)
    private BigDecimal fee;
    @Column(name = "tx_hash")
    private String transaction;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "confirmed_at")
    private LocalDateTime confirmedAt;
}
