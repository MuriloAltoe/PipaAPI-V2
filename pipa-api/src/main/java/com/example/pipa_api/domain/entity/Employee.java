package com.example.pipa_api.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_name", length = 50)
    private String employeeName;

    @Column(name = "employee_social_name", length = 50)
    private String employeeSocialName;

    @Column(name = "registre_document", length = 25)
    private String registreDocument;

    @Column(name = "councils_type", length = 30)
    private String councilsType;

    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "crm", length = 20)
    private String crm;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "gender", length = 20)
    private String gender;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "mail", length = 50)
    private String mail;

    @Column(name = "position", length = 50)
    private String position;

    @Column(name = "hiring_at")
    private LocalDate hiringAt;

    @Column(name = "dismissal_at")
    private LocalDate dismissalAt;

    @Column(name = "department", length = 30)
    private String department;

    @Column(name = "active")
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

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
