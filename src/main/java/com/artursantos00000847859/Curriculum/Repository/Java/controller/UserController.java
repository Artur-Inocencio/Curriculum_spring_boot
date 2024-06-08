package com.artursantos00000847859.Curriculum.Repository.Java.controller;


import com.artursantos00000847859.Curriculum.Repository.Java.DTO.AtualizacaoUserDTO;
import com.artursantos00000847859.Curriculum.Repository.Java.DTO.ListagemUserDTO;
import com.artursantos00000847859.Curriculum.Repository.Java.DTO.UserDTO;
import com.artursantos00000847859.Curriculum.Repository.Java.model.User;
import com.artursantos00000847859.Curriculum.Repository.Java.service.UserService;


import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {



    @Autowired
    UserService userService;
    @GetMapping()
    public Page<ListagemUserDTO> listarUsers(Pageable paginacao){
        return userService.listarUser(paginacao);
    }



    @PostMapping
    @Transactional
    public String cadastrarUser(@RequestBody UserDTO userDTO){

        //return "Created";
        return userService.cadastrarUser(userDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public String deletarUser(@PathVariable @NotNull UUID id){
        return userService.deletarUser(id);
    }

    @PutMapping
    @Transactional
    public String atualizarUser(@RequestBody AtualizacaoUserDTO atualizacaoUserDTO){
        return userService.atualizarUser(atualizacaoUserDTO);
    }
}
