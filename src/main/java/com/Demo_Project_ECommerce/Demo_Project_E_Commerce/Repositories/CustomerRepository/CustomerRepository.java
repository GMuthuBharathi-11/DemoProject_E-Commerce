package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.CustomerRepository;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
@Transactional(readOnly = true)
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long>{

//    public Customer findByEmail(String email);
//
//    public Customer findByResetPasswordToken(String token);

}
