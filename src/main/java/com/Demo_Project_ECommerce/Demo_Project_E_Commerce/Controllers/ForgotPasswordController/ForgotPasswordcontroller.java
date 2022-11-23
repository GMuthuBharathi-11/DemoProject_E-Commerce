package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Controllers.ForgotPasswordController;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Email.EmailSenderService.Email_Sender_Service;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.CustomerService.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Component
public class ForgotPasswordcontroller
{
    @Autowired
    private Email_Sender_Service mailSender;

    @Autowired
    private CustomerService customerservice;
    @GetMapping("/forgot_password")
    public String showForgotPasswordForm() {

        return null;
    }

    @PostMapping("/forgot_password")
    public String processForgotPassword() {
        return null;
    }

    public void sendEmail(){

    }


    @GetMapping("/reset_password")
    public String showResetPasswordForm() {
      return   "forgot_password_form";
    }

    @PostMapping("/reset_password")
    public String processResetPassword() {

        return null;
    }
}
