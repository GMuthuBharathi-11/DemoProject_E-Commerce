package com.DemoProjectECommerce.ECommerce.repositories.adminrepository;

import com.DemoProjectECommerce.ECommerce.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>
{

}
