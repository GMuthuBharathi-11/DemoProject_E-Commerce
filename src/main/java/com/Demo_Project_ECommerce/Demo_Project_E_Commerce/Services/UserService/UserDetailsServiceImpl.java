package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.UserService;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.Role;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.User;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.UserRepository.UserRepository;
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
   private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDetailsServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User userAuthentication = getUserByEmail(username);

        return new org.springframework.security.core.userdetails.User(" Muthu",passwordEncoder.encode("Muthu$$1"),new ArrayList<>());
    }

//        return new org.springframework.security.core.userdetails.User(.getEmail(),
//                                                                      userAuthentication.getPassword(),
//                                                                      true,
//                                                                      true,
//                                                                      true,
//                                                                      true,
//                                                                      get(userAuthentication.getRoles()));
//    }

    private User getUserByEmail(String Email) {
        return userRepository.findByEmail(Email)
                             .orElseThrow(() -> new UsernameNotFoundException("No user found with  this Email : " + Email));
    }

    private Collection<? extends GrantedAuthority> getAuthority(Set<Role> roles) {
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName().toString()));
        }
        return authorities;
    }
}
