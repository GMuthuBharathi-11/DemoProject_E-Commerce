package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.UserService;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService
{
    public Optional<User> findUserByEmail(String email);
    public Optional<User> findUserByResetToken(String resetToken);
    public void save(User user);
}
