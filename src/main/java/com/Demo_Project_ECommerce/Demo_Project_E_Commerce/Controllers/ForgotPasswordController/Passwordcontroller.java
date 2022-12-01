package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Controllers.ForgotPasswordController;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model.PasswordDto;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.ForgetandResetPassword.ForgetResetPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/regiter")
public class Passwordcontroller
{
    @Autowired
    private ForgetResetPasswordService forgetResetPasswordService;
    @PostMapping("/UpdateToken")
    public String tokenUpdate( @RequestParam ("email") String email){

        return forgetResetPasswordService.forgetPassword(email);

    }

    @PutMapping("/ResetPassword/{Token}")
    public String resetToken(@PathVariable String Token, @Valid @RequestBody PasswordDto passwordDto){

        return forgetResetPasswordService.ResetPassword(Token,passwordDto);
    }
}
