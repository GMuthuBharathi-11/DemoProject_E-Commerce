package com.DemoProjectECommerce.ECommerce.model.categorydto;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
public class CategoryDto
{
    private Long                  id;
    private String                name;
    private CategoryDto           parentCategoryId;
    private Set<ChildCategoryDto> childCategoryId;
}
