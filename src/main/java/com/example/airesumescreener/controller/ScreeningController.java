package com.example.airesumescreener.controller;

import com.example.airesumescreener.model.ScreeningResult;
import com.example.airesumescreener.service.ScreeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/screen")
@RequiredArgsConstructor
public class ScreeningController {

    private final ScreeningService screeningService;

    @PostMapping
    public ResponseEntity<List<ScreeningResult>> screenResumes(
            @RequestParam("resumes") List<MultipartFile> resumes,
            @RequestParam("jobDescription") String jobDescription) {
        
        List<ScreeningResult> results = screeningService.screen(resumes, jobDescription);
        return ResponseEntity.ok(results);
    }
}
