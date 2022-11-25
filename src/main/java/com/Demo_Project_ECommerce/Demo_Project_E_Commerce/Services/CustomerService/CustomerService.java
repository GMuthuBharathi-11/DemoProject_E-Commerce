package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.CustomerService;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.CustomizeErrorHandling.ECommerceApplicationException;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Email.EmailSenderService.EmailSenderService;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.Customer;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmailSenderService emailSenderService;


    public Customer findCustomer(Long Id) {
        Customer customer = customerRepository.findById(Id)
                                              .orElseThrow(() -> new ECommerceApplicationException("No user found "
                                                                                                   + "with id : " + Id));
        return customer;
    }

    public Page<Customer> findAllCustomers() {
        PageRequest    pageable = PageRequest.of(0, 10, Sort.Direction.ASC, "Id");
        Page<Customer> result   = customerRepository.findAll(pageable);
        return result;
    }

    public String CustomerActivate(Long Id) {
        Customer customer = customerRepository.findById(Id)
                                              .orElseThrow(() -> new ECommerceApplicationException("No user found "
                                                                                                   + "with id : " + Id));
        if (customer.getUser().getIsActive().equals(Boolean.TRUE)) {
            customer.getUser().setIsActive(Boolean.FALSE);
            customerRepository.save(customer);

            emailSenderService.sendMail(
                    customer.getUser().getEmail(),
                    "Account is Activated",
                    "Account has been activated"
                                       );

            return "Customer is Activated";

        }
        else {
            return "Already account Activated";
        }
    }

    public String CustomerDeActivation(Long Id) {
        {
            Customer customer = customerRepository.findById(Id)
                                                  .orElseThrow(() -> new ECommerceApplicationException("No user found"
                                                                                                       + " with id : "
                                                                                                       + Id));
            if (customer.getUser().getIsActive().equals(Boolean.TRUE)) {
                customer.getUser().setIsActive(Boolean.FALSE);
                customerRepository.save(customer);

                emailSenderService.sendMail(
                        customer.getUser().getEmail(),
                        "Account is Deactivated",
                        "Account has been Deactivated"
                                           );


            }
            return "Customer is Deactivated";
        }


    }

//    public void updateResetPassword(String token, String email) {
//        Customer customer = customerRepository.findByEmail(email);
//        if (customer != null) {
//            customer.setResetPasswordToken(token);
//            customerRepository.save(customer);
//        }
//        else {
//            throw new ECommerceApplicationException("Customer Not Found" + email);
//        }
//    }
//    public Customer get(String resetPasswordToken)
//    {
//        return customerRepository.findByResetPasswordToken(resetPasswordToken);
//    }
//    public void updatePassword(Customer customer, String newPassword) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String                encodedPassword = passwordEncoder.encode(newPassword);
//        customer.setPassword(encodedPassword);
//
//        customer.setResetPasswordToken(null);
//        customerRepository.save(customer);
//    }

}



