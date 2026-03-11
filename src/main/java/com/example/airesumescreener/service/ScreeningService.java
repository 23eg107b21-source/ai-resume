package com.example.airesumescreener.service;

import com.example.airesumescreener.model.ScreeningResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ScreeningService {
    List<ScreeningResult> screen(List<MultipartFile> resumes, String jobDescription);
}
