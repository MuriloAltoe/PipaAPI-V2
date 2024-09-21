package com.example.pipa_api.rest.dto;

import java.time.LocalDate;

import com.example.pipa_api.domain.entity.ClassRecords;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassRecordsDTO {

    private Long id;

    private LocalDate classDate;

    private LocalDate startTime;

    private LocalDate endTime;

    private String location;

    private String status;

    private String subject;

    private Long media;

    private Long employee;

    private Long student;

    public static ClassRecordsDTO toDTO(ClassRecords classRecords){
        ClassRecordsDTO dto = new ClassRecordsDTO();

        dto.setId(classRecords.getId());
        dto.setClassDate(classRecords.getClassDate());
        dto.setStartTime(classRecords.getStartTime());
        dto.setEndTime(classRecords.getEndTime());
        dto.setLocation(classRecords.getLocation());
        dto.setStatus(classRecords.getStatus());
        dto.setSubject(classRecords.getSubject());
        dto.setMedia(classRecords.getMedia().getId());
        dto.setEmployee(classRecords.getEmployee().getId());
        dto.setStudent(classRecords.getStudent().getId());

        return dto;
    }

    public static ClassRecords toOBJ(ClassRecordsDTO dto) {
        ClassRecords classRecords = new ClassRecords();

        classRecords.setId(dto.getId());
        classRecords.setClassDate(dto.getClassDate());
        classRecords.setStartTime(dto.getStartTime());
        classRecords.setEndTime(dto.getEndTime());
        classRecords.setLocation(dto.getLocation());
        classRecords.setStatus(dto.getStatus());
        classRecords.setSubject(dto.getSubject());

        return classRecords;
    }
}