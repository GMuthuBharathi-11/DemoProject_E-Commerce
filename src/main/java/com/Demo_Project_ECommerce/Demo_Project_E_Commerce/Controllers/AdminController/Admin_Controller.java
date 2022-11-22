package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Controllers.AdminController;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.Customer;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.Seller;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.CustomerRepository.Customer_Repository;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.SellerRepository.Seller_Repository;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.AdminService.Admin_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class Admin_Controller {

        @Autowired
        private Admin_Service adminService;

        @Autowired
        private Customer_Repository customerRepo;

        @Autowired
        private Seller_Repository sellerRepo;

        @GetMapping("/customers")
        public Page<Customer> findallcustomers(){
            PageRequest    pageable = PageRequest.of(0, 10, Sort.Direction.ASC, "Id");
            Page<Customer> result   = customerRepo.findAll(pageable);
            return result;
        }

        @GetMapping("/sellers")
        public Page<Seller> findallseller(){
            PageRequest pageable = PageRequest.of(0, 10, Sort.Direction.ASC,"Id");
            Page<Seller> result= sellerRepo.findAll(pageable);
            return result;
        }
}
