package com.artursantos00000847859.Curriculum.Repository.Java.repository;

import com.artursantos00000847859.Curriculum.Repository.Java.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
