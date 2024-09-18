package com.example.pipa_api.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "class_records")
public class ClassRecords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class_date")
    private LocalDate classDate;

    @Column(name = "start_time")
    private LocalDate startTime;

    @Column(name = "end_time")
    private LocalDate endTime;

    @Column(name = "location", length = 40)
    private String location;

    @Column(name = "status", length = 40)
    private String status;

    @Column(name = "subject", length = 40)
    private String subject;

    @ManyToOne
    @JoinColumn(name = "media_id")
    private GoogleDriveMedia media;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Students student;
}
