package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Controllers.AdminController;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.Customer;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.Seller;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.CustomerRepository.CustomerRepository;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.SellerRepository.SellerRepository;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.AdminService.AdminService;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.CustomerService.CustomerService;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.SellerService.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")

public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private SellerService sellerService;


    @GetMapping("/customers")
    public Page<Customer> findallcustomers() {

        return customerService.findAllCustomers();
    }

    @GetMapping("/customer/{Id}")
    public Customer findCustomerById(@PathVariable Long Id) {
        return customerService.findCustomer(Id);
    }

    @PutMapping("/customer/{Id}/activated")
    public String activateCustomer(@PathVariable Long Id){return customerService.CustomerActivate(Id);}

    @PutMapping("/customer/{Id}/deactivated")
    public String deactivateCustomer(@PathVariable Long Id){return customerService.CustomerDeActivation(Id);}


    @GetMapping("/sellers")
    public Page<Seller> findallseller() {

        return sellerService.findAllSellers();
    }
    @GetMapping("/seller/{Id}")
    public Seller findSellerById(@PathVariable Long Id) {
        return sellerService.findOne(Id);
    }

    @PutMapping("/customer/{Id}/activated")
    public String activateSeller(@PathVariable Long Id){return sellerService.SellerActivate(Id);}

    @PutMapping("/customer/{Id}/deactivated")
    public String deactivateSeller(@PathVariable Long Id){return sellerService.SellerDeActivation(Id);}



}
