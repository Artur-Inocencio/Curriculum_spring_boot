package com.artursantos00000847859.Curriculum.Repository.Java.DTO;

import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public record AtualizacaoCourseDTO(
        @NotNull
        UUID id,
        String nome,
        Date data_de_conclusao,
        String local,
        UUID user_id
) {
}

