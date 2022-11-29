package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.RegistrationService;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model.CustomerRegistrationRequest;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model.SellerRegistrationRequest;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Email.EmailSenderService.EmailSenderService;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain.*;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.CustomerRepository.CustomerRepository;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.SellerRepository.SellerRepository;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.ApplicationUserService.ApplicationUserService;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.RoleService.RoleService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Service
public class RegistrationService {
    private final ApplicationUserService application_user_service;
    private final CustomerRepository customer_repository;
    private final RoleService  role_service;
    private final SellerRepository seller_repository;
    private final PasswordEncoder passwordEncoder;
    private final EmailSenderService emailSenderService;

    public RegistrationService(
            ApplicationUserService application_user_service,
            CustomerRepository customer_repository,
            RoleService role_service, SellerRepository seller_repository,
            PasswordEncoder passwordEncoder,
            EmailSenderService emailSenderService
                              ) {
        this.application_user_service = application_user_service;
        this.customer_repository      = customer_repository;
        this.role_service             = role_service;
        this.seller_repository        = seller_repository;
        this.passwordEncoder = passwordEncoder;
        this.emailSenderService       = emailSenderService;
    }
    public String registerCustomer(CustomerRegistrationRequest customerRegisterRequest) {

        Address address = Address.builder()
                                 .city(customerRegisterRequest.getCity())
                                 .state(customerRegisterRequest.getState())
                                 .country(customerRegisterRequest.getCountry())
                                 .addressLine(customerRegisterRequest.getAddressLine())
                                 .label(customerRegisterRequest.getLabel())
                                 .zipCode(customerRegisterRequest.getZipCode())
                                 .build();

        Role role = role_service.getOrCreateRole(E_Role.ROLE_CUSTOMER);

        User user = User.builder()
                        .firstName(customerRegisterRequest.getFirstName())
                        .lastName(customerRegisterRequest.getLastName())
                        .middleName(customerRegisterRequest.getMiddleName())
                        .email(customerRegisterRequest.getEmail())
                        .password(customerRegisterRequest.getPassword())
                        .isActive(Boolean.FALSE)
                        .isDeleted(Boolean.FALSE)
                        .isLocked(Boolean.FALSE)
                        .isExpired(Boolean.FALSE)
                        .AddressSet(Set.of(address))
                        .roles(Set.of(new Role()))
                        .build();

        Customer customer = Customer.builder()
                                    .phoneNumber(customerRegisterRequest.getContactNumber())
                                    .id(user.getId())
                                    .build();
        customer_repository.save(customer);

        String token = UUID.randomUUID().toString();
        emailSenderService.sendMail(
                customerRegisterRequest.getEmail(),
                "Activate Your Acoount",
                "Please activate your account"
                                   );

        return "Cutomer Registered Successfully"+ " Please check your email to activate your profile";

    }
    public String registerSeller(SellerRegistrationRequest sellerRegisterRequest) {

        Address address = Address.builder()
                                 .city(sellerRegisterRequest.getCity())
                                 .state(sellerRegisterRequest.getState())
                                 .country(sellerRegisterRequest.getCountry())
                                 .addressLine(sellerRegisterRequest.getAddressLine())
                                 .label(sellerRegisterRequest.getLabel())
                                 .zipCode(sellerRegisterRequest.getZipCode())
                                 .build();

        Role role = role_service.getOrCreateRole(E_Role.ROLE_SELLER);

        User user = User.builder()
                        .firstName(sellerRegisterRequest.getFirstName())
                        .lastName(sellerRegisterRequest.getLastName())
                        .middleName(sellerRegisterRequest.getMiddleName())
                        .email(sellerRegisterRequest.getEmail())
                        .password(passwordEncoder.encode (sellerRegisterRequest.getPassword()))
                        .passwordcreatedAt(LocalDateTime.now())
                        .isActive(Boolean.FALSE)
                        .isDeleted(Boolean.FALSE)
                        .isLocked(Boolean.FALSE)
                        .isExpired(Boolean.FALSE)
                        .AddressSet(Set.of(address))
                        .roles(Set.of(new Role()))
                        .build();

        Seller seller = Seller.builder()
                              .companyName(sellerRegisterRequest.getCompanyName())
                              .gstNo(sellerRegisterRequest.getGstNo())
                              .companyContact(sellerRegisterRequest.getCompanyContact())
                              .user(user)
                              .build();

        seller_repository.save(seller);

        String token = UUID.randomUUID().toString();

        emailSenderService.sendMail(
                sellerRegisterRequest.getEmail(),
                "Activate Your Account",
                "Please activate your account"
                                   );
        return "Seller Registered successfully" + "Please check your email to activate your profile";

    }
}



