package com.Swaggy.Instamart.modal;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.*;

@Entity
@Data
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    UUID card_id;

    // Cart belongs to one shopper
    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    // List of cart items
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    List<CardItem> cartItems;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
