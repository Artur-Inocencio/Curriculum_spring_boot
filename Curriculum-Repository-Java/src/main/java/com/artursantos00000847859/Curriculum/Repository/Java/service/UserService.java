package com.artursantos00000847859.Curriculum.Repository.Java.service;

import com.artursantos00000847859.Curriculum.Repository.Java.DTO.AtualizacaoUserDTO;
import com.artursantos00000847859.Curriculum.Repository.Java.DTO.ListagemUserDTO;
import com.artursantos00000847859.Curriculum.Repository.Java.model.User;
import com.artursantos00000847859.Curriculum.Repository.Java.DTO.UserDTO;

import com.artursantos00000847859.Curriculum.Repository.Java.repository.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String cadastrarUser(UserDTO userDTO){
        User user = new User(userDTO);
        userRepository.save(user);
        return "Created";
    }

    public String deletarUser(UUID id){
        userRepository.deleteById(id);;
        return "Deleted";
    }

    public String atualizarUser(AtualizacaoUserDTO atualizacaoUserDTO){
        User user = userRepository.getReferenceById(atualizacaoUserDTO.id());
        if(atualizacaoUserDTO.nome()!=null) user.setNome(atualizacaoUserDTO.nome());
        if(atualizacaoUserDTO.data_nascimento()!=null) user.setData_nascimento(atualizacaoUserDTO.data_nascimento());
        if(atualizacaoUserDTO.idade()!=0) user.setIdade(atualizacaoUserDTO.idade());

        return "Atualizado";
    }
    public Page<ListagemUserDTO> listarUser(Pageable paginacao){
        return userRepository.findAll(paginacao).map(ListagemUserDTO::new);

    }
}