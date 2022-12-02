package com.DemoProjectECommerce.ECommerce.repositories.adminrepository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.DemoProjectECommerce.ECommerce.entity.entitybasic.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>
{

}
