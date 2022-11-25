package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Controllers;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Dto.PassReset;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.UserService.UserService;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.UserService.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateController{
    @Autowired
    UserServices userServices;

    @PutMapping("/UpdateToken")
    public void tokenUpdate ( @RequestParam String  email){

        userServices.forgetPassword(email);
    }

    @PostMapping("/resetPassword")
    public String resetPassword(@RequestBody PassReset passReset)
    {

        return userServices .passwordReset(passReset);
    }

}

