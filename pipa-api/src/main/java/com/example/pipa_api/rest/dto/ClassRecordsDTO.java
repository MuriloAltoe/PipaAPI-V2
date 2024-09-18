package com.example.pipa_api.rest.dto;

import com.example.pipa_api.domain.entity.ClassRecords;
import com.example.pipa_api.domain.entity.Employee;
import com.example.pipa_api.domain.entity.GoogleDriveMedia;
import com.example.pipa_api.domain.entity.Students;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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

    private GoogleDriveMedia media;

    private Employee employee;

    private Students student;

    public static ClassRecordsDTO toDTO(ClassRecords classRecords){
        ClassRecordsDTO dto = new ClassRecordsDTO();

        dto.setId(classRecords.getId());
        dto.setClassDate(classRecords.getClassDate());
        dto.setStartTime(classRecords.getStartTime());
        dto.setEndTime(classRecords.getEndTime());
        dto.setLocation(classRecords.getLocation());
        dto.setStatus(classRecords.getStatus());
        dto.setSubject(classRecords.getSubject());
        dto.setMedia(classRecords.getMedia());
        dto.setEmployee(classRecords.getEmployee());
        dto.setStudent(classRecords.getStudent());

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
        classRecords.setMedia(dto.getMedia());
        classRecords.setEmployee(dto.getEmployee());
        classRecords.setStudent(dto.getStudent());

        return classRecords;
    }

}