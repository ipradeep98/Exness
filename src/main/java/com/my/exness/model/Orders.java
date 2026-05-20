package com.my.exness.model;

import com.my.exness.model.enums.OrderStatus;
import com.my.exness.model.enums.OrderType;
import com.my.exness.model.enums.OrderSide;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "market_id", nullable = false)
    private Markets market;

    @Column(name = "client_order_id")
    private String clientOrderId;
    @Enumerated(EnumType.STRING)
    private OrderSide side;
    @Enumerated(EnumType.STRING)
    private OrderType type;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Column(precision = 30, scale = 12)
    private BigDecimal price;
    @Column(name = "stop_price")
    private BigDecimal stopPrice;
    @Column(precision = 30, scale = 12)
    private BigDecimal quantity;
    @Column(name = "filled_qty")
    private BigDecimal filledQty;
    @Column(name = "remaining_qty")
    private BigDecimal remainingQty;
    @Column(name = "fee_charged")
    private BigDecimal feeCharged;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "expires_at")
    private LocalDateTime expiresAt;
}
