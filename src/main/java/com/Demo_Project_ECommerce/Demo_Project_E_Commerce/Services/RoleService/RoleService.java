package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.RoleService;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.E_Role;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.Role;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.RoleRepository.Role_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService
{
    @Autowired
    private final Role_Repository role_repository;

    public RoleService(Role_Repository role_repository) {
        this.role_repository= role_repository;
    }
     public Role getOrCreateRole(E_Role e_role)
     {
         return role_repository
                 .findByRoleName(e_role)
                 .orElseGet(()-> role_repository.save(Role.builder()
                                                              .roleName(e_role)
                                                              .build()));
     }
}
