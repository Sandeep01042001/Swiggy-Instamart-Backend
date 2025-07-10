package com.Swaggy.Instamart.modal;


import jakarta.persistence.*;
import lombok.Data;
import java.util.*;

import java.util.UUID;


@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
