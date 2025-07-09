package com.Swaggy.Instamart.modal;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "cardItems")
public class CardItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    UUID id;

    // Belongs to one cart
    @ManyToOne
    @JoinColumn(name = "card_id")
    Card card;

    // Product added
    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;
    int quantity;
}
