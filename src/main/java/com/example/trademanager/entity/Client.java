package com.example.trademanager.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "clients")
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_name")
    private String clientName;

    @ManyToOne()
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @OneToOne(cascade = CascadeType.REMOVE) // Удаление корзины при удалении клиента
    @JoinColumn(name = "basket_id") // Измените на basket_id, если вы используете его как внешний ключ
    private Basket basket;
}
