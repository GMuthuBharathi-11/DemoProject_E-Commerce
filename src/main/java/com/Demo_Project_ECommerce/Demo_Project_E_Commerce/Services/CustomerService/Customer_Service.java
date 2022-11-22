//package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.CustomerService;
//
//import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.Customer;
//import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.Role;
//import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.User;
//import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.CustomerRepository.Customer_Repository;
//import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.UserRepository.User_Repository;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Service
//public class Customer_Service implements UserDetailsService {
//    private User_Repository userRepository;
//
//    private Customer_Repository customer_repository;
//
//    public void updateResetPasswordToken(String token, String email) throws CustomerNotFoundException {
//        Customer customer = customer_repository.findByEmail(email);
//        if (customer != null) {
//            customer.setResetPasswordToken(token);
//            customer_repository.save(customer);
////        } else {
////            throw new Customer("Could not find any customer with the email " + email);
//        }
//    }
//
//    public Customer getByResetPasswordToken(String token) {
//        return customer_repository.findByResetPasswordToken(token);
//    }
//
//    public void updatePassword(Customer customer, String newPassword) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String                encodedPassword = passwordEncoder.encode(newPassword);
//        customer.setPassword(encodedPassword);
//
//        customer.setResetPasswordToken(null);
//        customer_repository.save(customer);
//    }
//
//}
//
//        public Customer_Service(User_Repository userRepository) {
//             this.userRepository = userRepository;
//        }
//
//        @Override
//        public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
//             User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
//                                       .orElseThrow(() ->
//                                                            new UsernameNotFoundException("User not found with username or email:" + usernameOrEmail));
//             return new org.springframework.security.core.userdetails.User(user.getEmail(),
//                                                                           user.getPassword(), mapRolesToAuthorities(user.getRoles()));
//        }
//
//        private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
//             return roles.stream().map(role -> new SimpleGrantedAuthority(role.getAuthority())).collect(Collectors.toList());
//        }
//}
//
//
