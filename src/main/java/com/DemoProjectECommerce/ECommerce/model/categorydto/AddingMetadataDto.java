package com.DemoProjectECommerce.ECommerce.model.categorydto;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddingMetadataDto
{
    @NotBlank
    private Long   categoryId;

    @NotBlank
    private Long   metadataFeildId;

    private String value;

}
