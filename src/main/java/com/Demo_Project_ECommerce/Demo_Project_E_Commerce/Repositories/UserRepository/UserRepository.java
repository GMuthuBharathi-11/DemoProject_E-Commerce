package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.UserRepository;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
//    Optional<User> findByResetToken(String token);
    Optional<User> findByEmail(String email);
//    Optional<User> findByVerificationToken(String token);
}

