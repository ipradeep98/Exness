package com.my.exness.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Fills {
    @Id
    private long id;
    private long stockId;
    private BigDecimal price;
    private int quantity;
    private long buyOrderId;
    private long sellOrderId;
}
