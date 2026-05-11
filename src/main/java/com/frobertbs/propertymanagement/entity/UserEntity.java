package com.frobertbs.propertymanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "User_Table")
@Setter
@Getter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "OwnerName")
    private String ownerName;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Password")
    private String password;
}
