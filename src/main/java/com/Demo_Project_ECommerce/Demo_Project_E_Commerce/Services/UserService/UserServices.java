package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.UserService;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Dto.PassReset;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Email.EmailSenderService.EmailSenderService;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Entities.User;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Repositories.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserServices
{
    @Autowired
    UserRepository     userRepository;
    @Autowired
    EmailSenderService emailSenderService;
    public String forgetPassword(String email) {
        User   user = userRepository.findByEmail(email).get();
        String tok  = UUID.randomUUID().toString();
        userRepository.save(user);
        emailSenderService.sendMail(email, "sending an email to updateyourpass", tok);
        return "token is sent check email.";
    }
    public String passwordReset(PassReset passReset){
        User user = userRepository.findByVerificationToken(passReset.getToken()).get();
        if(user!=null){
            if(passReset.getPassword().equals(passReset.getConfirmPassword())){
                user.setPassword(passReset.getPassword());
                userRepository.save(user);
                return "password updated";
            }
            return "password doesnot match";
        }
        return "user not found";
    }
}
