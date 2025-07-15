package com.Swaggy.Instamart.modal;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID user_id;
    String name;
    @Column(unique = true, nullable = false)
    String email;
    String role;
    String status;
    @Column(nullable = false)
    String password;
    @Column(unique = true, nullable = false)
    long phoneNumber;
    @OneToMany
    List<Location> locations;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

}
