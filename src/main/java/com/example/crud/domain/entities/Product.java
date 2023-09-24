package com.example.crud.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Table(name="products")
@Entity(name="products")
@EqualsAndHashCode(of="id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private Integer price;

    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
}
