package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.RoleService;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain.E_Role;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain.Role;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.RoleRepository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private final RoleRepository role_repository;

    public RoleService(RoleRepository role_repository) {
        this.role_repository = role_repository;
    }

    public Role getOrCreateRole(E_Role e_role) {
        return role_repository
                .findByRoleName(e_role)
                .orElseGet(() -> role_repository.save(Role.builder()
                                                          .roleName(e_role)
                                                          .build()));
    }
}
