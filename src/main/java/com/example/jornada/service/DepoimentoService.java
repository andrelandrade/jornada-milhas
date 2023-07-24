package com.example.jornada.service;

import com.example.jornada.dto.DepoimentoDTO;
import com.example.jornada.entity.Depoimento;
import com.example.jornada.repository.DepoimentoRepository;
import com.example.jornada.service.storage.FileSystemStorageService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepoimentoService {

    @Autowired
    FileSystemStorageService fileStorageService;
    @Autowired
    DepoimentoRepository repository;

    @Transactional
    public Long cadastrar(DepoimentoDTO depoimentoDto) {
        Depoimento depoimento = new Depoimento(depoimentoDto);

        repository.save(depoimento);

        var filePath = fileStorageService.uploadFile(depoimentoDto.foto(), depoimento.getId().toString());

        depoimento.setFoto(filePath);

        return depoimento.getId();
    }
}
