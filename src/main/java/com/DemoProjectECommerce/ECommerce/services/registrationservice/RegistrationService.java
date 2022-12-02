package com.DemoProjectECommerce.ECommerce.services.registrationservice;
import com.DemoProjectECommerce.ECommerce.entity.entitybasic.*;
import com.DemoProjectECommerce.ECommerce.services.applicationUserservice.ApplicationUserService;
import com.DemoProjectECommerce.ECommerce.repositories.customerrepository.CustomerRepository;
import com.DemoProjectECommerce.ECommerce.repositories.sellerrepository.SellerRepository;
import com.DemoProjectECommerce.ECommerce.email.emailsenderservice.EmailSenderService;
import com.DemoProjectECommerce.ECommerce.repositories.userrepository.UserRepository;
import com.DemoProjectECommerce.ECommerce.model.registrationdto.CustomerRegistrationRequest;
import com.DemoProjectECommerce.ECommerce.services.roleservice.RoleService;
import com.DemoProjectECommerce.ECommerce.model.registrationdto.SellerRegistrationRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import javax.validation.Valid;
import java.util.Set;
import java.util.UUID;

@Service
public class RegistrationService
{
    private final ApplicationUserService applicationUserService;
    private final CustomerRepository customerRepository;
    private final EmailSenderService emailSenderService;
    private final SellerRepository sellerRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;
    public RegistrationService(
            ApplicationUserService applicationUserService,
            CustomerRepository customerRepository,UserRepository userRepository,
            RoleService roleService, SellerRepository sellerRepository,
            PasswordEncoder passwordEncoder,
            EmailSenderService emailSenderService)
    {
        this.applicationUserService = applicationUserService;
        this.customerRepository  = customerRepository;
        this.emailSenderService  = emailSenderService;
        this.sellerRepository = sellerRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleService  = roleService;
    }
    public String registerCustomer(@Valid CustomerRegistrationRequest customerRegisterRequest)
    {
        Address address = Address.builder()
                                 .city(customerRegisterRequest.getCity())
                                 .state(customerRegisterRequest.getState())
                                 .country(customerRegisterRequest.getCountry())
                                 .addressLine(customerRegisterRequest.getAddressLine())
                                 .label(customerRegisterRequest.getLabel())
                                 .zipCode(customerRegisterRequest.getZipCode())
                                 .build();

        Role role = roleService.getOrCreateRole(ERole.ROLE_CUSTOMER);

        User user = User.builder()
                        .firstName(customerRegisterRequest.getFirstName())
                        .lastName(customerRegisterRequest.getLastName())
                        .middleName(customerRegisterRequest.getMiddleName())
                        .email(customerRegisterRequest.getEmail())
                        .password(passwordEncoder.encode(customerRegisterRequest.getPassword()))
                        .passwordcreatedAt(LocalDateTime.now())
                        .isActive(Boolean.FALSE)
                        .isDeleted(Boolean.FALSE)
                        .isLocked(Boolean.FALSE)
                        .isExpired(Boolean.FALSE)
                        .addressSet(Set.of(address))
                        .roles(Set.of(role))
                        .build();

        Customer customer = Customer.builder()
                                    .phoneNumber(customerRegisterRequest.getContactNumber())
                                    .user(user)
                                    .build();
        customerRepository.save(customer);

        String token = UUID.randomUUID().toString();
        emailSenderService.sendMail(
                customerRegisterRequest.getEmail(),
                "Activate Your Account",
                "Please activate your account");
        return "Customer Registered Successfully"    +
               " Please check your email to activate your profile";
    }
    public String registerSeller(@Valid SellerRegistrationRequest sellerRegisterRequest)
    {
        Address address = Address.builder()
                                 .city(sellerRegisterRequest.getCity())
                                 .state(sellerRegisterRequest.getState())
                                 .country(sellerRegisterRequest.getCountry())
                                 .addressLine(sellerRegisterRequest.getAddressLine())
                                 .label(sellerRegisterRequest.getLabel())
                                 .zipCode(sellerRegisterRequest.getZipCode())
                                 .build();

        Role role = roleService.getOrCreateRole(ERole.ROLE_SELLER);

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
                        .addressSet(Set.of(address))
                        .roles(Set.of(role))
                        .build();

        Seller seller = Seller.builder()
                              .companyName(sellerRegisterRequest.getCompanyName())
                              .gstNo(sellerRegisterRequest.getGstNo())
                              .companyContact(sellerRegisterRequest.getCompanyContact())
                              .user(user)
                              .build();

        sellerRepository.save(seller);

        String token = UUID.randomUUID().toString();

        emailSenderService.sendMail(
                sellerRegisterRequest.getEmail(),
                "Activate Your Account",
                "Please activate your account");
        return "Seller Registered successfully"   +
               "Please check your email to activate your profile";
    }
}



