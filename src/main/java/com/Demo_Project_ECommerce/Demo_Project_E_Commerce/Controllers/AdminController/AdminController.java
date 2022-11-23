package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Controllers.AdminController;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.Customer;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.Seller;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.CustomerRepository.Customer_Repository;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.SellerRepository.Seller_Repository;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.AdminService.AdminService;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.CustomerService.CustomerService;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.SellerService.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private Customer_Repository customerRepo;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private Seller_Repository seller_repository;

    @Autowired
    private SellerService sellerService;


    @GetMapping("/customers")
    public Page<Customer> findallcustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping("/sellers")
    public Page<Seller> findallseller() {
        return sellerService.findAllSellers();
    }

    @GetMapping("/customer/{Id}")
    public Customer findCustomerById(@PathVariable Long Id) {
        return customerService.findCustomer(Id);
    }

    @GetMapping("/seller/{Id}")
    public Seller findSellerById(@PathVariable Long Id) {
        return sellerService.findOne(Id);
    }
}
