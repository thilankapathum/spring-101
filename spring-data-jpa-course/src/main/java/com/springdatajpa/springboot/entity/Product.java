package com.springdatajpa.springboot.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity //-- Specify this class as a JPA entity (Can apply to Class,Interface of Enums)
@Getter //-- Define Getter methods using Lombok library. No need to manually create.
@Setter
@NoArgsConstructor  //-- Default Constructor without any argument(inputs)
@AllArgsConstructor //-- Create Constructor with all argument(inputs)
@ToString   //-- Lombok will provide ToString at runtime
@Table(name = "products",       //-- Customize table name and schema(DB name)
        schema = "ecommerce",
        uniqueConstraints = {@UniqueConstraint(name = "sku_unique",columnNames = "stock_keeping_unit")}        //-- Make "stock_keeping_unit" column a unique column
)
public class Product {

    @Id     //-- Making primary key
    //@GeneratedValue(strategy = GenerationType.IDENTITY)     //-- Generate a value and make it an Auto Increment
    //@GeneratedValue(strategy = GenerationType.AUTO)             //-- Automatically generate a value. A separate table will keep track of all generated values
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_generator")         //-- Generate Primary key using DB sequence
    @SequenceGenerator(name = "product_generator", sequenceName = "product_sequence_name", allocationSize = 1)  //-- allocationSize: increment by 1, sequenceName: Sequence table name
    private long id;

    @Column(name = "stock_keeping_unit", nullable = false)      //-- provide custom column name & keep the field not-Null
    private String sku;

    @Column(nullable = false,length = 254)      //-- Set length of column
    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageurl;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    /*public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }*/
}
