package com.example.jornada.controller;

import com.example.jornada.dto.DepoimentoDTO;
import com.example.jornada.service.DepoimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("depoimentos")
public class DepoimentoController {

    @Autowired
    DepoimentoService service;
    @PostMapping
    public void cadastrar(@ModelAttribute DepoimentoDTO depoimentoDto) {
        service.cadastrar(depoimentoDto);
    }
}
