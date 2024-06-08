package com.artursantos00000847859.Curriculum.Repository.Java.model;

import com.artursantos00000847859.Curriculum.Repository.Java.DTO.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    private Date data_nascimento;

    private int idade;

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Course> courses;

    public User(UserDTO userDTO){
        this.nome = userDTO.nome();
        this.data_nascimento = userDTO.data_nascimento();
        this.idade = userDTO.idade();

    }

}