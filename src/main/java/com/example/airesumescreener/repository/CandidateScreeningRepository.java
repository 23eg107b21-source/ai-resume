package com.example.airesumescreener.repository;

import com.example.airesumescreener.model.CandidateScreening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateScreeningRepository extends JpaRepository<CandidateScreening, Long> {
}
