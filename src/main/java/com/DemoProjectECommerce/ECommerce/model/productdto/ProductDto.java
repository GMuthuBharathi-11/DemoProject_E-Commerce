package com.DemoProjectECommerce.ECommerce.model.productdto;

import lombok.Data;

@Data
public class ProductDto
{
    private String name;
    private String brand;
    private Long   categoryId;
    private String description;
    private boolean is_cancelled;
    private boolean is_returnable;

}
