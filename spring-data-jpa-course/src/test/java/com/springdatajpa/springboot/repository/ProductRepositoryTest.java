package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest //-- Load full Application Context (load all Spring Beans from main)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test   //-- Recognize this method as a Test case
    void saveMethod(){
        //--  create product
        Product product = new Product();
        product.setName("Product 1");
        product.setDescription("Product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageurl("product1.png");

        //-- save product
        Product savedObject = productRepository.save(product);

        //-- display product info
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }

    @Test
    void updateUsingSaveMethod(){

        //-- retrieve an entity by ID
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        //-- update entity information
        product.setName("Updated Product 1");
        product.setDescription("Updated Product 1 Description");

        //-- save updated entity
        productRepository.save(product);

    }

    @Test
    void findByID(){
        Long id = 1L;   //-- just hardcode here for testing

        Product product = productRepository.findById(id).get();

    }

    @Test
    void saveAll(){
        //--  create product2
        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setDescription("Product 2 description");
        product2.setSku("100ABCD");
        product2.setPrice(new BigDecimal(200));
        product2.setActive(true);
        product2.setImageurl("product2.png");

        //--  create product3
        Product product3 = new Product();
        product3.setName("Product 3");
        product3.setDescription("Product 3 description");
        product3.setSku("100ABCDE");
        product3.setPrice(new BigDecimal(300));
        product3.setActive(true);
        product3.setImageurl("product3.png");

        productRepository.saveAll(List.of(product2, product3));     //-- saveAll should provide List as argument
    }

    @Test
    void findAllMethod(){       //-- Retrieve all records from a table
        List<Product> products = productRepository.findAll();

        products.forEach((p) -> {
            System.out.println(p.getName());
        });

    }

    @Test
    void deleteByIdMethod(){
        Long id = 3L;   //-- hardcode ID

        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod(){

        //-- find an entity by id
        Long id = 2L;   //-- hardcode ID
        Product product = productRepository.findById(id).get();

        //-- delete(entity)
        productRepository.delete(product);

    }

    @Test
    void deleteAllMethod(){
        productRepository.deleteAll();
    }


    @Test
    void countMethod(){
        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existsByIdMethod(){
        long id = 2;
        boolean exists = productRepository.existsById(id);
        System.out.println(exists);
    }
}