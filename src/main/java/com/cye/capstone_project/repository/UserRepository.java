package com.cye.capstone_project.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cye.capstone_project.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

