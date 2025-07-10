package com.Swaggy.Instamart.modal;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "warehouse_products")
public class WarehouseProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     Long id;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
     WareHouse warehouse;

    @ManyToOne
    @JoinColumn(name = "product_id")
     Product product;

     int quantity;
     double price;
}

