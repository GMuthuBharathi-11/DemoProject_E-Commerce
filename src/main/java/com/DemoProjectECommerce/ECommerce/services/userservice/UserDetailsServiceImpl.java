package com.DemoProjectECommerce.ECommerce.services.userservice;

import com.DemoProjectECommerce.ECommerce.entity.entitybasic.User;
import com.DemoProjectECommerce.ECommerce.repositories.userrepository.UserRepository;
import com.DemoProjectECommerce.ECommerce.entity.entitybasic.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private final UserRepository  userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDetailsServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository  = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User userAuthentication = getUserByEmail(username);
        User user = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(" No User "
                                                                                                         + "Found"));

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                                                                      true,
                                                                      true,
                                                                      true,
                                                                      true,
                                                                      getAuthority(user.getRoles()));


    }
        private Collection<? extends GrantedAuthority> getAuthority(Set<Role> roles)
        {
            ArrayList<GrantedAuthority> authorities = new ArrayList<>();
            for (Role role : roles) {
                authorities.add(new SimpleGrantedAuthority(role.getRoleName().toString()));
            }
            return authorities;
        }
    }
