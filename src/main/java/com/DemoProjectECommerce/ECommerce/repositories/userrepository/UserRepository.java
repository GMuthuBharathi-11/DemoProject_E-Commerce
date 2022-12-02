package com.DemoProjectECommerce.ECommerce.repositories.userrepository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.DemoProjectECommerce.ECommerce.entity.entitybasic.User;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    Optional<User> findByEmail(String email);

}

