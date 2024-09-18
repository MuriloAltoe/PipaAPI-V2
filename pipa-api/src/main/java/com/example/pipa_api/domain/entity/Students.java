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
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "disability_type", length = 30)
    private String disabilityType;

    @Column(name = "student_name", length = 50)
    private String studentName;

    @Column(name = "student_social_name", length = 50)
    private String studentSocialName;

    @Column(name = "gender", length = 20)
    private String gender;

    @Column(name = "telephone", length = 15)
    private String telephone;

    @Column(name = "mail", length = 50)
    private String mail;

    @Column(name = "education_level", length = 30)
    private String educationLevel;

    @Column(name = "medical_informations", columnDefinition = "TEXT")
    private String medicalInformations;

    @Column(name = "medicines_in_use", columnDefinition = "TEXT")
    private String medicinesInUse;

    @Column(name = "processing_information", columnDefinition = "TEXT")
    private String processingInformation;

    @Column(name = "is_student")
    private Boolean isStudent;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @Column(name = "create_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "update_at", nullable = false)
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