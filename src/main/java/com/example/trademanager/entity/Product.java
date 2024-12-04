package com.example.trademanager.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private int price;

    @ManyToMany(mappedBy = "products")
    private List<Basket> baskets;

    //TODO добавить поле count в котором будет отображаться количество товара соответственно не каждый сможет его взять
    // todo можно добавить поле maxCountForClient -> будет количество товара, который сможет взять один клиент
}
