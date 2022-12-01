package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.AdminRepository;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>
{
}
