package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.UserService;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.Role;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.User;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.UserRepository.User_Repository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class User_Detail_Service_Impl implements UserDetailsService {

    private final User_Repository userRepository;

    public User_Detail_Service_Impl(User_Repository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userAuthentication = getUserByEmail(username);

        return new org.springframework.security.core.userdetails.User(userAuthentication.getEmail(),
                                                                      userAuthentication.getPassword(),
                                                                      true,
                                                                      true,
                                                                      true,
                                                                      true,
                                                                      getAuthority(userAuthentication.getRoles()));
    }

    private User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                             .orElseThrow(() -> new UsernameNotFoundException("No user found with email : " + email));
    }

    private Collection<? extends GrantedAuthority> getAuthority(Set<Role> roles) {
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName().toString()));
        }
        return authorities;
    }
}
