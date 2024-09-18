package com.example.pipa_api.service;

import com.example.pipa_api.domain.entity.ClassRecords;
import com.example.pipa_api.domain.repository.ClassRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassRecordsService {
    private final ClassRecordsRepository classRecordsRepository;

    @Autowired
    public ClassRecordsService(ClassRecordsRepository classRecordsRepository) {
        this.classRecordsRepository = classRecordsRepository;
    }

    public List<ClassRecords> findAll() {
        return classRecordsRepository.findAll();
    }

    public Optional<ClassRecords> findById(Long id) {
        return classRecordsRepository.findById(id);
    }

    public ClassRecords save(ClassRecords classRecords) {
        return classRecordsRepository.save(classRecords);
    }

    public boolean existsById(Long id) {
        return classRecordsRepository.existsById(id);
    }

    public void deleteById(Long id) {
        classRecordsRepository.deleteById(id);
    }
}