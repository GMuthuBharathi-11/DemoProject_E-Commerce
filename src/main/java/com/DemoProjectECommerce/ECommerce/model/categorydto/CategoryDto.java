package com.DemoProjectECommerce.ECommerce.model.categorydto;

import com.DemoProjectECommerce.ECommerce.entity.Category;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto
{
    private Long                  id;
    private String                name;
    private Category              parentCategory;
    private Set<ChildCategoryDto> childCategoryId;

}
