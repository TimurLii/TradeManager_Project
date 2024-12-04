package com.example.trademanager;


import com.example.trademanager.repository.BasketRepository;
import com.example.trademanager.repository.ClientRepository;
import com.example.trademanager.repository.ManagerRepository;
import com.example.trademanager.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import java.util.*;

@SpringBootApplication
public class TradeManagerApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(TradeManagerApplication.class, args);

        BasketRepository basketRepository = context.getBean(BasketRepository.class);
        ClientRepository clientRepository = context.getBean(ClientRepository.class);
        ManagerRepository managerRepository = context.getBean(ManagerRepository.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);


//        productRepository.deleteById(3l);
//        basketRepository.deleteById(1l);
//        managerRepository.deleteById(1l);

    }
}
