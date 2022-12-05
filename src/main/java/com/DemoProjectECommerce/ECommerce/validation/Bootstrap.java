package com.DemoProjectECommerce.ECommerce.validation;

import com.DemoProjectECommerce.ECommerce.entity.*;
import com.DemoProjectECommerce.ECommerce.repositories.adminrepository.AdminRepository;
import com.DemoProjectECommerce.ECommerce.repositories.rolerepository.RoleRepository;
import com.DemoProjectECommerce.ECommerce.repositories.userrepository.UserRepository;
import com.DemoProjectECommerce.ECommerce.services.roleservice.RoleService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@Component
public class Bootstrap implements ApplicationRunner
{
    @Autowired
    private RoleRepository repository;
    @Autowired
    private UserRepository  userRepository;
    @Autowired
    private  BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private final RoleService roleService;
    @Autowired
    private final AdminRepository adminRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (userRepository.count() < 1)
        {
            Role role = roleService.getOrCreateRole(ERole.ROLE_ADMIN);
            Address address = Address.builder()
                                     .city("Bangalore")
                                     .state("Karnataka")
                                     .zipCode(String.valueOf(110032L))
                                     .country("India")
                                     .addressLine("198 7th BSK ")
                                     .label("Office")
                                     .build();
            User user = User.builder()
                            .firstName("Muthu")
                            .middleName(" ")
                            .lastName("Bharathi")
                            .email("muthubharathi.g@tothenew.com")
                            .password(bCryptPasswordEncoder.encode("Admin@45"))
                            .passwordcreatedAt(LocalDateTime.now())
                            .isExpired(Boolean.FALSE)
                            .isDeleted(Boolean.FALSE)
                            .isLocked(Boolean.FALSE)
                            .isActive(Boolean.FALSE)
                            .addressSet(Set.of(address))
                            .roles(Set.of(role))
                            .build();
            Admin admin = Admin.builder()
                               .phoneNumber("+91-9739807964")
                               .user(user)
                               .build();
            adminRepository.save(admin);
            String token = UUID.randomUUID().toString();
        }
    }
}
