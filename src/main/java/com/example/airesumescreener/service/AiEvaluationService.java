package com.example.airesumescreener.service;

import com.example.airesumescreener.model.ScreeningResult;

public interface AiEvaluationService {
    ScreeningResult evaluate(String resumeText, String jobDescription);
    ScreeningResult evaluate(String resumeText, String jobDescription, String fileName);
}
