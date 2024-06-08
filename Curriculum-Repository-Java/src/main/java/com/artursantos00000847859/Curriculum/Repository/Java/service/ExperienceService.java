package com.artursantos00000847859.Curriculum.Repository.Java.service;

import com.artursantos00000847859.Curriculum.Repository.Java.DTO.ExperienceDTO;
import com.artursantos00000847859.Curriculum.Repository.Java.DTO.AtualizacaoExperienceDTO;
import com.artursantos00000847859.Curriculum.Repository.Java.DTO.ListagemExperienceDTO;
import com.artursantos00000847859.Curriculum.Repository.Java.model.Experience;
import com.artursantos00000847859.Curriculum.Repository.Java.repository.ExperienceRepository;
import com.artursantos00000847859.Curriculum.Repository.Java.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExperienceService {

    @Autowired
    ExperienceRepository experienceRepository;
    @Autowired
    UserRepository userRepository;

    public String cadastrarExperience(ExperienceDTO experienceDTO){
        Experience experience = new Experience();
        experience.setEmpresa(experienceDTO.empresa());
        experience.setTempo_de_experiencia(experienceDTO.tempo_de_experiencia());
        experience.setFuncao(experienceDTO.funcao());
        experience.setUser(userRepository.getReferenceById(experienceDTO.user_id()));
        experienceRepository.save(experience);
        return "Created";
    }

    public String deletarExperience(UUID id){
        experienceRepository.deleteById(id);;
        return "Deleted";
    }

    public String atualizarExperience(AtualizacaoExperienceDTO atualizacaoExperienceDTO){
        Experience experience = experienceRepository.getReferenceById(atualizacaoExperienceDTO.id());
        if(atualizacaoExperienceDTO.empresa()!=null) experience.setEmpresa(atualizacaoExperienceDTO.empresa());
        if(atualizacaoExperienceDTO.tempo_de_experiencia()!=null) experience.setTempo_de_experiencia(atualizacaoExperienceDTO.tempo_de_experiencia());
        if(atualizacaoExperienceDTO.funcao()!=null) experience.setFuncao(atualizacaoExperienceDTO.funcao());

        return "Atualizado";
    }
    public Page<ListagemExperienceDTO> listarExperience(Pageable paginacao){
        return experienceRepository.findAll(paginacao).map(ListagemExperienceDTO::new);

    }
}