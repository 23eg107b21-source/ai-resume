package com.example.airesumescreener.service;

import com.example.airesumescreener.model.ScreeningResult;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.airesumescreener.model.CandidateScreening;
import com.example.airesumescreener.repository.CandidateScreeningRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScreeningServiceImpl implements ScreeningService {

    private final ResumeParserService resumeParserService;
    private final AiEvaluationService aiEvaluationService;
    private final CandidateScreeningRepository candidateScreeningRepository;

    @Override
    public List<ScreeningResult> screen(List<MultipartFile> resumes, String jobDescription) {
        List<ScreeningResult> results = new ArrayList<>();
        
        for (MultipartFile resume : resumes) {
            try {
                log.info("Starting resume screening for file: {}", resume.getOriginalFilename());
                
                // Extract text from resume
                String resumeText = resumeParserService.extractText(resume);
                
                // Evaluate using AI
                ScreeningResult result = aiEvaluationService.evaluate(resumeText, jobDescription, resume.getOriginalFilename());
                
                // Save to database
                CandidateScreening screeningRecord = CandidateScreening.builder()
                        .candidateName(result.getCandidateName())
                        .fileName(resume.getOriginalFilename())
                        .jobDescription(jobDescription)
                        .resumeText(resumeText)
                        .matchScore(result.getMatchScore())
                        .predictedRole(result.getPredictedRole())
                        .extractedSkills(result.getExtractedSkills())
                        .btechPercentage(result.getBtechPercentage())
                        .isEligible(result.isEligible())
                        .overallSummary(result.getOverallSummary())
                        .build();
                
                candidateScreeningRepository.save(screeningRecord);
                log.info("Saved screening result for candidate: {}", result.getCandidateName());
                
                results.add(result);
                
            } catch (Exception e) {
                log.error("Error screening resume: {}", resume.getOriginalFilename(), e);
                // Continue with other resumes even if one fails
            }
        }
        
        // Sort results by match score descending (Ranking)
        results.sort((a, b) -> Integer.compare(b.getMatchScore(), a.getMatchScore()));
        
        return results;
    }
}
