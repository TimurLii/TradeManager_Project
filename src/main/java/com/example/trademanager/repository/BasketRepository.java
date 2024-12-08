package com.example.trademanager.repository;

import com.example.trademanager.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BasketRepository extends JpaRepository<Basket, Long> {
    @Query("SELECT b FROM Basket b JOIN b.products p WHERE p.id = :productId")
    List<Basket> findByProductId(@Param("productId") Long productId);
}
