package com.artursantos00000847859.Curriculum.Repository.Java.DTO;

import com.artursantos00000847859.Curriculum.Repository.Java.model.Course;
import com.artursantos00000847859.Curriculum.Repository.Java.model.User;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record ListagemUserDTO(
        UUID id,
        String nome,
        Date data_nascimento,
        int idade
) {
    public ListagemUserDTO(User user){

        this( user.getId(),user.getNome(), user.getData_nascimento(),user.getIdade());
    }
}