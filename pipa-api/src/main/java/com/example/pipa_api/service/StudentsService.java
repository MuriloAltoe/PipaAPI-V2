package com.example.pipa_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pipa_api.domain.entity.Students;
import com.example.pipa_api.domain.repository.StudentsRepository;

@Service
public class StudentsService {
    private final StudentsRepository studentsRepository;

    @Autowired
    public StudentsService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public List<Students> findAll() {
        return studentsRepository.findAll();
    }

    public Optional<Students> findById(Long id) {
        return studentsRepository.findById(id);
    }

    public Students save(Students students) {
        return studentsRepository.save(students);
    }

    public boolean existsById(Long id) {
        return studentsRepository.existsById(id);
    }

    public void deleteById(Long id) {
        studentsRepository.deleteById(id);
    }
}