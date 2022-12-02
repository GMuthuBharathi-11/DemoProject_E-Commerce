package com.DemoProjectECommerce.ECommerce.controllers.sellercontroller;

import com.DemoProjectECommerce.ECommerce.model.customerdto.AddressUpdateDto;
import com.DemoProjectECommerce.ECommerce.services.sellerservice.SellerService;
import com.DemoProjectECommerce.ECommerce.entity.entitybasic.Seller;
import com.DemoProjectECommerce.ECommerce.model.userdto.UserProfileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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
    public String SellerUpdateAddress(@Valid @RequestBody AddressUpdateDto addressUpdateDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        sellerService.updateMyAddress(authentication.getName(), addressUpdateDto);
        return "Address Updated Successfully";
    }

    @PutMapping("/update-profile")
    public String SellerUpdateProfile(@Valid @RequestBody UserProfileDto userProfileDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        sellerService.UpdateMyprofile(authentication.getName(), userProfileDto);
        return "Profile Updated Successfully";
    }

}




