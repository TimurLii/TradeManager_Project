package com.example.trademanager.entity;

import jakarta.persistence.*;
import lombok.Data;

// сущность отвечающая в которой хранится количество товаров
@Entity
@Table(name = "product_stocks")
@Data
public class ProductStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity")
    private int quantity;

}