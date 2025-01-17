package com.zhuldyzai.zoo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity

public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private int age;
}
