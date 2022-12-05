package com.DemoProjectECommerce.ECommerce.repositories.rolerepository;

import com.DemoProjectECommerce.ECommerce.entity.ERole;
import com.DemoProjectECommerce.ECommerce.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByroleName(ERole e_role);


}
