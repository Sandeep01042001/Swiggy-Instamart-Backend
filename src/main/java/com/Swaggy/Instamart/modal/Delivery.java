package com.Swaggy.Instamart.modal;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "deliveries")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    // Each delivery is for a specific order
    @OneToOne
    @JoinColumn(name = "order_id")
    Order order;

    //Assigned delivery partner
    @ManyToOne
    @JoinColumn(name = "delivery_partner_id")
    DeliveryPartner deliveryPartner;

    //Delivery status
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    DeliveryStatus status;

    LocalDateTime updatedAt;
}
