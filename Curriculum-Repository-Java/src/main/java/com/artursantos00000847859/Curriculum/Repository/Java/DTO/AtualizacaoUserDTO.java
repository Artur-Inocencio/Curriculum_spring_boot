package com.artursantos00000847859.Curriculum.Repository.Java.DTO;

import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public record AtualizacaoUserDTO(
        @NotNull
        UUID id,
        String nome,
        Date data_nascimento,
        int idade
) {
}