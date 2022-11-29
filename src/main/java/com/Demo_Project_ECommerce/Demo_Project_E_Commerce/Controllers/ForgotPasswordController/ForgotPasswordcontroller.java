package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Controllers.ForgotPasswordController;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Email.EmailSenderService.EmailSenderService;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model.PasswordDto;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.CustomerService.CustomerService;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.ForgetandResetPassword.ForgetResetPasswordService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/regiter")
public class ForgotPasswordcontroller
{
    @Autowired
    private ForgetResetPasswordService forgetResetPasswordService;
    @PostMapping("/UpdateToken")
    public String tokenUpdate( @RequestParam ("email") String email){

        return forgetResetPasswordService.forgetPassword(email);

    }

    @PutMapping("/ResetPassword/{Token}")
    public String resetToken(@PathVariable String Token, @RequestBody PasswordDto passwordDto){

        return forgetResetPasswordService.ResetPassword(Token,passwordDto);
    }
}
