package com.example.pipa_api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pipa_api.domain.entity.ClassRecords;

@Repository
public interface ClassRecordsRepository extends JpaRepository<ClassRecords, Long> {
}
