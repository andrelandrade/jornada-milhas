package com.example.jornada.entity;

import com.example.jornada.dto.DepoimentoDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "depoimentos")
@Getter
@Setter
public class Depoimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comentario;
    private String autor;
    private String foto;

    public Depoimento(DepoimentoDTO dto) {
        this.comentario = dto.comentario();
        this.autor = dto.autor();
        this.foto = dto.foto().getOriginalFilename();
    }

}
