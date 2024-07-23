package com.rungroop.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rungroop.web.models.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String userName);
    UserEntity findFirstByUsername(String userName);
}
