package com.my.exness.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Stocks {
    @Id
    private long id;
    private String title;
    private String symbol;
}
