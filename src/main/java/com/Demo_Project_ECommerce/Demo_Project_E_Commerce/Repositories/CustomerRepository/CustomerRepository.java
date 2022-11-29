package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.CustomerRepository;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain.Customer;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    Optional<Customer> findByUser(User user);

}
