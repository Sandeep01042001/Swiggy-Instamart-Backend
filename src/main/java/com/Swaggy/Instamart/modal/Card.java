package com.Swaggy.Instamart.modal;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.*;


@Data
@Table(name = "cards")
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID card_id;

    // Cart belongs to one shopper
    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    // List of cart items
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, orphanRemoval = true)
    List<CardItem> cardItems;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
