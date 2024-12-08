package com.example.trademanager.repository;

import com.example.trademanager.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, Long> {
    // todo добавить метод который при добавлении товара в корзину будет будет менять количество доступного товара
}
