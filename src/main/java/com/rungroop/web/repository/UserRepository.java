package com.rungroop.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rungroop.web.dto.RegistrationDto;
import com.rungroop.web.models.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    public RegistrationDto findByUsername(String username);
    public RegistrationDto findByEmail(String email);
}
