package com.DemoProjectECommerce.ECommerce.controllers.admincontroller;
import com.DemoProjectECommerce.ECommerce.repositories.customerrepository.CustomerRepository;
import com.DemoProjectECommerce.ECommerce.repositories.sellerrepository.SellerRepository;
import com.DemoProjectECommerce.ECommerce.services.customerservice.CustomerService;
import com.DemoProjectECommerce.ECommerce.services.sellerservice.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import com.DemoProjectECommerce.ECommerce.entity.entitybasic.Customer;
import com.DemoProjectECommerce.ECommerce.entity.entitybasic.Seller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/admin")
public class AdminController
{
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private SellerService sellerService;

    @GetMapping("/customers")
    public List<Customer> findallcustomers() {
        return customerService.findAllCustomers();
    }
    @GetMapping("/customer/{Id}")
    public Customer findCustomerById(@PathVariable Long Id) {
        return customerService.findCustomer(Id);
    }
    @PutMapping("/customer/{Id}/activated")
    public String activateCustomer(@PathVariable Long Id){
        return customerService.CustomerActivate(Id);
    }
    @PutMapping("/customer/{Id}/deactivated")
    public String deactivateCustomer(@PathVariable Long Id){
        return customerService.CustomerDeActivation(Id);
    }
    @GetMapping("/sellers")
    public List<Seller> findAllSeller() {
        return sellerService.findAllSellers();
    }
    @GetMapping("/seller/{Id}")
    public Seller findSellerById(@PathVariable Long Id) {
        return sellerService.findOne(Id);
    }
    @PutMapping("/seller/{Id}/activated")
    public String activateSeller(@PathVariable Long Id){
        return sellerService.SellerActivate(Id);
    }
    @PutMapping("/seller/{Id}/deactivated")
    public String deactivateSeller(@PathVariable Long Id) {
        return sellerService.SellerDeActivate(Id);
    }
}




