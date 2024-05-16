package com.example.jeeproject.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private double quantity;
    private double productUnitPrice;

    @ManyToMany(mappedBy = "products")
    List<Order> orders = new ArrayList<>();
}
