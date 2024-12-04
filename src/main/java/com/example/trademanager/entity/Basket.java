package com.example.trademanager.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Поле для хранения идентификатора клиента
    @Column(name = "client_id", nullable = false)
    private Long clientId;

    // Поле для хранения итоговой стоимости товаров в корзине
    @Column(name = "result_price")
    private BigDecimal resultPrice;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "basket_products",
            joinColumns = @JoinColumn(name = "basket_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    // Если вы хотите связать корзину с клиентом, вы можете использовать следующую аннотацию
    @OneToOne
    @JoinColumn(name = "client_id", insertable = false, updatable = false) // Убедитесь, что это поле не будет вставляться или обновляться
    private Client client;

    //TODO добавить поле resultPrice, в котором будет отображаться итоговая стоимость товаров в корзине
}
