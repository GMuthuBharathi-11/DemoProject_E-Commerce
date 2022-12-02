package com.DemoProjectECommerce.ECommerce.controllers.customercontroller;

import com.DemoProjectECommerce.ECommerce.model.customerdto.AddressUpdateDto;
import com.DemoProjectECommerce.ECommerce.entity.entitybasic.Address;
import com.DemoProjectECommerce.ECommerce.entity.entitybasic.Customer;
import com.DemoProjectECommerce.ECommerce.model.customerdto.AddaddressDto;
import com.DemoProjectECommerce.ECommerce.model.userdto.UserProfileDto;
import com.DemoProjectECommerce.ECommerce.services.customerservice.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/get-profile")
    public ResponseEntity<Customer> CustomerInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(customerService.getCustomerProfile(authentication.getName()));
    }

    @GetMapping("/get-addresses")
    public Set<Address> CustomerAddressesInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return customerService.getCustomerAddress(authentication.getName());
    }

    @PutMapping("/update-profile")
    public String CustomerUpdateProfile(@Valid @RequestBody UserProfileDto userProfileDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        customerService.UpdateMyprofile(authentication.getName(), userProfileDto);
        return "Profile Updated Successfully";
    }

    @PostMapping("/address/add")
    public String addAddress(@Valid @RequestBody AddaddressDto addAddressDto) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return customerService.addAddress(authentication.getName(), addAddressDto);
    }

    @PutMapping("/addressUpdate/{Id}")
    public String UpdateAddress(@PathVariable Long Id, @Valid @RequestBody AddressUpdateDto addressUpdateDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return customerService.UpdateMyAddress(Id, authentication.getName(), addressUpdateDto);
    }

    @DeleteMapping("/addressDelete/{Id}")
    public String DeleteAddress(@PathVariable Long Id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return customerService.DeleteAddress(Id, authentication.getName());
    }
}
