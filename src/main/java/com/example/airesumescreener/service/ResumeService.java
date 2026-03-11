package com.example.airesumescreener.service;

import org.springframework.stereotype.Service;

@Service
public class ResumeService {

    public double calculateScore(String resume, String job) {

        if (resume.contains("Java") && job.contains("Java")) {
            return 80;
        }

        return 40;
    }
}