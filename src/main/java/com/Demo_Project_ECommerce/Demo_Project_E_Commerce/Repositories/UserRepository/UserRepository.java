package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.UserRepository;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}

