package com.rungroop.web.service;

import com.rungroop.web.dto.RegistrationDto;
import com.rungroop.web.models.UserEntity;

public interface UserService {
    public void saveUser(RegistrationDto RegistrationDto);
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);
}
