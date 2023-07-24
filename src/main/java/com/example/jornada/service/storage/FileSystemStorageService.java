package com.example.jornada.service.storage;

import com.example.jornada.service.storage.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;

@Service
public class FileSystemStorageService implements StorageService  {
    private String local = "src/main/resources/static/";
    @Override
    public String uploadFile(MultipartFile multipartFile, String dir) {
        if (multipartFile.getOriginalFilename() == null) {
            return "";
        }

        var newDirectoryPath = FileSystems.getDefault().getPath(local + dir);

        if (Files.notExists(newDirectoryPath)) {
            try {
                Files.createDirectories(newDirectoryPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        var destinationFilePath = newDirectoryPath.resolve(multipartFile.getOriginalFilename());

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Files.copy(inputStream, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return destinationFilePath.toString();

    }

    @Override
    public Object downloadFile(String filename) {
        return null;
    }

    @Override
    public boolean delete(String filename) {
        return false;
    }
}
