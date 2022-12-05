package com.DemoProjectECommerce.ECommerce.model.categorydto;

import lombok.experimental.SuperBuilder;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@SuperBuilder
public class ChildCategoryDto
{
    private Long   id;
    private String name;
}
