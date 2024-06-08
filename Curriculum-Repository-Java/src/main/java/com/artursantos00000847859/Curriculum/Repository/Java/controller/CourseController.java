package com.artursantos00000847859.Curriculum.Repository.Java.controller;


import com.artursantos00000847859.Curriculum.Repository.Java.DTO.AtualizacaoCourseDTO;
import com.artursantos00000847859.Curriculum.Repository.Java.DTO.CourseDTO;
import com.artursantos00000847859.Curriculum.Repository.Java.DTO.ListagemCourseDTO;
import com.artursantos00000847859.Curriculum.Repository.Java.service.CourseService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/course")
@Validated
public class CourseController {



    @Autowired
    CourseService courseService;
    @GetMapping()
    public Page<ListagemCourseDTO> listarCourses(Pageable paginacao){
        return courseService.listarCourse(paginacao);
    }



    @PostMapping
    @Transactional
    public String cadastrarCourse(@RequestBody CourseDTO courseDTO){

        //return "Created";
        return courseService.cadastrarCourse(courseDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public String deletarCourse(@PathVariable @NotNull UUID id){
        return courseService.deletarCourse(id);
    }

    @PutMapping
    @Transactional
    public String atualizarCourse(@RequestBody AtualizacaoCourseDTO atualizacaoCourseDTO){
        return courseService.atualizarCourse(atualizacaoCourseDTO);
    }
}
