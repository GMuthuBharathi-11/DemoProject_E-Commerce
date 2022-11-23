package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.RegistrationService;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Dto.CustomerRegistrationRequest;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Dto.SellerRegistrationRequest;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.*;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.CustomerRepository.Customer_Repository;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.SellerRepository.Seller_Repository;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.ApplicationUserService.ApplicationUserService;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.RoleService.RoleService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class RegistrationService {
    private final ApplicationUserService application_user_service;
    private final Customer_Repository customer_repository;
    private final RoleService  role_service;

    private final Seller_Repository seller_repository;

    public RegistrationService(
            ApplicationUserService application_user_service,
            Customer_Repository customer_repository,
            RoleService role_service, Seller_Repository seller_repository
                              ) {
        this.application_user_service = application_user_service;
        this.customer_repository      = customer_repository;
        this.role_service             = role_service;
        this.seller_repository        = seller_repository;
    }


    public String registerCustomer(CustomerRegistrationRequest customerRegisterRequest) {

        Address address = Address.builder()
                                 .City(customerRegisterRequest.getCity())
                                 .State(customerRegisterRequest.getState())
                                 .Country(customerRegisterRequest.getCountry())
                                 .addressLine(customerRegisterRequest.getAddress_Line())
                                 .Label(customerRegisterRequest.getLabel())
                                 .Zip_Code(customerRegisterRequest.getZip_Code())
                                 .build();

             Role role = role_service.getOrCreateRole(E_Role.ROLE_CUSTOMER);

        User user = User.builder()
                        .firstName(customerRegisterRequest.getFirst_Name())
                        .lastName(customerRegisterRequest.getLast_Name())
                        .middleName(customerRegisterRequest.getMiddle_Name())
                        .email(customerRegisterRequest.getEmail())
                        .password(customerRegisterRequest.getPassword())
                        .isActive(Boolean.FALSE)
                        .isDeleted(Boolean.FALSE)
                        .isLocked(Boolean.FALSE)
                        .isExpired(Boolean.FALSE)
                        .addressset(Set.of(address))
                        .roles(Set.of(new Role()))
                        .build();

        Customer customer = Customer.builder()
                                    .Contact_No(customerRegisterRequest.getContact_Number())
                                    .User_Id(user.getId())
                                    .build();
        customer_repository.save(customer);

        String token = UUID.randomUUID().toString();


        return "Success";


    }

    public String registerSeller(SellerRegistrationRequest sellerRegisterRequest) {

        Address address = Address.builder()
                                 .City(sellerRegisterRequest.getCity())
                                 .State(sellerRegisterRequest.getState())
                                 .Country(sellerRegisterRequest.getCountry())
                                 .addressLine(sellerRegisterRequest.getAddress_Line())
                                 .Label(sellerRegisterRequest.getLabel())
                                 .Zip_Code(sellerRegisterRequest.getZip_Code())
                                 .build();

          Role role = role_service.getOrCreateRole(E_Role.ROLE_SELLER);

        User user = User.builder()
                        .firstName(sellerRegisterRequest.getFirst_Name())
                        .lastName(sellerRegisterRequest.getLast_Name())
                        .middleName(sellerRegisterRequest.getMiddle_Name())
                        .email(sellerRegisterRequest.getEmail())
                        .password(sellerRegisterRequest.getPassword())
                        .isActive(Boolean.FALSE)
                        .isDeleted(Boolean.FALSE)
                        .isLocked(Boolean.FALSE)
                        .isExpired(Boolean.FALSE)
                        .addressset(Set.of(address))
                        .roles(Set.of(new Role()))
                        .build();

        Seller seller = Seller.builder()
                              .Company_Name(sellerRegisterRequest.getCompany_Name())
                              .Gst_No(sellerRegisterRequest.getGst_No())
                              .Company_Contact(sellerRegisterRequest.getCompany_Contact())
                              .user(user)
                              .build();
        seller_repository.save(seller);

        String token = UUID.randomUUID().toString();

        return "success";

    }
}



