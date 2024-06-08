package com.artursantos00000847859.Curriculum.Repository.Java.controller;


import com.artursantos00000847859.Curriculum.Repository.Java.DTO.AtualizacaoExperienceDTO;
import com.artursantos00000847859.Curriculum.Repository.Java.DTO.ExperienceDTO;
import com.artursantos00000847859.Curriculum.Repository.Java.DTO.ListagemExperienceDTO;
import com.artursantos00000847859.Curriculum.Repository.Java.service.ExperienceService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/experience")
@Validated
public class ExperienceController {



    @Autowired
    ExperienceService experienceService;
    @GetMapping()
    public Page<ListagemExperienceDTO> listarExperiences(Pageable paginacao){
        return experienceService.listarExperience(paginacao);
    }



    @PostMapping
    @Transactional
    public String cadastrarExperience(@RequestBody ExperienceDTO experienceDTO){

        //return "Created";
        return experienceService.cadastrarExperience(experienceDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public String deletarExperience(@PathVariable @NotNull UUID id){
        return experienceService.deletarExperience(id);
    }

    @PutMapping
    @Transactional
    public String atualizarExperience(@RequestBody AtualizacaoExperienceDTO atualizacaoExperienceDTO){
        return experienceService.atualizarExperience(atualizacaoExperienceDTO);
    }
}
