package com.artursantos00000847859.Curriculum.Repository.Java.DTO;

import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public record AtualizacaoExperienceDTO(
        @NotNull
        UUID id,
        String funcao,
        String empresa,
        String tempo_de_experiencia,
        UUID user_id
) {
}

