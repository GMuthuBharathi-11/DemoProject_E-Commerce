package com.DemoProjectECommerce.ECommerce.repositories.refreshtokenrepository;

import com.DemoProjectECommerce.ECommerce.entity.entitybasic.User;
import com.DemoProjectECommerce.ECommerce.entity.entitybasic.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshTokenRepository> findByToken(String token);
    void deleteByToken(String token);
    Optional<RefreshToken> findByUser(User user);
}
