package com.DemoProjectECommerce.ECommerce.services.applicationUserservice;

import com.DemoProjectECommerce.ECommerce.repositories.userrepository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class ApplicationUserService {
    private final UserRepository  userRepository;
    private final PasswordEncoder passwordEncoder;

    public ApplicationUserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository  = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

}
