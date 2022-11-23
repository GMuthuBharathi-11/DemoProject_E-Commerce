package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.ApplicationUserService;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.UserRepository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ApplicationUserService
{
    private final UserRepository  user_repository;
    private final PasswordEncoder passwordEncoder;

}
