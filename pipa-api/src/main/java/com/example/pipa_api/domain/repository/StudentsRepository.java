package com.example.pipa_api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pipa_api.domain.entity.Students;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long> {
}
