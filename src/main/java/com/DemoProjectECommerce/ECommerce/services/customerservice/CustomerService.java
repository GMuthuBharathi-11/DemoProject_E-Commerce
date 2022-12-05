package com.DemoProjectECommerce.ECommerce.services.customerservice;

import com.DemoProjectECommerce.ECommerce.customizehandling.ECommerceApplicationException;
import com.DemoProjectECommerce.ECommerce.entity.Address;
import com.DemoProjectECommerce.ECommerce.entity.Customer;
import com.DemoProjectECommerce.ECommerce.entity.User;
import com.DemoProjectECommerce.ECommerce.model.customerdto.AddressUpdateDto;
import com.DemoProjectECommerce.ECommerce.repositories.userrepository.UserRepository;
import com.DemoProjectECommerce.ECommerce.email.emailsenderservice.EmailSenderService;
import com.DemoProjectECommerce.ECommerce.model.customerdto.AddaddressDto;
import com.DemoProjectECommerce.ECommerce.model.userdto.UserProfileDto;
import com.DemoProjectECommerce.ECommerce.repositories.addressrepository.AddressRepository;
import com.DemoProjectECommerce.ECommerce.repositories.customerrepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;


@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EmailSenderService emailSenderService;
    @Autowired
    private UserRepository     userRepository;
    @Autowired
    private AddressRepository  addressRepository;


    public Customer findCustomer(Long Id) {
        Customer customer = customerRepository.findById(Id)
                                              .orElseThrow(() -> new ECommerceApplicationException("No user found " + "with id : " + Id));
        return customer;
    }


    public Page<Customer> findAllCustomers(Pageable pageable) {
        Page<Customer> result =  customerRepository.findAll(pageable);
        return result;
    }

    public String CustomerActivate(Long Id) {
        Customer customer = customerRepository.findById(Id)
                                              .orElseThrow(() -> new ECommerceApplicationException("No user found "
                                                                                                   + "with id : " + Id));
        if (customer.getUser().getIsActive().equals(Boolean.FALSE)) {
            customer.getUser().setIsActive(Boolean.TRUE);
            customerRepository.save(customer);

            emailSenderService.sendMail(
                    customer.getUser().getEmail(),
                    "Account is Activated",
                    "Account has been activated");
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
    public Customer getCustomerProfile(String name)
    {
        User user = userRepository.findByEmail(name)
                                  .orElseThrow(() -> new ECommerceApplicationException("No user found"));

        Customer customer = customerRepository.findByUser(user)
                                        .orElseThrow(() -> new ECommerceApplicationException("No user found"));
        return customer;
    }

    public Set<Address> getCustomerAddress(String email) {
        User user = userRepository.findByEmail(email)
                                        .orElseThrow(() -> new ECommerceApplicationException("No user found"));
        Set<Address> addresses = user.getAddressSet();
        return addresses;
    }

    public void UpdateMyprofile(String name, UserProfileDto userProfileDto) {

        User user = userRepository.findByEmail(name)
                                        .orElseThrow(() -> new ECommerceApplicationException("No user found"));

        Customer customer = customerRepository.findByUser(user)
                                        .orElseThrow(() -> new ECommerceApplicationException("No user found"));

        if (userProfileDto.getFirstName() != null)
            customer.getUser().setFirstName(userProfileDto.getFirstName());
        if (userProfileDto.getMiddleName() != null)
            customer.getUser().setMiddleName(userProfileDto.getMiddleName());
        if (userProfileDto.getLastName() != null)
            customer.getUser().setLastName(userProfileDto.getLastName());
        if (userProfileDto.getEmail() != null)
            customer.getUser().setEmail(userProfileDto.getEmail());
        if (userProfileDto.getContactNo() != null)
            customer.setPhoneNumber(userProfileDto.getContactNo());

        customerRepository.save(customer);

    }
    public String addAddress(String email, AddaddressDto addAddressDto){

        User user = userRepository.findByEmail(email)
                                        .orElseThrow(()->new ECommerceApplicationException("No user found"));

        Customer customer = customerRepository.findByUser(user)
                                        .orElseThrow(()->new ECommerceApplicationException("No user found"));

        Address address = Address.builder()
                                 .city(addAddressDto.getCity())
                                 .state(addAddressDto.getState())
                                 .country(addAddressDto.getCountry())
                                 .addressLine(addAddressDto.getAddressLine())
                                 .label(addAddressDto.getLabel())
                                 .zipCode(addAddressDto.getZipCode())
                                 .build();
        customer.getUser().getAddressSet().add(address);
        customerRepository.save(customer);
        return "Address added successfully";
    }
    public String UpdateMyAddress(long Id, String email, @Valid AddressUpdateDto addressUpdateDto){

        User user=userRepository.findByEmail(email)
                                            .orElseThrow(()->new ECommerceApplicationException("No User Found"));

        Customer customer =customerRepository.findByUser(user)
                                       .orElseThrow(()->new ECommerceApplicationException("No user Found"));

        Address address=addressRepository.findById(Id)
                                   .orElseThrow(()->new ECommerceApplicationException("No Address Found"));

        if (addressUpdateDto.getCity()!=null)
            address.setCity(addressUpdateDto.getCity());

        if (addressUpdateDto.getState()!=null)
            address.setState(addressUpdateDto.getState());

        if(addressUpdateDto.getLabel()!=null)
            address.setLabel(addressUpdateDto.getLabel());

        if(addressUpdateDto.getAddressLine()!=null)
            address.setAddressLine(addressUpdateDto.getAddressLine());

        if(addressUpdateDto.getZipCode()!=null)
            address.setZipCode(addressUpdateDto.getZipCode());

        if(addressUpdateDto.getCountry()!=null)
            address.setCountry(addressUpdateDto.getCountry());
        addressRepository.save(address);
        return "Address Updated Successfully";
    }
    public String DeleteAddress(Long Id, String email) {
        User user = userRepository.findByEmail(email)
                                        .orElseThrow(() -> new ECommerceApplicationException("No User Found"));
        Customer customer = customerRepository.findByUser(user)
                                              .orElseThrow(() -> new ECommerceApplicationException("No User Found"));
        Address address = addressRepository.findById(Id)
                                           .orElseThrow(() -> new ECommerceApplicationException("No Address Found"));
        addressRepository.delete(address);
        return "Address Deleted Successfully";
    }
}