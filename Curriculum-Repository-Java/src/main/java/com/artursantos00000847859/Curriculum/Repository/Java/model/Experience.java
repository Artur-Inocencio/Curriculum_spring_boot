package com.artursantos00000847859.Curriculum.Repository.Java.model;

import com.artursantos00000847859.Curriculum.Repository.Java.DTO.ExperienceDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "experiences")//nome da tabela
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String empresa;
    private String tempo_de_experiencia;
    private String funcao;

    @ManyToOne
    private User user;

    public Experience(ExperienceDTO experienceDTO){
        this.empresa = experienceDTO.empresa();
        this.tempo_de_experiencia = experienceDTO.tempo_de_experiencia();
        this.funcao = experienceDTO.funcao();

    }

}
