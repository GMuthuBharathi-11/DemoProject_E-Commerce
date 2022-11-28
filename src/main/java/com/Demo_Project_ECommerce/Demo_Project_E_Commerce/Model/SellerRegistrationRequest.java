package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class SellerRegistrationRequest extends UserDetails
{
    private String Gst_No;
    private String Company_Contact;
    private String Company_Name;
}
