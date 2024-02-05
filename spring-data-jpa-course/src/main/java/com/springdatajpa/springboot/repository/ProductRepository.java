package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    //-- Find a Product by "name" field. findByName automatically creates SQL Query using find (SELECT)... ByName (WHERE name="") according to Hibernate convention.
    public Product findByName(String name);

    //-- Find a Product by "id" field.
    Optional<Product> findById(Long id);

    //-- Find a List of Products by "name" or "description"
    List<Product> findByNameOrDescription(String name, String description);

    //-- Find a List of Products by "name" AND "description"
    List<Product> findByNameAndDescription(String name, String description);

    //-- Find a List of Distinct Products by "name"
    List<Product> findDistinctByName(String name);
}
