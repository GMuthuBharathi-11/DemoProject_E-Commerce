package com.DemoProjectECommerce.ECommerce.services.refreshtokenservice;


import com.DemoProjectECommerce.ECommerce.repositories.refreshtokenrepository.RefreshTokenRepository;
import com.DemoProjectECommerce.ECommerce.customizehandling.ECommerceApplicationException;
import com.DemoProjectECommerce.ECommerce.repositories.userrepository.UserRepository;
import com.DemoProjectECommerce.ECommerce.entity.RefreshToken;
import com.DemoProjectECommerce.ECommerce.entity.User;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;


@Transactional
@Service
public class RefreshTokenService
{
    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository  userRepository;
    public RefreshTokenService(RefreshTokenRepository refreshTokenRepository,UserRepository userRepository) {
        this.refreshTokenRepository= refreshTokenRepository;
        this.userRepository = userRepository;
    }

    public RefreshToken generateRefreshToken(String userEmail) {
        User         user         = userRepository.findByEmail(userEmail).orElseThrow(() -> new ECommerceApplicationException("No user found"));
        RefreshToken refreshToken = refreshTokenRepository.findByUser(user).orElse(null);
        if (refreshToken == null) {
            RefreshToken newRefreshToken = new RefreshToken();
            newRefreshToken.setToken(UUID.randomUUID().toString());
            newRefreshToken.setCreatedAt(Instant.now());
            newRefreshToken.setUser(user);
            newRefreshToken.setExpiresAt(LocalDateTime.now().plusMinutes(30));
            return refreshTokenRepository.save(newRefreshToken);
        }
        else {
            refreshToken.setToken(UUID.randomUUID().toString());
            refreshToken.setExpiresAt(LocalDateTime.now().plusMinutes(30));
            return refreshTokenRepository.save(refreshToken);
        }
    }
    public void validateRefreshToken(String token) {
        refreshTokenRepository.findByToken(token)
                        .orElseThrow(() -> new RuntimeException("Invalid refresh Token"));
    }

    public void deleteRefreshToken(String token) {
        refreshTokenRepository.deleteByToken(token);
    }
}
