package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.ApplicationUserService;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.UserRepository.User_Repository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Application_User_Service
{
    private final User_Repository user_repository;
    private final PasswordEncoder passwordEncoder;

}
