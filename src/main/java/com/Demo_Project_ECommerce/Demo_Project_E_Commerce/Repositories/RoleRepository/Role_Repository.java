package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.RoleRepository;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.E_Role;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;
import java.util.Optional;

public interface Role_Repository extends JpaRepository<Role,Integer> {
    Optional<Role> findById(E_Role e_role);
}
