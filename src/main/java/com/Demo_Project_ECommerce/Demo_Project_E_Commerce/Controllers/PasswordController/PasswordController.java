//package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Controllers.PasswordController;
//import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model.PasswordDto;
//import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.ForgetandResetPassword.ForgetResetPasswordService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class PasswordController {
//
//    @Autowired
//    private ForgetResetPasswordService forgetAndResetPasswordService;
//
//    @PostMapping("/UpdateToken")
//    public String tokenUpdate(@RequestParam("email") String email) {
//
//        return forgetAndResetPasswordService.forgetPassword(email);
//
//    }
//
//    @PutMapping("/ResetPassword/{Token}")
//    public String resetToken(@PathVariable String Token, @RequestBody PasswordDto passwordDto) {
//
//        return forgetAndResetPasswordService.ResetPassword(Token, passwordDto);
//    }
//}