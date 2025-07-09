package com.Swaggy.Instamart.modal;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID order_id;

    // Shopper who placed the order
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    // Warehouse fulfilling the order
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    WareHouse warehouse;

    // Delivery Location
    @ManyToOne
    @JoinColumn(name = "delivery_location_id")
    Location deliveryLocation;

    // Ordered items
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    List<OrderItem> orderItems;

    double totalAmount;

    String paymentMethod; // ENUM-like: "COD", "UPI", "Card", etc.

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    OrderStatus status;

    LocalDateTime createdAt;
}
