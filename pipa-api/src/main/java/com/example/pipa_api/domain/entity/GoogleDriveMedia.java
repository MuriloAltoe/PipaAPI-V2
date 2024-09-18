package com.example.pipa_api.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "google_drive_media")
public class GoogleDriveMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", length = 50)
    private String description;

    @Column(name = "file_name", length = 100)
    private String fileName;

    @Column(name = "file_type", length = 100)
    private String fileType;

    @Column(name = "url")
    private String url;
}