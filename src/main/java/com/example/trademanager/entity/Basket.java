package com.example.trademanager.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Entity
@Table(name = "baskets")
@Data
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_id", nullable = false)
    private Long clientId;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "basket_products",
            joinColumns = @JoinColumn(name = "basket_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    @OneToOne
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private Client client;

}
