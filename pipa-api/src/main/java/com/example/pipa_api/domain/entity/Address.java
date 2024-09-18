package com.example.pipa_api.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "adresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zip_code", length = 8)
    private String zipCode;

    @Column(name = "street", length = 30)
    private String street;

    @Column(name = "house_number", length = 6)
    private String houseNumber;

    @Column(name = "neighborhood", length = 40)
    private String neighborhood;

    @Column(name = "city", length = 30)
    private String city;

    @Column(name = "state", length = 20)
    private String state;

    @Column(name = "complement", length = 20)
    private String complement;

    @Column(name = "country", length = 20)
    private String country;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
