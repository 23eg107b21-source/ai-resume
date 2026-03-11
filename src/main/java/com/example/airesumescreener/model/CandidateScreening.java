package com.example.airesumescreener.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "candidate_screenings")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateScreening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String candidateName;

    private String fileName;
    
    @Lob
    private String jobDescription;
    
    @Lob
    private String resumeText;

    private int matchScore;

    private String predictedRole;

    @ElementCollection
    @CollectionTable(name = "candidate_skills", joinColumns = @JoinColumn(name = "screening_id"))
    @Column(name = "skill")
    private List<String> extractedSkills;

    private Double btechPercentage;

    private boolean isEligible;
    
    @Lob
    private String overallSummary;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
