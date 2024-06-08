package com.artursantos00000847859.Curriculum.Repository.Java.DTO;

import java.util.Date;

public record UserDTO(

        String nome,
        Date data_nascimento,
        int idade
) {
}
