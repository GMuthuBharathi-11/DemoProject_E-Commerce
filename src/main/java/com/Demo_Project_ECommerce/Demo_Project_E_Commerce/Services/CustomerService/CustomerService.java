package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.CustomerService;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.CustomizeErrorHandling.ApplicationException;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.Customer;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.CustomerRepository.Customer_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private Customer_Repository customerRepo;


    public Customer findCustomer(Long Id){
        return Customer_Repository.findById(Long.valueOf(Math.toIntExact(Id)))
                                  .orElseThrow(() -> new ApplicationException("No user found with id : " + Id));
    }

    public Page<Customer> findAllCustomers(){
        PageRequest    pageable = PageRequest.of(0, 10, Sort.Direction.ASC, "Id");
        Page<Customer> result   = customerRepo.findAll(pageable);
        return result;
    }
}


