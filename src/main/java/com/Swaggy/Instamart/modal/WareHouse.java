package com.Swaggy.Instamart.modal;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "warehouses")
public class WareHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     UUID id;
     String name;
     String address;
    // 📍 Location (Many warehouses can share one location)
    @ManyToOne
    @JoinColumn(name = "location_id")
     Location location;
    // Warehouse Manager (Admin User)
    @OneToOne
    @JoinColumn(name = "manager_id")
     User manager;

    // List of Products in this Warehouse
    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    List<WarehouseProduct> products;

    // 🚴 Delivery Partners Assigned to this Warehouse
    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
     List<DeliveryPartner> deliveryPartners;

    LocalDateTime createAT;
}
