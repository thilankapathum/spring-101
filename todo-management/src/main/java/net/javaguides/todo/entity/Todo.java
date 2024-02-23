package net.javaguides.todo.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity     //-- Specify Todo class as a JPA entity
@Table(name = "todos")      //-- Map the table in a database with JPA entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //-- Auto Increment
    private Long id;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    private boolean completed;
}
