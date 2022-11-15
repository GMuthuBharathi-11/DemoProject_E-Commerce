package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.CustomerService;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.User;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.AddressRepository.Address_Repository;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.CustomerRepository.Customer_Repository;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.RoleRepository.Role_Repository;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.UserRepository.User_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class Customer_Service<CustomerDetails> {
     @Autowired
     Customer_Repository customer_repository;

     @Autowired
     Role_Repository role_repository;

     @Autowired
     User_Repository user_repository;

     @Autowired
     Address_Repository address_repository;


     public void Createcustomer(CustomerDetails customerDetails)
     {
          User user = new User();
          List<User> userList = new ArrayList<>();
          userList.add(user);
     }


}

