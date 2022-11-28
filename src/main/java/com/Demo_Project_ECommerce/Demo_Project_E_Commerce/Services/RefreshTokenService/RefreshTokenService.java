package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.RefreshTokenService;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain.RefreshToken;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.RefreshTokenRepository.RefreshTokenRepository;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.UserRepository.UserRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.Instant;
import java.util.UUID;


@Transactional
@Service
public class RefreshTokenService
{
    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;
    public RefreshTokenService(RefreshTokenRepository refresh_token_repository,UserRepository userRepository) {
        this.refreshTokenRepository= refresh_token_repository;
        this.userRepository = userRepository;
    }

    public RefreshToken generateRefreshToken() {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(UUID.randomUUID().toString());
//        refreshToken.setCreatedDate(Instant.now());

        return refreshTokenRepository.save(refreshToken);
    }

    public void validateRefreshToken(String token) {
        refreshTokenRepository.findByToken(token)
                        .orElseThrow(() -> new RuntimeException("Invalid refresh Token"));
    }

    public void deleteRefreshToken(String token) {
        refreshTokenRepository.deleteByToken(token);
    }
}
