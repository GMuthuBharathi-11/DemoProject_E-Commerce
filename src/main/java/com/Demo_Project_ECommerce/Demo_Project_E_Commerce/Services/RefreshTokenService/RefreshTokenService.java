package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.RefreshTokenService;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.Refresh_Token;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.RefreshTokenRepository.Refresh_Token_Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.UUID;


@Transactional
@Service
public class RefreshTokenService
{
    private final Refresh_Token_Repository refresh_token_repository;

    public RefreshTokenService(Refresh_Token_Repository refresh_token_repository) {
        this.refresh_token_repository= refresh_token_repository;
    }

    public Refresh_Token generateRefreshToken() {
        Refresh_Token refreshToken = new Refresh_Token();
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setCreatedDate(Instant.now());

        return refresh_token_repository.save(refreshToken);
    }

    public void validateRefreshToken(String token) {
        refresh_token_repository.findByToken(token)
                        .orElseThrow(() -> new RuntimeException("Invalid refresh Token"));
    }

    public void deleteRefreshToken(String token) {
        refresh_token_repository.deleteByToken(token);
    }
}
