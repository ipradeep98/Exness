package com.my.exness.model;

import com.my.exness.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "withdrawals")
@Getter
@Setter
public class Withdrawals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    private String asset;
    private BigDecimal amount;
    @Column(precision = 30, scale = 12)
    private BigDecimal fee;
    @Column(name = "net_amount")
    private BigDecimal netAmount;
    @Column(name = "tx_hash")
    private String transaction;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Column(name = "whitelist_checked")
    private boolean whitelistChecked;
    @Column(name = "requested_at")
    private LocalDateTime requestedAt;
    @Column(name = "processed_at")
    private LocalDateTime processedAt;
}
