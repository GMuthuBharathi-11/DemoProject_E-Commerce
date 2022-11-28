package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.RefreshTokenRepository;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain.RefreshToken;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshTokenRepository> findByToken(String token);
    void deleteByToken(String token);
    Optional<RefreshToken> findByUser(User user);
}
