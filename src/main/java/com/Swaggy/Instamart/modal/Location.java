package com.Swaggy.Instamart.modal;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     UUID id;
     String addressLine;
     String area;
     String city;
     String state;
     String pincode;
     Double latitude;
     Double longitude;
}
