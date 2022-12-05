package com.DemoProjectECommerce.ECommerce.model.categorydto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MetaDataFieldDto
{
    private Long   id;
    @NotBlank(message = "MetaDataFieldName cannot be null")
    private String metaDataFieldName;
}
