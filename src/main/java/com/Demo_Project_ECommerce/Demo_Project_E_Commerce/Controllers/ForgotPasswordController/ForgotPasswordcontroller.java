package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Controllers.ForgotPasswordController;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Email.EmailSenderService.EmailSenderService;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.CustomerService.CustomerService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Component
public class ForgotPasswordcontroller
{
    @Autowired
    private EmailSenderService mailSender;

    @Autowired
    private CustomerService customerservice;
    @GetMapping("/forgot_password")
    public String showForgotPasswordForm(@RequestParam("email") String email) {


        return null;
    }



    @GetMapping("/reset_password")
    public String showResetPasswordForm() {
      return   null;
    }

}
