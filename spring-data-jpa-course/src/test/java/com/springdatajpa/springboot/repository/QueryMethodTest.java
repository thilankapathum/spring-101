package com.springdatajpa.springboot.repository;


import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
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

    @Test
    void  findPriceGreaterThanMethod(){
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(100));

        products.forEach((p) -> {
            System.out.println(p.getName());
            System.out.println(p.getPrice());
        });
    }

    @Test
    void findByNameContainingMethod(){
        List<Product> products = productRepository.findByNameContaining("Product");

        products.forEach((p) -> {
            System.out.println(p.getName());
        });
    }

    @Test
    void findByNameLikeMethod(){
        List<Product> products = productRepository.findByNameLike("Product 1");

        products.forEach((p)->{
            System.out.println(p.getName());
        });
    }

    @Test
    void findByPriceBetweenMethod(){
        List<Product> products = productRepository.findByPriceBetween(new BigDecimal(100), new BigDecimal(300));

        products.forEach((p)->{
            System.out.println(p.getName());
            System.out.println(p.getPrice());
        });
    }

    @Test
    void findByDateCreatedBetweenMethod(){

        LocalDateTime startTime = LocalDateTime.of(2024, Month.FEBRUARY,4,23,0);
        LocalDateTime endTime = LocalDateTime.of(2024,Month.FEBRUARY,4,23,8);

        List<Product> products = productRepository.findByDateCreatedBetween(startTime,endTime);

        products.forEach((p)->{
            System.out.println(p.getName());
            System.out.println(p.getDateCreated());
        });
    }

    @Test
    void findByNameInMethod(){

        List<Product> products = productRepository.findByNameIn(List.of("Product 1","Product 2"));

        products.forEach((p)->{
            System.out.println(p.getName());
        });
    }

    @Test
    void findFirst2ByOrderByNameAscMethod(){
        List<Product> products = productRepository.findFirst2ByOrderByNameAsc();

        products.forEach((p)->{
            System.out.println(p.getName());
        });
    }

    @Test
    void findTop2ByOrderByPriceDscMethod(){
        List<Product> products = productRepository.findTop2ByOrderByPriceDesc();

        products.forEach((p)->{
            System.out.println(p.getName());
        });
    }
}
