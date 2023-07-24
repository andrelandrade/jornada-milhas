package com.example.jornada.service.storage;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StorageService {
    String uploadFile(MultipartFile multipartFile, String dir);
    Object downloadFile(String filename);
    boolean delete(String filename);
}
