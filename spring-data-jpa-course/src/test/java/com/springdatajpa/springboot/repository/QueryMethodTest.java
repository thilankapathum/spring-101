package com.springdatajpa.springboot.repository;


import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMethodTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod(){
        Product product = productRepository.findByName("Product 1");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void  findByIdMethod(){
        Product product = productRepository.findById(8L).get();

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());

    }

    @Test
    void findByNameOrDescriptionMethod(){
        List<Product> products = productRepository.findByNameOrDescription("Product 1","Product Description 1");

        products.forEach((p) -> {
            System.out.println(p.getName());
        });
    }

    @Test
    void findByNameAndDescriptionMethod(){
        List<Product> products = productRepository.findByNameAndDescription("Product 2","Product 2 description");

        products.forEach((p) -> {
            System.out.println(p.getName());
            System.out.println(p.getId());
            System.out.println(p.getDescription());
        });
    }

    @Test
    void findDistinctByName(){
        List<Product> products = productRepository.findDistinctByName("Product 1");

        products.forEach((p) -> {
            System.out.println(p.getName());
            System.out.println(p.getId());
            System.out.println(p.getDescription());
        });
    }
}
