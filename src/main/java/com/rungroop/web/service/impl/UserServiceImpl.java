package com.rungroop.web.service.impl;

import java.util.Arrays;

import com.rungroop.web.dto.RegistrationDto;
import com.rungroop.web.models.UserEntity;
import com.rungroop.web.repository.RoleRepository;
import com.rungroop.web.repository.UserRepository;
import com.rungroop.web.service.UserService;

public class UserServiceImpl implements UserService {

    private RoleRepository roleRepository;
    private UserRepository userRepository;

    public UserServiceImpl(RoleRepository roleRepository, UserRepository userRepository){
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(registrationDto.getId());
        userEntity.setUsername(registrationDto.getUsername());
        userEntity.setEmail(registrationDto.getEmail());
        userEntity.setPassword(registrationDto.getPassword());
        userEntity.setRoles(Arrays.asList(roleRepository.findByName("USER")));
        userRepository.save(userEntity);
    }
    
}
