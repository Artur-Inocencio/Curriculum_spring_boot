package com.artursantos00000847859.Curriculum.Repository.Java.DTO;

import com.artursantos00000847859.Curriculum.Repository.Java.model.Course;

import java.util.Date;
import java.util.UUID;

public record ListagemCourseDTO(
        UUID id,
        String nome,
        Date data_de_conclusao,
        String local,
        UUID user_id
) {
    public ListagemCourseDTO(Course course){

        this( course.getId(),course.getNome(), course.getData_de_conclusao(),course.getLocal(),course.getUser().getId());
    }
}