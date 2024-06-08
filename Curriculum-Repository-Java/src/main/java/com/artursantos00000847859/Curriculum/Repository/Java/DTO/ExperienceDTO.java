package com.artursantos00000847859.Curriculum.Repository.Java.DTO;

import java.util.Date;
import java.util.UUID;

public record ExperienceDTO(

        String funcao,
        String empresa,
        String tempo_de_experiencia,
        UUID user_id
) {
}
