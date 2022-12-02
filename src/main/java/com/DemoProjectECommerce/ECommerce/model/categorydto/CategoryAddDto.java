package com.DemoProjectECommerce.ECommerce.model.categorydto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryAddDto
{
    private String name;
    private Long   parentId;
}
