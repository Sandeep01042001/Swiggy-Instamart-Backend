package com.Swaggy.Instamart.modal;


import jakarta.persistence.*;
import lombok.Data;
import java.util.*;

import java.util.UUID;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    UUID product_id;
    String name;
    String brand;

    @Column(length = 1000)
    String description;
    String imageUrl;
    String category;  // Ex -> "Snacks", "Beverages", "Fruits", etc.
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<WarehouseProduct> warehouseProducts;


}
