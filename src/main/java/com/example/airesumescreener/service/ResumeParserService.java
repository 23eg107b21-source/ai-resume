package com.example.airesumescreener.service;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

public interface ResumeParserService {
    String extractText(MultipartFile file) throws IOException;
}
