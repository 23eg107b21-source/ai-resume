package com.example.airesumescreener.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
@Slf4j
public class ResumeParserServiceImpl implements ResumeParserService {

    @Override
    public String extractText(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        if (fileName == null) {
            throw new IllegalArgumentException("File name is missing");
        }

        String lowerCaseFileName = fileName.toLowerCase();
        if (lowerCaseFileName.endsWith(".pdf")) {
            return extractTextFromPdf(file);
        } else if (lowerCaseFileName.endsWith(".docx")) {
            return extractTextFromDocx(file);
        } else {
            throw new IllegalArgumentException("Unsupported file format. Please upload PDF or DOCX format.");
        }
    }

    private String extractTextFromPdf(MultipartFile file) throws IOException {
        log.info("Extracting text from PDF: {}", file.getOriginalFilename());
        try (PDDocument document = Loader.loadPDF(file.getBytes())) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        }
    }

    private String extractTextFromDocx(MultipartFile file) throws IOException {
        log.info("Extracting text from DOCX: {}", file.getOriginalFilename());
        try (InputStream inputStream = file.getInputStream();
             XWPFDocument document = new XWPFDocument(inputStream);
             XWPFWordExtractor extractor = new XWPFWordExtractor(document)) {
            return extractor.getText();
        }
    }
}
