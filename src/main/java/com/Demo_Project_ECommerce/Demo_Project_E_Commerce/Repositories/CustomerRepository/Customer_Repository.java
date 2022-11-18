package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.CustomerRepository;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Customer_Repository extends JpaRepository<Customer,Integer>
{
//    @Query("SELECT c FROM Customer c WHERE c.email = ?1")
    public Customer findByEmail(String email);

    public Customer findByResetPasswordToken(String token);
}
