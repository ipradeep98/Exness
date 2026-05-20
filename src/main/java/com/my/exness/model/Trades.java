package com.my.exness.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "trades")
@Getter
@Setter
public class Trades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "market_id", nullable = false)
    private Markets market;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maker_order_id")
    private Orders makerOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taker_order_id")
    private Orders takerOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maker_user_id")
    private Users makerUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taker_user_id")
    private Users takerUser;

    private BigDecimal price;
    private BigDecimal quantity;
    @Column(name = "maker_fee")
    private BigDecimal makerFee;
    @Column(name = "taker_fee")
    private BigDecimal takerFee;
    @Column(name = "is_buyer_maker")
    private Boolean buyerMaker;
    @Column(name = "traded_at")
    private LocalDateTime tradedAt;
}
