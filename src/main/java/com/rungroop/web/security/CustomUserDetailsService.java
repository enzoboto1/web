package com.rungroop.web.security;

import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rungroop.web.models.UserEntity;
import com.rungroop.web.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findFirstByUsername(username);
        if (userEntity != null) {
            return User.builder()
                    .username(userEntity.getUsername())
                    .password(userEntity.getPassword()) // Aqui você deve retornar a senha criptografada
                    .authorities(userEntity.getRoles().stream()
                            .map(role -> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toList()))
                    .build();
        } else {
            throw new UsernameNotFoundException("Usuário não encontrado com o nome: " + username);
        }
    }
}
