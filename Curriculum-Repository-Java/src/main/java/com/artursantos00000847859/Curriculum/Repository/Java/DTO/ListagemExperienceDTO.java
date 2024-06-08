package com.artursantos00000847859.Curriculum.Repository.Java.DTO;

import com.artursantos00000847859.Curriculum.Repository.Java.model.Experience;

import java.util.Date;
import java.util.UUID;

public record ListagemExperienceDTO(
        UUID id,
        String funcao,
        String empresa,
        String tempo_de_experiencia,
        UUID user_id

) {
    public ListagemExperienceDTO(Experience experience){

        this( experience.getId(),experience.getFuncao(), experience.getEmpresa(),experience.getTempo_de_experiencia(),experience.getUser().getId());
    }
}