package com.artursantos00000847859.Curriculum.Repository.Java.model;

import com.artursantos00000847859.Curriculum.Repository.Java.DTO.CourseDTO;
import com.artursantos00000847859.Curriculum.Repository.Java.DTO.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "courses")//nome da tabela
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;
    private Date data_de_conclusao;
    private String local;

    @ManyToOne
    private User user;

    public Course(CourseDTO courseDTO){
        this.nome = courseDTO.nome();
        this.data_de_conclusao = courseDTO.data_de_conclusao();
        this.local = courseDTO.local();

    }

}
