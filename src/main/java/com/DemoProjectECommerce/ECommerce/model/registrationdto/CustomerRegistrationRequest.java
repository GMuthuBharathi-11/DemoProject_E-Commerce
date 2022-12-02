package com.DemoProjectECommerce.ECommerce.model.registrationdto;
import com.DemoProjectECommerce.ECommerce.model.userdto.UserDetails;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class CustomerRegistrationRequest extends UserDetails
{
//    @NotNull
//    @Pattern(regexp = "[0-9]",message = "Incorrect phone number")
    private String contactNumber;

}
