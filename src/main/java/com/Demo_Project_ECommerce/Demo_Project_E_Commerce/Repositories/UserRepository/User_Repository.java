package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.UserRepository;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface User_Repository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByUsernameOrEmail(String username, String email);
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}

