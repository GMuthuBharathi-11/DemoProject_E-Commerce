package com.DemoProjectECommerce.ECommerce.model.registrationdto;
import com.DemoProjectECommerce.ECommerce.model.userdto.UserDetails;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@NoArgsConstructor
public class SellerRegistrationRequest extends UserDetails
{
//    @NotNull(message = "gstno cant be null")
    private String gstNo;
    @NotNull
    private String companyContact;
//    @NotNull(message = "messages cant be null")
    private String companyName;
}
