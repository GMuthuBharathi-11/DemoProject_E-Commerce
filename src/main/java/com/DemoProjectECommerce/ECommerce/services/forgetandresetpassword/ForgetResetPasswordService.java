package com.DemoProjectECommerce.ECommerce.services.forgetandresetpassword;

import com.DemoProjectECommerce.ECommerce.customizehandling.ECommerceApplicationException;
import com.DemoProjectECommerce.ECommerce.entity.entitybasic.User;
import com.DemoProjectECommerce.ECommerce.model.passworddto.PasswordDto;
import com.DemoProjectECommerce.ECommerce.repositories.refreshtokenrepository.RefreshTokenRepository;
import com.DemoProjectECommerce.ECommerce.repositories.userrepository.UserRepository;
import com.DemoProjectECommerce.ECommerce.entity.entitybasic.RefreshToken;
import com.DemoProjectECommerce.ECommerce.email.emailsenderservice.EmailSenderService;
//import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.ImageModel.PasswordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ForgetResetPasswordService
{
    @Autowired
    private UserRepository         userRepository;
    @Autowired
    private EmailSenderService     emailSenderService;
    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    private final PasswordEncoder passwordEncoder;
    public ForgetResetPasswordService(PasswordEncoder passwordEncoder)
    {
        this.passwordEncoder = passwordEncoder;
    }
    public String forgetPassword(String email){

        User user=userRepository.findByEmail(email)
                                .orElseThrow(() -> new ECommerceApplicationException("No user found"));

        String Token= UUID.randomUUID().toString();

        RefreshToken refreshToken =new RefreshToken();
        refreshToken.setUser(user);
        refreshToken.setToken(Token);
        refreshToken.setCreatedAt(Instant.now());
        refreshToken.setExpiresAt(LocalDateTime.now().plusMinutes(15));

        refreshTokenRepository
                .save(refreshToken);

        emailSenderService.sendMail(email,"Update Your Password","please reset your password by using " +
                                                                 "the link http://localhost:8080/api/forget/ResetPassword/"+Token);

        return "Token is sent check  the mail";

    }

    public String ResetPassword(String Token, PasswordDto passwordDto){

        RefreshToken refreshToken= (RefreshToken) refreshTokenRepository.findByToken(Token)
                                                                        .orElseThrow(() -> new ECommerceApplicationException("No Token found"));
        User user=refreshToken.getUser();
        if(passwordDto.getPassword().equals(passwordDto.getConfirmPassword())) {
            restUserPassword(user.getEmail(), passwordDto.getPassword());
            emailSenderService.sendMail(user.getEmail(), "Password Updated", "Your Password Updated Successfully");
            return "Password Updated Successfully";
        }
        return "Password doesn't match";

    }
    private void restUserPassword(String email,String Password){
        User user=userRepository.findByEmail(email)
                                            .orElseThrow(() -> new ECommerceApplicationException("No user found"));
        user.setPassword(passwordEncoder.encode(Password));
        userRepository.save(user);
    }


}
