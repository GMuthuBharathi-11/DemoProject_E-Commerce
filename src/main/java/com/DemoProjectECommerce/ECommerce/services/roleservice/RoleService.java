package com.DemoProjectECommerce.ECommerce.services.roleservice;

import com.DemoProjectECommerce.ECommerce.entity.ERole;
import com.DemoProjectECommerce.ECommerce.entity.Role;
import com.DemoProjectECommerce.ECommerce.repositories.rolerepository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private final RoleRepository role_repository;

    public RoleService(RoleRepository role_repository) {
        this.role_repository = role_repository;
    }

    public Role getOrCreateRole(ERole e_role) {
        return role_repository
                .findByroleName(e_role)
                .orElseGet(() -> role_repository.save(Role.builder()
                                                          .roleName(e_role)
                                                          .build()));
    }
}
