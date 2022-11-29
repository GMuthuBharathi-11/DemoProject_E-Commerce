package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Controllers.SellerController;

import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Domain.Seller;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model.AddressUpdateDto;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model.UserProfileDto;
import com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Services.SellerService.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/seller")
public class SellerController {
    @Autowired
    private SellerService sellerService;
    @GetMapping("/get-profile")
    public ResponseEntity<Seller> SellerInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(sellerService.getSellerProfile(authentication.getName()));
    }

    @PutMapping("/update-address")
    public String SellerUpdateAddress(@RequestBody AddressUpdateDto addressUpdateDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        sellerService.updateMyAddress(authentication.getName(), addressUpdateDto);
        return "Address Updated Successfully";
    }

    @PutMapping("/update-profile")
    public String SellerUpdateProfile(@RequestBody UserProfileDto userProfileDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        sellerService.UpdateMyprofile(authentication.getName(), userProfileDto);
        return "Profile Updated Successfully";
    }
}




