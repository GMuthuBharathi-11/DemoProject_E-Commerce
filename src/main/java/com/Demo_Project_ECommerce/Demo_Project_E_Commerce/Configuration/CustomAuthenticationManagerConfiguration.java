package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Configuration;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.CustomizeErrorHandling.ECommerceApplicationException;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain.Role;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain.User;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Email.EmailSenderService.EmailSenderService;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class CustomAuthenticationManagerConfiguration implements AuthenticationManager
{
    @Autowired
    UserRepository     userRepository;
    @Autowired
    EmailSenderService emailSenderService;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        User user = userRepository.findByEmail(username)
                                  .orElseThrow(() -> new ECommerceApplicationException("No User Found"));
//        if(userEntity==null){
//            throw new UsernameNotFoundException("Invalid credentials");
//        }
        if (user.getIsLocked()) {
            throw new BadCredentialsException("Account is locked"); // change the exception
        }
        if (!passwordEncoder.matches(password, user.getPassword())) {
            Integer counter = user.getInvalidAttemptCount();
            if (counter < 2) {
                user.setInvalidAttemptCount(++counter);
                userRepository.save(user);
            } else {
                user.setIsLocked(Boolean.TRUE);
                user.setInvalidAttemptCount(0);
                userRepository.save(user);
                emailSenderService.sendMail(user.getEmail(), "Account Locked", "You have" +
                                                                               "tried multiple times now your account is locked");

            }
            throw new BadCredentialsException("Invalid Credentials");
        }
        user.setInvalidAttemptCount(0); // reset counter on successful login
        userRepository.save(user);
        return new UsernamePasswordAuthenticationToken(username, password, getAuthority(user.getRoles()));
    }

//    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private Collection<? extends GrantedAuthority> getAuthority(Set<Role> roles) {
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName().toString()));
        }
        return authorities;
    }
}
