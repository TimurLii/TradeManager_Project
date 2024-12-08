package com.example.trademanager.service;

import com.example.trademanager.entity.Basket;
import com.example.trademanager.repository.BasketRepository;
import com.example.trademanager.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final BasketRepository basketRepository;

    public ProductService(ProductRepository productRepository, BasketRepository basketRepository) {
        this.productRepository = productRepository;
        this.basketRepository = basketRepository;
    }

    @Transactional
    public void deleteProduct(Long productId) {
        List<Basket> baskets = basketRepository.findByProductId(productId);

        for (Basket basket : baskets) {
            // Удаляем продукт из корзины
            basket.getProducts().removeIf(product -> product.getId().equals(productId));
            basketRepository.save(basket); // Сохраняем изменения в корзине
        }

        productRepository.deleteById(productId); // Удаляем продукт из репозитория
    }
}