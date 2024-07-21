package com.rungroop.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rungroop.web.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
