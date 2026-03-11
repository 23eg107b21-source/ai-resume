package com.example.airesumescreener.controller;

import org.springframework.web.bind.annotation.*;
import com.example.airesumescreener.service.ResumeService;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping("/score")
    public double getScore(@RequestParam("resume") String resume,
            @RequestParam("job") String job) {

        return resumeService.calculateScore(resume, job);
    }
}