package com.example.airesumescreener.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScreeningResult {
    private String candidateName;
    private String fileName;
    private int matchScore; // 0-100
    private String predictedRole;
    private List<String> extractedSkills;
    private Double btechPercentage;
    private boolean isEligible;
    private String overallSummary;
    private List<String> keyStrengths;
    private List<String> missingSkills;
}
