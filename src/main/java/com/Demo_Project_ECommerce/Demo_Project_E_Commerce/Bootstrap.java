package com.Demo_Project_ECommerce.Demo_Project_E_Commerce;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.*;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.AdminRepository.Admin_Repository;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.RoleRepository.Role_Repository;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.UserRepository.UserRepository;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.RoleService.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;


@AllArgsConstructor
@Component
public class Bootstrap implements ApplicationRunner {

    @Autowired
    private Role_Repository       role_repository;
    @Autowired
    private UserRepository        userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private final RoleService roleService;

    @Autowired
    private final Admin_Repository admin_repository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (userRepository.count() < 1) {

            Role role = roleService.getOrCreateRole(E_Role.ROLE_ADMIN);


            Address address = Address.builder()
                                     .City("Bangalore")
                                     .State("Karnataka")
                                     .Zip_Code(String.valueOf(110032L))
                                     .Country("India")
                                     .addressLine("198 7th BSK ")
                                     .Label("Office")
                                     .build();


            User user = User.builder()
                            .firstName("Muthu")
                            .middleName(" ")
                            .lastName("Bharathi")
                            .email("muthubharathi.g@tothenew.com")
                            .password(bCryptPasswordEncoder.encode("Admin@45"))
                            .passwordUpdateDate(LocalDateTime.now())
                            .isExpired(Boolean.FALSE)
                            .isDeleted(Boolean.FALSE)
                            .isLocked(Boolean.FALSE)
                            .isActive(Boolean.FALSE)
                            .addressset(Set.of(address))
                            .roles(Set.of(role))
                            .build();


            Admin admin = Admin.builder()
                               .phoneNumber("+91-9739807964")
                               .user(user)
                               .build();
            admin_repository.save(admin);

            String token = UUID.randomUUID().toString();


        }
    }
}
