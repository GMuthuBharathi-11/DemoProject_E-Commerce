package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.AdminRepository;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Admin_Repository extends JpaRepository<Admin,Integer>
{
}
