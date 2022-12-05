package com.DemoProjectECommerce.ECommerce.controllers.forgotpasswordcontroller;

import com.DemoProjectECommerce.ECommerce.model.passworddto.PasswordDto;
import com.DemoProjectECommerce.ECommerce.services.forgetandresetpassword.ForgetResetPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/register")
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
