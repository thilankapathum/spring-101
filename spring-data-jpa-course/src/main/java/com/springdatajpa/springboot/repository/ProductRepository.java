package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    //-- Find a List of Products where "price" is greater than a value
    List<Product> findByPriceGreaterThan(BigDecimal price);

    //-- Find a List of Products where "name" contains a value
    List<Product> findByNameContaining(String name);

    //-- Like "name"
    List<Product> findByNameLike(String name);

    //-- Between "price". Includes start and end values
    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    //-- Between "date"
    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

    //-- MySQL "in"
    List<Product> findByNameIn(List<String> names);

    //-- Limit Query Result count (First/Top)
    List<Product> findFirst2ByOrderByNameAsc();

    List<Product> findTop2ByOrderByPriceDesc();
}
