package com.example.pipa_api.domain.repository;

import com.example.pipa_api.domain.entity.ClassRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRecordsRepository extends JpaRepository<ClassRecords, Long> {
}
