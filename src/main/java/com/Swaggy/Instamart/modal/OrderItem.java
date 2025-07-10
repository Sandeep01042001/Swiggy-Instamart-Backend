package com.Swaggy.Instamart.modal;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;
@Data
@Entity
@Table(name = "orderItems")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    // The order this item belongs to
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // The product ordered
    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    int quantity;

    double price;
}
