package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.RoleService;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.E_Role;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.Role;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.RoleRepository.Role_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Role_Service
{
    @Autowired
    private final Role_Repository role_repository;

    public Role_Service(Role_Repository role_repository) {
        this.role_repository= role_repository;
    }

    public  Role getOrCreateRole(E_Role e_role){
        return role_repository.findByName(e_role)
                              .orElseGet(()->role_repository.
                                      save(Role.builder((e_role.build());

    }
}
