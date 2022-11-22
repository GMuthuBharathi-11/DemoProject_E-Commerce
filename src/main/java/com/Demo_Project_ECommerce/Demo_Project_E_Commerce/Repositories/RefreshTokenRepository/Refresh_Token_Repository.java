package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.RefreshTokenRepository;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.Refresh_Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Refresh_Token_Repository extends JpaRepository<Refresh_Token,Long> {

    Optional<Refresh_Token_Repository> findByToken(String token);

    void deleteByToken(String token);
}
