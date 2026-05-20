package com.my.exness.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.my.exness.model.enums.MarketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "markets")
@Getter
@Setter
public class Markets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String symbol;
    @Column(name = "base_asset")
    private String baseAsset;
    @Column(name = "quote_asset")
    private String quoteAsset;
    @Column(name = "tick_size")
    private BigDecimal tickSize;
    @Column(name = "lot_size")
    private BigDecimal lotSize;
    @Column(name = "min_qty")
    private BigDecimal minQty;
    @Column(name = "max_qty")
    private BigDecimal maxQty;
    @Column(name = "maker_fee_rate")
    private BigDecimal makerFeeRate;
    @Column(name = "taker_fee_rate")
    private BigDecimal takerFeeRate;
    @Enumerated(EnumType.STRING)
    private MarketStatus status;
    @Column(name = "price_precision")
    private int pricePrecision;
    @Column(name = "qty_precision")
    private int qtyPrecision;

    @JsonIgnore
    @OneToMany(mappedBy = "market")
    private List<Orders> orders;
}
