package com.example.jornada.dto;

import org.springframework.web.multipart.MultipartFile;

public record DepoimentoDTO(
        String comentario,
        String autor,
        MultipartFile foto
) {
}
