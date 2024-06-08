package com.artursantos00000847859.Curriculum.Repository.Java.service;

import com.artursantos00000847859.Curriculum.Repository.Java.DTO.*;
import com.artursantos00000847859.Curriculum.Repository.Java.model.Course;
import com.artursantos00000847859.Curriculum.Repository.Java.model.User;
import com.artursantos00000847859.Curriculum.Repository.Java.repository.CourseRepository;
import com.artursantos00000847859.Curriculum.Repository.Java.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    UserRepository userRepository;

    public String cadastrarCourse(CourseDTO courseDTO){
        Course course = new Course();
        course.setLocal(courseDTO.local());
        course.setData_de_conclusao(courseDTO.data_de_conclusao());
        course.setNome(courseDTO.nome());
        course.setUser(userRepository.getReferenceById(courseDTO.user_id()));
        courseRepository.save(course);
        return "Created";
    }

    public String deletarCourse(UUID id){
        courseRepository.deleteById(id);;
        return "Deleted";
    }

    public String atualizarCourse(AtualizacaoCourseDTO atualizacaoCourseDTO){
        Course course = courseRepository.getReferenceById(atualizacaoCourseDTO.id());
        if(atualizacaoCourseDTO.nome()!=null) course.setNome(atualizacaoCourseDTO.nome());
        if(atualizacaoCourseDTO.data_de_conclusao()!=null) course.setData_de_conclusao(atualizacaoCourseDTO.data_de_conclusao());
        if(atualizacaoCourseDTO.local()!=null) course.setLocal(atualizacaoCourseDTO.local());

        return "Atualizado";
    }
    public Page<ListagemCourseDTO> listarCourse(Pageable paginacao){
        return courseRepository.findAll(paginacao).map(ListagemCourseDTO::new);

    }
}