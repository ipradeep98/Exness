package com.my.exness.model;

import com.my.exness.model.enums.MarketType;
import com.my.exness.model.enums.OrderSide;
import com.my.exness.model.enums.OrderStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Orders {
    @Id
    private long id;
    private long userId;
    private OrderSide side;
    private MarketType marketType;
    private long stockId;
    private int quantity;
    private BigDecimal price;
    private int filledQty;
    private OrderStatus status;
}
