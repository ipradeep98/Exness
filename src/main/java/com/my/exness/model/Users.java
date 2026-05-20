package com.my.exness.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    @Column(name = "user_name")
    private String userName;
    private String password;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "last_login_at")
    private LocalDateTime lastLoginAt;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Wallets> wallets;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Deposits> deposits;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Withdrawals> withdrawals;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Orders> orders;

}
