package com.Swaggy.Instamart.modal;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "deliveryPartners")
public class DeliveryPartner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id; // Same as user_id (one-to-one)

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
     User user;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    WareHouse warehouse;

    boolean isAvailable;
}
