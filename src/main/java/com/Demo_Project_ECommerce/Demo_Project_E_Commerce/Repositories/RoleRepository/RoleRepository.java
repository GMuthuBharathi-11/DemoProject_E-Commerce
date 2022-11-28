package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.RoleRepository;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain.E_Role;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByRoleName(E_Role e_role);


}
