package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.RegistrationService;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model.CustomerRegistrationRequest;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model.SellerRegistrationRequest;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Email.EmailSenderService.EmailSenderService;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain.*;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.CustomerRepository.CustomerRepository;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.SellerRepository.SellerRepository;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.ApplicationUserService.ApplicationUserService;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.RoleService.RoleService;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.UUID;

@Service
public class RegistrationService {
    private final ApplicationUserService application_user_service;
    private final CustomerRepository customer_repository;
    private final RoleService  role_service;
    private final SellerRepository seller_repository;
    private final EmailSenderService emailSenderService;

    public RegistrationService(
            ApplicationUserService application_user_service,
            CustomerRepository customer_repository,
            RoleService role_service, SellerRepository seller_repository,
            EmailSenderService emailSenderService
                              ) {
        this.application_user_service = application_user_service;
        this.customer_repository      = customer_repository;
        this.role_service             = role_service;
        this.seller_repository        = seller_repository;
        this.emailSenderService       = emailSenderService;
    }
    public String registerCustomer(CustomerRegistrationRequest customerRegisterRequest) {

        Address address = Address.builder()
                                 .City(customerRegisterRequest.getCity())
                                 .State(customerRegisterRequest.getState())
                                 .Country(customerRegisterRequest.getCountry())
                                 .addressLine(customerRegisterRequest.getAddress_Line())
                                 .Label(customerRegisterRequest.getLabel())
                                 .ZipCode(customerRegisterRequest.getZip_Code())
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
                        .AddressSet(Set.of(address))
                        .roles(Set.of(new Role()))
                        .build();

        Customer customer = Customer.builder()
                                    .Contact_No(customerRegisterRequest.getContact_Number())
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
                                 .City(sellerRegisterRequest.getCity())
                                 .State(sellerRegisterRequest.getState())
                                 .Country(sellerRegisterRequest.getCountry())
                                 .addressLine(sellerRegisterRequest.getAddress_Line())
                                 .Label(sellerRegisterRequest.getLabel())
                                 .ZipCode(sellerRegisterRequest.getZip_Code())
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
                        .AddressSet(Set.of(address))
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

        emailSenderService.sendMail(
                sellerRegisterRequest.getEmail(),
                "Activate Your Account",
                "Please activate your account"
                                   );
        return "Seller Registered successfully" + "Please check your email to activate your profile";

    }
}



